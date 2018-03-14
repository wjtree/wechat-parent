/**
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.app.wechat.domain.menu;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * <p>功 能：微信公众平台网站设置的自定义菜单数据结构</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月7日 上午9:41:14</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxSelfSubMenuModel extends WxSelfMenuAttrModel {
    private static final long serialVersionUID = 1L;

    @JSONField(name = "sub_button")
    private WxSelfSubMenuListModel subButton;

    public WxSelfSubMenuListModel getSubButton() {
        return subButton;
    }

    public void setSubButton(WxSelfSubMenuListModel subButton) {
        this.subButton = subButton;
    }
}