package com.app.wechat.domain.menu;

import com.alibaba.fastjson.annotation.JSONField;
import com.app.wechat.domain.WxObject;

import java.util.List;

/**
 * <p>功 能：自定义菜单创建接口一级菜单数据结构</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月7日 上午9:24:41</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxMenuModel extends WxObject {
    private static final long serialVersionUID = 1L;

    /**
     * 菜单按钮
     */
    private List<WxSubMenuModel> button;

    /**
     * 菜单编号
     */
    @JSONField(name = "menuid")
    private String menuId;

    public List<WxSubMenuModel> getButton() {
        return button;
    }

    public void setButton(List<WxSubMenuModel> button) {
        this.button = button;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }
}