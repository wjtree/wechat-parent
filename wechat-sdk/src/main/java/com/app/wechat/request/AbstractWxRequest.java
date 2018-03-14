package com.app.wechat.request;

import com.app.wechat.internal.code.HttpMethod;
import com.app.wechat.response.AbstractWxResponse;

import java.io.Serializable;

/**
 * <p>功 能：微信公众平台API请求接口</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月14日 上午10:18:33</p>
 *
 * @author 王建
 * @version 1.0
 */
public abstract class AbstractWxRequest<T extends AbstractWxResponse> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 获取POST请求参数
     * <p>HTTP请求类型为POST时，需要重写该方法，返回请求对应的参数封装对象</p>
     * <p>HTTP请求类型为POST/FORM时，需要重写该方法，返回请求对应的待上传文件全路径名称</p>
     *
     * @return POST请求参数
     */
    public Object getObject() {
        return null;
    }

    /**
     * 获取API的响应结果类型
     *
     * @return 响应类型
     */
    public abstract Class<T> getResponseClass();

    /**
     * 获取API的请求地址
     *
     * @param accessToken 公众号的全局唯一接口调用凭据
     * @return API URL
     */
    public abstract String getUrl(String accessToken);

    /**
     * 获取API的请求方法
     *
     * @return HttpMethod
     */
    public abstract HttpMethod getMethod();
}