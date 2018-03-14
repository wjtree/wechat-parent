package com.app.wechat.domain.msg;

import com.alibaba.fastjson.annotation.JSONField;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * <p>功 能：微信公众平台回复视频消息API数据结构</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月14日 上午9:23:15</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxVideoMsgModel extends WxMediaModel {
    private static final long serialVersionUID = 1L;

    /**
     * 缩略图的媒体ID
     */
    @JSONField(name = "thumb_media_id")
    private String thumbMediaId;

    /**
     * 视频消息的标题
     */
    @XStreamAlias("Title")
    private String title;

    /**
     * 视频消息的描述
     */
    @XStreamAlias("Description")
    private String description;

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}