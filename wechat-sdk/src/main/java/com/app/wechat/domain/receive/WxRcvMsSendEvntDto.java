package com.app.wechat.domain.receive;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * <p>功 能：微信公众平台接收群发消息结果事件推送API数据结构</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月13日 下午2:36:21</p>
 * @author 王建
 * @version 1.0
 */
public class WxRcvMsSendEvntDto extends WxRcvEvntDto {
    private static final long serialVersionUID = 1L;

    /** 群发的消息ID */
    @XStreamAlias("MsgID")
    private String msgID;

    /** 群发的结构，为“send success”或“send fail”或“err(num)” */
    @XStreamAlias("Status")
    private String status;

    /** tag_id下粉丝数；或者openid_list中的粉丝数 */
    @XStreamAlias("TotalCount")
    private Integer totalCount;

    /** 过滤（过滤是指特定地区、性别的过滤、用户设置拒收的过滤，用户接收已超4条的过滤）后，准备发送的粉丝数，原则上，FilterCount = SentCount + ErrorCount */
    @XStreamAlias("FilterCount")
    private Integer filterCount;

    /** 发送成功的粉丝数 */
    @XStreamAlias("SentCount")
    private Integer sentCount;

    /** 发送失败的粉丝数 */
    @XStreamAlias("ErrorCount")
    private Integer errorCount;

    /** 版权校验 */
    @XStreamAlias("CopyrightCheckResult")
    private WxRcvMsSendCoprDto copyrightCheckResult;

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

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getFilterCount() {
        return filterCount;
    }

    public void setFilterCount(Integer filterCount) {
        this.filterCount = filterCount;
    }

    public Integer getSentCount() {
        return sentCount;
    }

    public void setSentCount(Integer sentCount) {
        this.sentCount = sentCount;
    }

    public Integer getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(Integer errorCount) {
        this.errorCount = errorCount;
    }

    public WxRcvMsSendCoprDto getCopyrightCheckResult() {
        return copyrightCheckResult;
    }

    public void setCopyrightCheckResult(WxRcvMsSendCoprDto copyrightCheckResult) {
        this.copyrightCheckResult = copyrightCheckResult;
    }
}