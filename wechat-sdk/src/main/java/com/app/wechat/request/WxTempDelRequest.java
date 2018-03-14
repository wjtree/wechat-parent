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
import com.app.wechat.internal.code.WxUrl;
import com.app.wechat.response.WxTempDelResponse;

/**
 * <p>功 能：模板消息-删除模板API的请求信息</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月5日 下午3:45:34</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxTempDelRequest extends AbstractWxRequest<WxTempDelResponse> {
    private static final long serialVersionUID = 1L;

    private JSONObject object;

    /**
     * @param templateId 公众帐号下模板消息ID
     */
    public WxTempDelRequest(String templateId) {
        JSONObject object = new JSONObject();
        object.put("template_id", templateId);
        this.object = object;
    }

    public JSONObject getObject() {
        return object;
    }

    public Class<WxTempDelResponse> getResponseClass() {
        return WxTempDelResponse.class;
    }

    public String getUrl(String accessToken) {
        return String.format(WxUrl.API_TEMPLATE_DEL_TEMPLATE, accessToken);
    }

    public HttpMethod getMethod() {
        return HttpMethod.POST;
    }
}