/**
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.app.wechat.request;

import com.app.wechat.internal.code.HttpMethod;
import com.app.wechat.internal.code.WxUrl;
import com.app.wechat.response.WxTempGetResponse;

/**
 * <p>功 能：模板消息-获取模板列表API的请求信息</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月5日 下午3:45:34</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxTempGetRequest extends AbstractWxRequest<WxTempGetResponse> {
    private static final long serialVersionUID = 1L;

    public Class<WxTempGetResponse> getResponseClass() {
        return WxTempGetResponse.class;
    }

    public String getUrl(String accessToken) {
        return String.format(WxUrl.API_TEMPLATE_GET_TEMPLATE, accessToken);
    }

    public HttpMethod getMethod() {
        return HttpMethod.GET;
    }
}