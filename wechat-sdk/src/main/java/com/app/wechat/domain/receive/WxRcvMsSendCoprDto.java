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
public class WxRcvMsSendCoprDto extends WxObject {
    private static final long serialVersionUID = 1L;

    /**
     * 群发消息数量
     */
    @XStreamAlias("Count")
    private Integer count;

    /**
     * 单个校验结果
     */
    @XStreamAlias("ResultList")
    private WxRcvMsSendCoprListDto resultList;

    /**
     * 整体校验结果
     */
    @XStreamAlias("CheckState")
    private String checkState;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public WxRcvMsSendCoprListDto getResultList() {
        return resultList;
    }

    public void setResultList(WxRcvMsSendCoprListDto resultList) {
        this.resultList = resultList;
    }

    public String getCheckState() {
        return checkState;
    }

    public void setCheckState(String checkState) {
        this.checkState = checkState;
    }
}