package com.app.wechat.domain.msg;

import com.alibaba.fastjson.annotation.JSONField;
import com.app.wechat.domain.WxObject;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * <p>功 能：微信公众平台回复音乐消息API数据结构</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月14日 上午9:23:15</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxMusicMsgModel extends WxObject {
    private static final long serialVersionUID = 1L;

    /**
     * 音乐标题
     */
    @XStreamAlias("Title")
    private String title;

    /**
     * 音乐描述
     */
    @XStreamAlias("Description")
    private String description;

    /**
     * 音乐链接
     */
    @XStreamAlias("MusicUrl")
    @JSONField(name = "musicurl")
    private String musicUrl;

    /**
     * 高质量音乐链接，WIFI环境优先使用该链接播放音乐
     */
    @XStreamAlias("HQMusicUrl")
    @JSONField(name = "hqmusicurl")
    private String hqMusicUrl;

    /**
     * 缩略图的媒体id，通过素材管理中的接口上传多媒体文件，得到的id
     */
    @XStreamAlias("ThumbMediaId")
    @JSONField(name = "thumb_media_id")
    private String thumbMediaId;

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

    public String getMusicUrl() {
        return musicUrl;
    }

    public void setMusicUrl(String musicUrl) {
        this.musicUrl = musicUrl;
    }

    public String getHqMusicUrl() {
        return hqMusicUrl;
    }

    public void setHqMusicUrl(String hqMusicUrl) {
        this.hqMusicUrl = hqMusicUrl;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }
}