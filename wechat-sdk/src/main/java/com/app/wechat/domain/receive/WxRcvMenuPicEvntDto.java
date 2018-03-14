package com.app.wechat.domain.receive;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * <p>功 能：自定义菜单拍照发图事件数据结构</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月7日 下午5:57:25</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxRcvMenuPicEvntDto extends WxRcvMenuEvntDto {
    private static final long serialVersionUID = 1L;

    @XStreamAlias("SendPicsInfo")
    private WxRcvMenuPicInfoDto sendPicsInfo;

    public WxRcvMenuPicInfoDto getSendPicsInfo() {
        return sendPicsInfo;
    }

    public void setSendPicsInfo(WxRcvMenuPicInfoDto sendPicsInfo) {
        this.sendPicsInfo = sendPicsInfo;
    }
}