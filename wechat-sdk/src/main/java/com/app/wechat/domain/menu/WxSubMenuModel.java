package com.app.wechat.domain.menu;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * <p>功 能：自定义菜单创建接口二级菜单数据结构</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月7日 上午10:17:30</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxSubMenuModel extends WxMenuAttrModel {
    private static final long serialVersionUID = 1L;

    /**
     * 二级菜单数组，个数应为1~5个
     */
    @JSONField(name = "sub_button")
    private List<WxMenuAttrModel> subButton;

    public List<WxMenuAttrModel> getSubButton() {
        return subButton;
    }

    public void setSubButton(List<WxMenuAttrModel> subButton) {
        this.subButton = subButton;
    }
}