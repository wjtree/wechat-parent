/**
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.app.wechat.request;

import com.app.wechat.domain.msg.WxNewsMsgModel;
import com.app.wechat.internal.code.HttpMethod;
import com.app.wechat.internal.code.WxUrl;
import com.app.wechat.response.WxMaterialAddNewsResponse;

/**
 * <p>功 能：新增永久图文素材API的请求信息</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月6日 下午6:53:48</p>
 * <br/>
 * <p>请注意：</p>
 * <ol>
 * <li>图文消息的具体内容中，微信后台将过滤外部的图片链接，图片url需通过"上传图文消息内的图片获取URL"接口上传图片获取</li>
 * <li>图文消息支持正文中插入自己帐号和其他公众号已群发文章链接的能力</li>
 * </ol>
 *
 * @author 王建
 * @version 1.0
 */
public class WxMaterialAddNewsRequest extends AbstractWxRequest<WxMaterialAddNewsResponse> {
    private static final long serialVersionUID = 1L;

    private WxNewsMsgModel object;

    public WxMaterialAddNewsRequest(WxNewsMsgModel object) {
        this.object = object;
    }

    public WxNewsMsgModel getObject() {
        return object;
    }

    public Class<WxMaterialAddNewsResponse> getResponseClass() {
        return WxMaterialAddNewsResponse.class;
    }

    public String getUrl(String accessToken) {
        return String.format(WxUrl.API_MATERIAL_ADD_NEWS, accessToken);
    }

    public HttpMethod getMethod() {
        return HttpMethod.POST;
    }
}