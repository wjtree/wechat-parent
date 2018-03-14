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
import com.app.wechat.internal.code.WxIndustry;
import com.app.wechat.internal.code.WxUrl;
import com.app.wechat.response.WxTempSetIndResponse;

/**
 * <p>功 能：模板消息-设置所属行业API的请求信息</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月5日 下午3:45:34</p>
 * <br/>
 * <p>请注意：设置行业可在微信公众平台后台完成，每月可修改行业1次，帐号仅可使用所属行业中相关的模板</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxTempSetIndRequest extends AbstractWxRequest<WxTempSetIndResponse> {
    private static final long serialVersionUID = 1L;

    private JSONObject object;

    public WxTempSetIndRequest(WxIndustry ind1, WxIndustry ind2) {
        JSONObject object = new JSONObject();
        object.put("industry_id1", ind1.getCode());
        object.put("industry_id2", ind2.getCode());
        this.object = object;
    }

    public JSONObject getObject() {
        return object;
    }

    public Class<WxTempSetIndResponse> getResponseClass() {
        return WxTempSetIndResponse.class;
    }

    public String getUrl(String accessToken) {
        return String.format(WxUrl.API_TEMPLATE_SET_INDUSTRY, accessToken);
    }

    public HttpMethod getMethod() {
        return HttpMethod.POST;
    }
}