package com.app.wechat.domain.receive;

import com.app.wechat.domain.WxObject;

import java.util.List;

/**
 * <p>功 能：微信公众平台接收群发消息结果事件推送API数据结构</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月13日 下午2:36:21</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxRcvMsSendCoprListDto extends WxObject {
    private static final long serialVersionUID = 1L;

    /**
     * 单个群发消息校验结果集
     */
    private List<WxRcvMsSendCoprItemDto> item;

    public List<WxRcvMsSendCoprItemDto> getItem() {
        return item;
    }

    public void setItem(List<WxRcvMsSendCoprItemDto> item) {
        this.item = item;
    }
}