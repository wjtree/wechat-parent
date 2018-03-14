package com.app.wechat.domain.receive;

import com.app.wechat.domain.WxObject;

/**
 * <p>功 能：自定义菜单拍照发图事件-图片信息数据结构</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月7日 下午6:17:27</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxRcvMenuPicItemDto extends WxObject {
    private static final long serialVersionUID = 1L;

    private WxRcvMenuPicItemInfoDto item;

    public WxRcvMenuPicItemInfoDto getItem() {
        return item;
    }

    public void setItem(WxRcvMenuPicItemInfoDto item) {
        this.item = item;
    }
}