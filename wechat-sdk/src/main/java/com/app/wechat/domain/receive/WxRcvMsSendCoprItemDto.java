package com.app.wechat.domain.receive;

import com.app.wechat.domain.WxObject;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * <p>功 能：微信公众平台接收群发消息结果事件推送API数据结构</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月13日 下午2:36:21</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxRcvMsSendCoprItemDto extends WxObject {
    private static final long serialVersionUID = 1L;

    /**
     * 群发文章的序号，从1开始
     */
    @XStreamAlias("ArticleIdx")
    private String articleIdx;

    /**
     * 用户声明文章的状态
     */
    @XStreamAlias("UserDeclareState")
    private String userDeclareState;

    /**
     * 系统校验的状态
     */
    @XStreamAlias("AuditState")
    private String auditState;

    /**
     * 相似原创文的url
     */
    @XStreamAlias("OriginalArticleUrl")
    private String originalArticleUrl;

    /**
     * 相似原创文的类型
     */
    @XStreamAlias("OriginalArticleType")
    private String originalArticleType;

    /**
     * 是否能转载
     */
    @XStreamAlias("CanReprint")
    private String canReprint;

    /**
     * 是否需要替换成原创文内容
     */
    @XStreamAlias("NeedReplaceContent")
    private String needReplaceContent;

    /**
     * 是否需要注明转载来源
     */
    @XStreamAlias("NeedShowReprintSource")
    private String needShowReprintSource;

    public String getArticleIdx() {
        return articleIdx;
    }

    public void setArticleIdx(String articleIdx) {
        this.articleIdx = articleIdx;
    }

    public String getUserDeclareState() {
        return userDeclareState;
    }

    public void setUserDeclareState(String userDeclareState) {
        this.userDeclareState = userDeclareState;
    }

    public String getAuditState() {
        return auditState;
    }

    public void setAuditState(String auditState) {
        this.auditState = auditState;
    }

    public String getOriginalArticleUrl() {
        return originalArticleUrl;
    }

    public void setOriginalArticleUrl(String originalArticleUrl) {
        this.originalArticleUrl = originalArticleUrl;
    }

    public String getOriginalArticleType() {
        return originalArticleType;
    }

    public void setOriginalArticleType(String originalArticleType) {
        this.originalArticleType = originalArticleType;
    }

    public String getCanReprint() {
        return canReprint;
    }

    public void setCanReprint(String canReprint) {
        this.canReprint = canReprint;
    }

    public String getNeedReplaceContent() {
        return needReplaceContent;
    }

    public void setNeedReplaceContent(String needReplaceContent) {
        this.needReplaceContent = needReplaceContent;
    }

    public String getNeedShowReprintSource() {
        return needShowReprintSource;
    }

    public void setNeedShowReprintSource(String needShowReprintSource) {
        this.needShowReprintSource = needShowReprintSource;
    }
}