package com.app.wechat.response;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * <p>功 能：群发消息-上传图文消息素材API的响应结果</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月6日 下午6:54:14</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxMediaUploadNewsResponse extends AbstractWxResponse {
    private static final long serialVersionUID = 1L;

    /**
     * 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb），图文消息（news）
     */
    private String type;

    /**
     * 媒体文件/图文消息上传后获取的唯一标识
     */
    @JSONField(name = "media_id")
    private String mediaId;

    /**
     * 媒体文件上传时间，10位时间戳格式
     */
    @JSONField(name = "created_at")
    private String createdAt;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}