package com.app.wechat.domain.receive;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * <p>功 能：微信公众平台接收普通图片消息API数据结构</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月13日 上午11:59:55</p>
 * @author 王建
 * @version 1.0
 */
public class WxRcvImgMsgDto extends WxRcvMsgDto {
    private static final long serialVersionUID = 1L;

    /** 图片链接（由系统生成） */
    @XStreamAlias("PicUrl")
    private String picUrl;

    /** 图片消息媒体id，可以调用多媒体文件下载接口拉取数据 */
    @XStreamAlias("MediaId")
    private String mediaId;

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}