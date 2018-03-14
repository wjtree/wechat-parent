package com.app.wechat.request;

import com.app.wechat.internal.code.HttpMethod;
import com.app.wechat.internal.code.WxUrl;
import com.app.wechat.response.WxCustomGetResponse;

/**
 * <p>功 能：客服帐号管理-获取所有客服账号API的请求信息</p>
 * <p>描 述：开发者可以通过本接口为公众号添加客服账号，每个公众号最多添加10个客服账号</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月6日 下午6:53:48</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxCustomGetRequest extends AbstractWxRequest<WxCustomGetResponse> {
    private static final long serialVersionUID = 1L;

    public Class<WxCustomGetResponse> getResponseClass() {
        return WxCustomGetResponse.class;
    }

    public String getUrl(String accessToken) {
        return String.format(WxUrl.API_CUSTOMSERVICE_GETKFLIST, accessToken);
    }

    public HttpMethod getMethod() {
        return HttpMethod.GET;
    }
}