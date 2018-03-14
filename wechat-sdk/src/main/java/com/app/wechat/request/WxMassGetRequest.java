/**
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.app.wechat.request;

import com.app.wechat.domain.mass.WxMassModel;
import com.app.wechat.internal.code.HttpMethod;
import com.app.wechat.internal.code.WxUrl;
import com.app.wechat.internal.util.WxMassUtil;
import com.app.wechat.response.WxMassGetResponse;

/**
 * <p>功 能：群发消息-查询群发消息发送状态API的请求信息</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月6日 下午6:53:48</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxMassGetRequest extends AbstractWxRequest<WxMassGetResponse> {
    private static final long serialVersionUID = 1L;

    private WxMassModel object;

    public WxMassGetRequest(Long msgId) {
        this.object = WxMassUtil.getWxMassModel(msgId);
    }

    public WxMassModel getObject() {
        return object;
    }

    public Class<WxMassGetResponse> getResponseClass() {
        return WxMassGetResponse.class;
    }

    public String getUrl(String accessToken) {
        return String.format(WxUrl.API_MESSAGE_MASS_GET, accessToken);
    }

    public HttpMethod getMethod() {
        return HttpMethod.POST;
    }
}