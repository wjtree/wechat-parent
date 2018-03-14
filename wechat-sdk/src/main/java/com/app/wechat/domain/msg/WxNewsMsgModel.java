package com.app.wechat.domain.msg;

import com.app.wechat.domain.WxObject;

import java.util.List;

/**
 * <p>功 能：客服消息-发送图文消息（点击跳转到外链）API数据结构</p>
 * <p>描 述：图文消息条数限制在8条以内，如果图文数超过8，则将会无响应</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月10日 下午5:30:32</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxNewsMsgModel extends WxObject {
    private static final long serialVersionUID = 1L;

    /**
     * 图文消息，不超过8条
     */
    private List<WxNewsItemMsgModel> articles;

    public List<WxNewsItemMsgModel> getArticles() {
        return articles;
    }

    public void setArticles(List<WxNewsItemMsgModel> articles) {
        this.articles = articles;
    }
}