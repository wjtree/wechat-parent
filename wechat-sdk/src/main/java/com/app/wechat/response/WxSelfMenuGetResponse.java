/**
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.app.wechat.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.app.wechat.domain.menu.WxSelfMenuModel;

/**
 * <p>功 能：自定义菜单查询接口API的响应结果</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月6日 下午6:54:14</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxSelfMenuGetResponse extends AbstractWxResponse {
    private static final long serialVersionUID = 1L;

    /**
     * 菜单是否开启，0代表未开启，1代表开启
     */
    @JSONField(name = "is_menu_open")
    private short isMenuOpen;

    /**
     * 菜单信息
     */
    @JSONField(name = "selfmenu_info")
    private WxSelfMenuModel selfmenuInfo;

    public short getIsMenuOpen() {
        return isMenuOpen;
    }

    public void setIsMenuOpen(short isMenuOpen) {
        this.isMenuOpen = isMenuOpen;
    }

    public WxSelfMenuModel getSelfmenuInfo() {
        return selfmenuInfo;
    }

    public void setSelfmenuInfo(WxSelfMenuModel selfmenuInfo) {
        this.selfmenuInfo = selfmenuInfo;
    }
}