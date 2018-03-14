/**
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.app.wechat.request;

import com.app.wechat.domain.WxUploadModel;
import com.app.wechat.internal.code.HttpMethod;
import com.app.wechat.internal.code.WxMediaType;
import com.app.wechat.internal.code.WxUrl;
import com.app.wechat.internal.util.WxUploadUtil;
import com.app.wechat.response.WxMediaUploadResponse;

/**
 * <p>功 能：新增临时素材API的请求信息</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月6日 下午6:54:14</p>
 * <br/>
 * <p>注意点：</p>
 * <ol>
 * <li>临时素材media_id是可复用的</li>
 * <li>媒体文件在微信后台保存时间为3天，即3天后media_id失效</li>
 * </ol>
 * <p>上传临时素材的格式、大小限制与公众平台官网一致：</p>
 * <ol>
 * <li>图片（image）: 2M，支持PNG\JPEG\JPG\GIF格式</li>
 * <li>语音（voice）：2M，播放长度不超过60s，支持AMR\MP3格式</li>
 * <li>视频（video）：10MB，支持MP4格式</li>
 * <li>缩略图（thumb）：64KB，支持JPG格式</li>
 * </ol>
 *
 * @author 王建
 * @version 1.0
 */
public class WxMediaUploadRequest extends AbstractWxRequest<WxMediaUploadResponse> {
    private static final long serialVersionUID = 1L;

    /**
     * 模拟表单form-data媒体文件标识对象
     */
    private WxUploadModel object;

    /**
     * 媒体文件类型
     */
    private WxMediaType mediaType;

    /**
     * @param pathName  待上传文件路径
     * @param mediaType 媒体文件类型
     */
    public WxMediaUploadRequest(String pathName, WxMediaType mediaType) {
        this.object = WxUploadUtil.getWxFormDataModel(pathName);
        this.mediaType = mediaType;
    }

    public Object getObject() {
        return object;
    }

    public Class<WxMediaUploadResponse> getResponseClass() {
        return WxMediaUploadResponse.class;
    }

    public String getUrl(String accessToken) {
        return String.format(WxUrl.API_MEDIA_UPLOAD, accessToken, mediaType.name().toLowerCase());
    }

    public HttpMethod getMethod() {
        return HttpMethod.POST_FORM;
    }
}