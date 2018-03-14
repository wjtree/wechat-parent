package com.app.wechat.domain.msg;

import com.app.wechat.domain.WxObject;

/**
 * <p>功 能：客服消息-发送文本消息API数据结构</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月10日 下午5:30:32</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxTextMsgModel extends WxObject {
    private static final long serialVersionUID = 1L;

    /**
     * 文本消息内容
     */
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}