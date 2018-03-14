/**
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.app.wechat.domain.menu;

import com.app.wechat.domain.WxObject;

import java.util.List;

/**
 * <p>功 能：微信公众平台网站设置的自定义菜单（图文消息类型）数据结构</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月7日 上午9:41:14</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxSelfMenuNewsListModel extends WxObject {
    private static final long serialVersionUID = 1L;

    /**
     * 图文消息集合
     */
    private List<WxSelfMenuNewsModel> list;

    public List<WxSelfMenuNewsModel> getList() {
        return list;
    }

    public void setList(List<WxSelfMenuNewsModel> list) {
        this.list = list;
    }
}