package com.app.wechat.domain.receive;

import com.app.wechat.domain.WxMsgDto;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * <p>功 能：微信公众平台接收事件推送API基础数据结构</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月10日 下午5:30:32</p>
 * @author 王建
 * @version 1.0
 */
public class WxRcvEvntDto extends WxMsgDto {
    private static final long serialVersionUID = 1L;

    /** 事件类型 */
    @XStreamAlias("Event")
    private String event;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}