package com.app.wechat.domain.receive;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * <p>功 能：微信公众平台接收自定义菜单事件推送API数据结构</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月13日 下午2:36:21</p>
 * @author 王建
 * @version 1.0
 */
public class WxRcvMenuEvntDto extends WxRcvEvntDto {
    private static final long serialVersionUID = 1L;

    /** 事件KEY值 */
    @XStreamAlias("EventKey")
    private String eventKey;

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }
}