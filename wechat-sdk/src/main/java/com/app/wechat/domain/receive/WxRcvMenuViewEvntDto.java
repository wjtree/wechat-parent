package com.app.wechat.domain.receive;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * <p>功 能：自定义菜单跳转url事件数据结构</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月7日 下午5:57:25</p>
 * @author 王建
 * @version 1.0
 */
public class WxRcvMenuViewEvntDto extends WxRcvMenuEvntDto {
	private static final long serialVersionUID = 1L;

	/** 指菜单ID，如果是个性化菜单，则可以通过这个字段，知道是哪个规则的菜单被点击了 */
	@XStreamAlias("MenuId")
	private String menuId;

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
}