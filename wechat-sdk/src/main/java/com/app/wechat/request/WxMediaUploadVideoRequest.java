package com.app.wechat.request;

import com.app.wechat.domain.msg.WxVideoMsgModel;
import com.app.wechat.internal.code.HttpMethod;
import com.app.wechat.internal.code.WxUrl;
import com.app.wechat.response.WxMediaUploadVideoResponse;

/**
 * <p>功 能：上传视频素材API的请求信息</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月6日 下午6:53:48</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxMediaUploadVideoRequest extends AbstractWxRequest<WxMediaUploadVideoResponse> {
    private static final long serialVersionUID = 1L;

    private WxVideoMsgModel object;

    public WxMediaUploadVideoRequest(WxVideoMsgModel object) {
        this.object = object;
    }

    public WxVideoMsgModel getObject() {
        return object;
    }

    public Class<WxMediaUploadVideoResponse> getResponseClass() {
        return WxMediaUploadVideoResponse.class;
    }

    public String getUrl(String accessToken) {
        return String.format(WxUrl.API_MEDIA_UPLOADVIDEO, accessToken);
    }

    public HttpMethod getMethod() {
        return HttpMethod.POST;
    }
}