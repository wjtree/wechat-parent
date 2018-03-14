package com.app.wechat.domain.menu;

import com.app.wechat.domain.WxObject;

/**
 * <p>功 能：自定义菜单创建接口一级和二级菜单公共数据结构</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月7日 上午9:33:44</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxMenuBaseModel extends WxObject {
    private static final long serialVersionUID = 1L;

    /**
     * 菜单名称，不超过16个字节，子菜单不超过60个字节，必填
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}