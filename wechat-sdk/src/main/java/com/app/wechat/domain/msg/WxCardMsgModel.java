package com.app.wechat.domain.msg;

import com.alibaba.fastjson.annotation.JSONField;
import com.app.wechat.domain.WxObject;

/**
 * <p>功 能：客服消息-发送卡券API数据结构</p>
 * <p>描 述：客服消息接口投放卡券仅支持非自定义Code码和导入code模式的卡券的卡券</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月10日 下午5:30:32</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxCardMsgModel extends WxObject {
    private static final long serialVersionUID = 1L;

    /**
     * 卡券编号
     */
    @JSONField(name = "card_id")
    private String cardId;

    @JSONField(name = "card_ext")
    private String cardExt;

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getCardExt() {
        return cardExt;
    }

    public void setCardExt(String cardExt) {
        this.cardExt = cardExt;
    }
}