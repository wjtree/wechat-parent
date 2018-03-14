package com.app.wechat.domain.msg;

import com.alibaba.fastjson.annotation.JSONField;
import com.app.wechat.domain.WxObject;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * <p>功 能：微信公众平台多媒体消息API公共属性</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月14日 上午9:23:15</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxMediaModel extends WxObject {
    private static final long serialVersionUID = 1L;

    /**
     * 媒体id，可以调用多媒体文件下载接口拉取数据
     */
    @JSONField(name = "media_id")
    @XStreamAlias("MediaId")
    private String mediaId;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}