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

public class WxSelfSubMenuListModel extends WxObject {
    private static final long serialVersionUID = 1L;

    private List<WxSelfMenuAttrModel> list;

    public List<WxSelfMenuAttrModel> getList() {
        return list;
    }

    public void setList(List<WxSelfMenuAttrModel> list) {
        this.list = list;
    }
}