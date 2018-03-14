package com.app.wechat.request;

import com.app.wechat.domain.msg.WxNewsMsgModel;
import com.app.wechat.internal.code.HttpMethod;
import com.app.wechat.internal.code.WxUrl;
import com.app.wechat.response.WxMediaUploadNewsResponse;

/**
 * <p>功 能：群发消息-上传图文消息素材API的请求信息</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月6日 下午6:53:48</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxMediaUploadNewsRequest extends AbstractWxRequest<WxMediaUploadNewsResponse> {
    private static final long serialVersionUID = 1L;

    private WxNewsMsgModel object;

    public WxMediaUploadNewsRequest(WxNewsMsgModel object) {
        this.object = object;
    }

    public WxNewsMsgModel getObject() {
        return object;
    }

    public Class<WxMediaUploadNewsResponse> getResponseClass() {
        return WxMediaUploadNewsResponse.class;
    }

    public String getUrl(String accessToken) {
        return String.format(WxUrl.API_MEDIA_UPLOADNEWS, accessToken);
    }

    public HttpMethod getMethod() {
        return HttpMethod.POST;
    }
}