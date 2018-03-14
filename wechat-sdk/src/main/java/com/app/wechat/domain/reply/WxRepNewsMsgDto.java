package com.app.wechat.domain.reply;

import com.app.wechat.domain.WxMsgDto;
import com.app.wechat.domain.msg.WxNewsItemMsgModel;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 * <p>功 能：微信公众平台被动回复图文消息公共属性</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月10日 下午5:30:32</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxRepNewsMsgDto extends WxMsgDto {
    private static final long serialVersionUID = 1L;

    /**
     * 图文消息个数，限制为8条以内
     */
    @XStreamAlias("ArticleCount")
    private Integer articleCount;

    /**
     * 多条图文消息信息，默认第一个item为大图,注意，如果图文数超过8，则将会无响应
     */
    @XStreamImplicit(itemFieldName = "Articles")
    private List<WxNewsItemMsgModel> articles;

    public Integer getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(Integer articleCount) {
        this.articleCount = articleCount;
    }

    public List<WxNewsItemMsgModel> getArticles() {
        return articles;
    }

    public void setArticles(List<WxNewsItemMsgModel> articles) {
        this.articles = articles;
    }
}