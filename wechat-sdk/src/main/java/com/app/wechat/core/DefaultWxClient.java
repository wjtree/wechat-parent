package com.app.wechat.core;

import com.alibaba.fastjson.JSON;
import com.app.wechat.domain.WxUploadModel;
import com.app.wechat.internal.code.HttpMethod;
import com.app.wechat.internal.code.Status;
import com.app.wechat.internal.exception.WxApiException;
import com.app.wechat.internal.util.HttpUtil;
import com.app.wechat.request.AbstractWxRequest;
import com.app.wechat.response.AbstractWxResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * <p>功 能：微信公众平台API统一请求接口默认实现</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月14日 上午11:22:39</p>
 *
 * @author 王建
 * @version 1.0
 */
public class DefaultWxClient implements WxClient {
    private static final Logger LOG = LogManager.getLogger(DefaultWxClient.class);

    /**
     * 微信公众号开发者ID
     */
    private String appId;

    /**
     * 微信公众号开发者密钥
     */
    private String appSecret;

    /**
     * 微信公众号接口调用凭证管理器
     */
    private AbstractWxAccessToken tokenMng;

    public DefaultWxClient(String appId, String appSecret) {
        this(appId, appSecret, null);
    }

    public DefaultWxClient(String appId, String appSecret, AbstractWxAccessToken tokenMng) {
        this.appId = appId;
        this.appSecret = appSecret;

        // 如果初始化传入凭证管理器实现对象，则使用默认的凭证管理器 DefaultWxAccessToken
        if (this.tokenMng == null) {
            if (tokenMng != null)
                this.tokenMng = tokenMng;
            else
                this.tokenMng = DefaultWxAccessToken.getInstance();
        }
    }

    public <T extends AbstractWxResponse> T execute(AbstractWxRequest<T> request) throws WxApiException {
        T tRsp = null;

        try {
            // 获取接口调用凭证
            String token = tokenMng.getToken(appId, appSecret);
            if (StringUtils.isBlank(token))
                throw new WxApiException("获取接口调用凭证失败");

            // 获取请求参数
            String url = request.getUrl(token);
            HttpMethod method = request.getMethod();
            Object object = request.getObject();
            Class<T> clazz = request.getResponseClass();

            // 发起HTTP请求，并获取请求结果
            String result = doRequest(method, url, object);
            // 将请求结果字符串转换为对应的业务实体对象
            tRsp = (StringUtils.isNotBlank(result) ? JSON.parseObject(result, clazz) : null);

            if (tRsp != null) {
                // 如果返回码是空的或是“0”，表示API请求成功，返回结果有效
                boolean rsFlag = StringUtils.equalsAny(tRsp.getErrCode(), Status.SUCCESS.getStatus(), null);

                // 如果请求失败，则抛出接口调用凭证API返回的错误信息
                if (!rsFlag)
                    throw new WxApiException(tRsp.getErrCode(), tRsp.getErrMsg());
            }
        } catch (Exception e) {
            LOG.error("微信公众平台API请求出错", e);
        }

        return tRsp;
    }

    /**
     * 根据不同的Http Method，发送HTTP请求，获取API请求结果
     *
     * @param method 请求方法，GET或POST
     * @param url    请求地址
     * @param object 请求参数
     * @return 请求结果
     * @throws Exception 自定义异常
     */
    private String doRequest(HttpMethod method, String url, Object object) throws Exception {
        String result = null;

        if (HttpMethod.GET.equals(method)) {
            result = HttpUtil.httpGet(url);

        } else if (HttpMethod.POST.equals(method)) {
            // 将API业务对象转换为JSON字符串
            String param = (object != null ? JSON.toJSONString(object) : null);
            if (LOG.isInfoEnabled())
                LOG.info("微信公众平台API [POST] 请求参数：{}", param);

            result = HttpUtil.httpPostJson(url, param);

        } else if (HttpMethod.POST_FORM.equals(method)) {
            if (LOG.isInfoEnabled())
                LOG.info("微信公众平台API [POST/FORM] 请求参数：{}", JSON.toJSONString(object));

            // 此处object可能是WxFormDataModel对象实例，也可能是文件路径的字符串
            if (object instanceof WxUploadModel) {
                WxUploadModel model = (WxUploadModel) object;
                result = HttpUtil.httpPostForm(url, model.getName(), model.getFile(), model.getFormData());
            } else {
                String pathName = String.valueOf(object);
                result = HttpUtil.httpPostForm(url, pathName);
            }
        }

        if (LOG.isInfoEnabled())
            LOG.info("微信公众平台API请求结果：{}", result);

        return result;
    }
}