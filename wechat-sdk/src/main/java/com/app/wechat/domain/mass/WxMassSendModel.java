/**
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.app.wechat.domain.mass;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 群发消息-根据标签进行群发API
 *
 * @author wjtree
 * @version 1.0
 */
public class WxMassSendModel extends WxMassBaseModel {
    private static final long serialVersionUID = 1L;

    /**
     * 用于设定图文消息的接收者
     */
    private WxMassFilterModel filter;

    /**
     * 接收消息用户对应该公众号的openid数组
     */
    @JSONField(name = "touser")
    private String[] toUser;

    /**
     * 图文消息被判定为转载时，是否继续群发<br/>
     * 1为继续群发（转载），0为停止群发<br/>
     * 该参数默认为0
     */
    @JSONField(name = "send_ignore_reprint")
    private Short sendIgnoreReprint;

    /**
     * 开发者侧群发msgid，长度限制64字节<br/>
     * 如不填，则后台默认以群发范围和群发内容的摘要值做为clientmsgid
     */
    @JSONField(name = "clientmsgid")
    private String clientMsgId;

    public WxMassFilterModel getFilter() {
        return filter;
    }

    public void setFilter(WxMassFilterModel filter) {
        this.filter = filter;
    }

    public String[] getToUser() {
        return toUser;
    }

    public void setToUser(String[] toUser) {
        this.toUser = toUser;
    }

    public Short getSendIgnoreReprint() {
        return sendIgnoreReprint;
    }

    public void setSendIgnoreReprint(Short sendIgnoreReprint) {
        this.sendIgnoreReprint = sendIgnoreReprint;
    }

    public String getClientMsgId() {
        return clientMsgId;
    }

    public void setClientMsgId(String clientMsgId) {
        this.clientMsgId = clientMsgId;
    }
}