package com.app.wechat.domain.receive;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * <p>功 能：微信公众平台接收普通文本消息API数据结构</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月13日 上午11:59:55</p>
 * @author 王建
 * @version 1.0
 */
public class WxRcvTextMsgDto extends WxRcvMsgDto {
    private static final long serialVersionUID = 1L;

    /** 回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示） */
    @XStreamAlias("Content")
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}