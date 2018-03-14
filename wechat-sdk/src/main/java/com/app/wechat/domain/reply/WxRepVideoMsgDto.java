package com.app.wechat.domain.reply;

import com.app.wechat.domain.WxMsgDto;
import com.app.wechat.domain.msg.WxVideoMsgModel;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * <p>功 能：微信公众平台被动回复视频消息公共属性</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月10日 下午5:30:32</p>
 * @author 王建
 * @version 1.0
 */
public class WxRepVideoMsgDto extends WxMsgDto {
    private static final long serialVersionUID = 1L;

    @XStreamAlias("Video")
    private WxVideoMsgModel video;

    public WxVideoMsgModel getVideo() {
        return video;
    }

    public void setVideo(WxVideoMsgModel video) {
        this.video = video;
    }
}