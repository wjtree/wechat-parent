/**
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.app.wechat.response;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * <p>功 能：群发消息-查询群发消息发送状态API的请求信息</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月6日 下午6:53:48</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxMassGetResponse extends AbstractWxResponse {
    private static final long serialVersionUID = 1L;

    /**
     * 群发消息后返回的消息id
     */
    @JSONField(name = "msg_id")
    private Long msgId;

    /**
     * 消息发送后的状态，SEND_SUCCESS表示发送成功
     */
    @JSONField(name = "msg_status")
    private String msgStatus;

    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }

    public String getMsgStatus() {
        return msgStatus;
    }

    public void setMsgStatus(String msgStatus) {
        this.msgStatus = msgStatus;
    }
}