package com.app.wechat.core;

import com.alibaba.fastjson.JSON;
import com.app.wechat.domain.WxAccTokenDto;
import com.app.wechat.internal.code.Status;
import com.app.wechat.internal.code.WxUrl;
import com.app.wechat.internal.exception.WxApiException;
import com.app.wechat.internal.util.HttpUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * <p>功 能：微信公众号接口调用凭证管理器抽象类</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月3日 下午3:19:32</p>
 *
 * @author 王建
 * @version 1.0
 */
public abstract class AbstractWxAccessToken {
    protected static final Logger LOG = LogManager.getLogger(AbstractWxAccessToken.class);

    /**
     * 调用API获取接口调用凭证
     *
     * @param appId     开发者ID
     * @param appSecret 开发者密钥
     * @return accessToken 接口调用凭证
     * @throws WxApiException
     */
    protected static String requestToken(String appId, String appSecret) throws WxApiException {
        String token = null;

        try {
            // 获取请求地址
            String url = String.format(WxUrl.API_ACCESS_TOKEN, appId, appSecret);
            // 执行HTTP GET请求，返回请求结果
            String result = HttpUtil.httpGet(url);

            if (LOG.isInfoEnabled())
                LOG.info("获取接口调用凭证API请求结果：{}，appId：{}", result, appId);

            // 将结果字符串转换为JavaBean
            WxAccTokenDto dto = (StringUtils.isNotBlank(result) ? JSON.parseObject(result, WxAccTokenDto.class) : null);

            if (dto != null) {
                // 如果返回码是空的或是“0”，表示API请求成功，返回结果有效
                boolean rsFlag = StringUtils.equalsAny(dto.getErrCode(), Status.SUCCESS.getStatus(), null);

                // 如果请求成功，则返回接口调用凭证；如果请求失败，则抛出API返回的错误信息
                if (rsFlag)
                    token = dto.getAccessToken();
                else
                    throw new WxApiException(dto.getErrCode(), dto.getErrMsg());
            }
        } catch (Exception e) {
            LOG.error("调用API获取接口调用凭证出错", e);
        }

        return token;
    }

    /**
     * 获取接口调用凭证
     * <p>该方法需要实现在凭证即将过期时，主动刷新凭证的逻辑</p>
     *
     * @param appId     开发者ID
     * @param appSecret 开发者密钥
     * @return accessToken 接口调用凭证
     * @throws WxApiException
     */
    public abstract String getToken(String appId, String appSecret) throws WxApiException;

    /**
     * 刷新接口调用凭证
     * <p>该方法用于当微信公众平台的接口调用凭证有效期发生变更时，被动刷新凭证，并存储</p>
     *
     * @param appId     开发者ID
     * @param appSecret 开发者密钥
     * @return accessToken 接口调用凭证
     * @throws WxApiException
     */
    public abstract String refreshToken(String appId, String appSecret) throws WxApiException;
}