package com.app.wechat.domain.receive;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * <p>功 能：微信公众平台接收扫描带参数二维码事件推送API数据结构</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月13日 下午2:36:21</p>
 * @author 王建
 * @version 1.0
 */
public class WxRcvScanEvntDto extends WxRcvEvntDto {
    private static final long serialVersionUID = 1L;

    /** 事件KEY值 */
    @XStreamAlias("EventKey")
    private String eventKey;

    /** 二维码的ticket，可用来换取二维码图片 */
    @XStreamAlias("Ticket")
    private String ticket;

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
}