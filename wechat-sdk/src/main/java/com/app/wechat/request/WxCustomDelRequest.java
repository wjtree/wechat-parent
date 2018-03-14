package com.app.wechat.request;

import com.app.wechat.domain.WxCustomModel;
import com.app.wechat.internal.code.HttpMethod;
import com.app.wechat.internal.code.WxUrl;
import com.app.wechat.response.WxCustomDelResponse;

/**
 * <p>功 能：客服帐号管理-删除客服帐号API的请求信息</p>
 * <p>描 述：开发者可以通过本接口为公众号添加客服账号，每个公众号最多添加10个客服账号</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月6日 下午6:53:48</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxCustomDelRequest extends AbstractWxRequest<WxCustomDelResponse> {
    private static final long serialVersionUID = 1L;

    private WxCustomModel object;

    public WxCustomDelRequest(WxCustomModel object) {
        this.object = object;
    }

    public WxCustomModel getObject() {
        return object;
    }

    public Class<WxCustomDelResponse> getResponseClass() {
        return WxCustomDelResponse.class;
    }

    public String getUrl(String accessToken) {
        return String.format(WxUrl.API_CUSTOMSERVICE_KFACCOUNT_DEL, accessToken);
    }

    public HttpMethod getMethod() {
        return HttpMethod.POST;
    }
}