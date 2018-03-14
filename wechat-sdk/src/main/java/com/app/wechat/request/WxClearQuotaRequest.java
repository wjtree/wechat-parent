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
import com.app.wechat.response.WxClearQuotaResponse;

/**
 * <p>功 能：公众号的所有接口调用次数清零API的请求信息</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月5日 下午3:45:34</p>
 * <br/>
 * <p>请注意：</p>
 * <ol>
 * <li>由于指标计算方法或统计时间差异，实时调用量数据可能会出现误差，一般在1%以内</li>
 * <li>每个帐号每月共10次清零操作机会，清零生效一次即用掉一次机会（10次包括了平台上的清零和调用接口API的清零）</li>
 * <li>第三方帮助公众号调用时，实际上是在消耗公众号自身的quota</li>
 * <li>每个有接口调用限额的接口都可以进行清零操作</li>
 * </ol>
 *
 * @author 王建
 * @version 1.0
 */
public class WxClearQuotaRequest extends AbstractWxRequest<WxClearQuotaResponse> {
    private static final long serialVersionUID = 1L;

    private JSONObject object;

    public WxClearQuotaRequest(String appId) {
        JSONObject object = new JSONObject();
        object.put("appid", appId);
        this.object = object;
    }

    public JSONObject getObject() {
        return object;
    }

    public Class<WxClearQuotaResponse> getResponseClass() {
        return WxClearQuotaResponse.class;
    }

    public String getUrl(String accessToken) {
        return String.format(WxUrl.API_CLEAR_QUOTA, accessToken);
    }

    public HttpMethod getMethod() {
        return HttpMethod.POST;
    }
}