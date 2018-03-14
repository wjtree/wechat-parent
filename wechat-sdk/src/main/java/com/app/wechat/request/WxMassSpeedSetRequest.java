/**
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.app.wechat.request;

import com.alibaba.fastjson.JSONObject;
import com.app.wechat.internal.code.HttpMethod;
import com.app.wechat.internal.code.WxMassSpeed;
import com.app.wechat.internal.code.WxUrl;
import com.app.wechat.response.WxMassSpeedSetResponse;

/**
 * <p>功 能：设置群发速度API的请求信息</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月5日 下午3:45:34</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxMassSpeedSetRequest extends AbstractWxRequest<WxMassSpeedSetResponse> {
    private static final long serialVersionUID = 1L;

    private JSONObject object;

    public WxMassSpeedSetRequest(WxMassSpeed speed) {
        JSONObject object = new JSONObject();
        object.put("speed", speed.getSpeed());
        this.object = object;
    }

    public JSONObject getObject() {
        return object;
    }

    public Class<WxMassSpeedSetResponse> getResponseClass() {
        return WxMassSpeedSetResponse.class;
    }

    public String getUrl(String accessToken) {
        return String.format(WxUrl.API_MESSAGE_MASS_SPEED_SET, accessToken);
    }

    public HttpMethod getMethod() {
        return HttpMethod.POST;
    }
}