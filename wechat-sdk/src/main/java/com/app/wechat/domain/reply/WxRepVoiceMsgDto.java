package com.app.wechat.domain.reply;

import com.app.wechat.domain.WxMsgDto;
import com.app.wechat.domain.msg.WxVoiceMsgModel;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * <p>功 能：微信公众平台被动回复语音消息公共属性</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月10日 下午5:30:32</p>
 * @author 王建
 * @version 1.0
 */
public class WxRepVoiceMsgDto extends WxMsgDto {
    private static final long serialVersionUID = 1L;

    @XStreamAlias("Voice")
    private WxVoiceMsgModel voice;

    public WxVoiceMsgModel getVoice() {
        return voice;
    }

    public void setVoice(WxVoiceMsgModel voice) {
        this.voice = voice;
    }
}