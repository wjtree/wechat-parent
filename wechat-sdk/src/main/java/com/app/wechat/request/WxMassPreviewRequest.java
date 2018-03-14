/**
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.app.wechat.request;

import com.app.wechat.domain.mass.WxMassPreviewModel;
import com.app.wechat.internal.code.HttpMethod;
import com.app.wechat.internal.code.WxUrl;
import com.app.wechat.response.WxMassPreviewResponse;

/**
 * <p>功 能：群发消息-预览接口API的响应信息</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月6日 下午6:53:48</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxMassPreviewRequest extends AbstractWxRequest<WxMassPreviewResponse> {
    private static final long serialVersionUID = 1L;

    private WxMassPreviewModel object;

    public WxMassPreviewRequest(WxMassPreviewModel object) {
        this.object = object;
    }

    public WxMassPreviewModel getObject() {
        return object;
    }

    public Class<WxMassPreviewResponse> getResponseClass() {
        return WxMassPreviewResponse.class;
    }

    public String getUrl(String accessToken) {
        return String.format(WxUrl.API_MESSAGE_MASS_PREVIEW, accessToken);
    }

    public HttpMethod getMethod() {
        return HttpMethod.POST;
    }
}