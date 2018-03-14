package com.app.wechat.domain.receive;

import com.app.wechat.domain.WxMsgDto;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * <p>功 能：微信公众平台接收普通消息API基础数据结构</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月10日 下午5:30:32</p>
 * @author 王建
 * @version 1.0
 */
public class WxRcvMsgDto extends WxMsgDto {
    private static final long serialVersionUID = 1L;

    /** 消息id，64位整型，用于接收消息的排重 */
    @XStreamAlias("MsgId")
    private String msgId;

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
}