package com.app.wechat.domain.reply;

import com.app.wechat.domain.WxMsgDto;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * <p>功 能：微信公众平台被动回复文本消息公共属性</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月10日 下午5:30:32</p>
 * @author 王建
 * @version 1.0
 */
public class WxRepTextMsgDto extends WxMsgDto {
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