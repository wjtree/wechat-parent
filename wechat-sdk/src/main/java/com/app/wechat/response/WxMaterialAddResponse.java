package com.app.wechat.response;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * <p>功 能：新增其他类型永久素材API的响应结果</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月6日 下午6:54:14</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxMaterialAddResponse extends AbstractWxResponse {
    private static final long serialVersionUID = 1L;

    /**
     * 新增的永久素材的media_id
     */
    @JSONField(name = "media_id")
    private String mediaId;

    /**
     * 新增的图片素材的图片URL（仅新增图片素材时会返回该字段）
     */
    private String url;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}