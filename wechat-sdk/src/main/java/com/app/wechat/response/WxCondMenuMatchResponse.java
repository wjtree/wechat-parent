/**
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.app.wechat.response;

import com.app.wechat.domain.menu.WxMenuModel;

/**
 * <p>功 能：测试个性化菜单匹配结果API的响应结果</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月6日 下午6:54:14</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxCondMenuMatchResponse extends AbstractWxResponse {
    private static final long serialVersionUID = 1L;

    /**
     * 匹配的个性化菜单
     */
    private WxMenuModel menu;

    public WxMenuModel getMenu() {
        return menu;
    }

    public void setMenu(WxMenuModel menu) {
        this.menu = menu;
    }
}