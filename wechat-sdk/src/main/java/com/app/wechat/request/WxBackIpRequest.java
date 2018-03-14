package com.app.wechat.request;

import com.app.wechat.internal.code.HttpMethod;
import com.app.wechat.internal.code.WxUrl;
import com.app.wechat.response.WxBackIpResponse;

/**
 * <p>功 能：微信服务器IP地址列表API的请求信息</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月5日 下午3:45:34</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxBackIpRequest extends AbstractWxRequest<WxBackIpResponse> {
    private static final long serialVersionUID = 1L;

    public Class<WxBackIpResponse> getResponseClass() {
        return WxBackIpResponse.class;
    }

    public String getUrl(String accessToken) {
        return String.format(WxUrl.API_CALL_BACK_IP, accessToken);
    }

    public HttpMethod getMethod() {
        return HttpMethod.GET;
    }
}