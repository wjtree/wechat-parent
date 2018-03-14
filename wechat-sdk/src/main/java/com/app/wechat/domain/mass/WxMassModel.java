/**
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.app.wechat.domain.mass;

import com.alibaba.fastjson.annotation.JSONField;
import com.app.wechat.domain.WxObject;

/**
 * 群发消息-根据标签进行群发API
 *
 * @author wjtree
 * @version 1.0
 */
public class WxMassModel extends WxObject {
    private static final long serialVersionUID = 1L;

    /**
     * 发送出去的消息ID
     */
    @JSONField(name = "msg_id")
    private Long msgId;

    /**
     * 要删除的文章在图文消息中的位置<br/>
     * 第一篇编号为1，该字段不填或填0会删除全部文章
     */
    @JSONField(name = "article_idx")
    private Short articleIdx;

    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }

    public Short getArticleIdx() {
        return articleIdx;
    }

    public void setArticleIdx(Short articleIdx) {
        this.articleIdx = articleIdx;
    }
}