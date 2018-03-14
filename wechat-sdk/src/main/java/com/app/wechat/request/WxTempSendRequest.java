/**
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.app.wechat.request;

import com.app.wechat.domain.WxTempSendModel;
import com.app.wechat.internal.code.HttpMethod;
import com.app.wechat.internal.code.WxUrl;
import com.app.wechat.response.WxTempSendResponse;

/**
 * <p>功 能：模板消息-发送模板消息API的请求信息</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月5日 下午3:45:34</p>
 * <br/>
 * <p>请注意：设置行业可在微信公众平台后台完成，每月可修改行业1次，帐号仅可使用所属行业中相关的模板</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxTempSendRequest extends AbstractWxRequest<WxTempSendResponse> {
    private static final long serialVersionUID = 1L;

    private WxTempSendModel object;

    public WxTempSendRequest(WxTempSendModel object) {
        this.object = object;
    }

    public WxTempSendModel getObject() {
        return object;
    }

    public Class<WxTempSendResponse> getResponseClass() {
        return WxTempSendResponse.class;
    }

    public String getUrl(String accessToken) {
        return String.format(WxUrl.API_TEMPLATE_SEND, accessToken);
    }

    public HttpMethod getMethod() {
        return HttpMethod.POST;
    }
}