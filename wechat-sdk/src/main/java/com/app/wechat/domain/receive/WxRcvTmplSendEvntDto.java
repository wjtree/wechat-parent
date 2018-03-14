package com.app.wechat.domain.receive;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * <p>功 能：微信公众平台接收模板消息结果事件推送API数据结构</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月13日 下午2:36:21</p>
 * @author 王建
 * @version 1.0
 */
public class WxRcvTmplSendEvntDto extends WxRcvEvntDto {
    private static final long serialVersionUID = 1L;

    /** 模板消息ID */
    @XStreamAlias("MsgID")
    private String msgID;

    /** 模板发送状态 */
    @XStreamAlias("Status")
    private String status;

    public String getMsgID() {
        return msgID;
    }

    public void setMsgID(String msgID) {
        this.msgID = msgID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}