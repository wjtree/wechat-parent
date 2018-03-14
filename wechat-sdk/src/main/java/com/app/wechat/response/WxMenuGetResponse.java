package com.app.wechat.response;

import com.app.wechat.domain.menu.WxCondMenuModel;
import com.app.wechat.domain.menu.WxMenuModel;

import java.util.List;

/**
 * <p>功 能：自定义菜单查询接口API的响应结果</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月6日 下午6:54:14</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxMenuGetResponse extends AbstractWxResponse {
    private static final long serialVersionUID = 1L;

    /**
     * 自定义菜单
     */
    private WxMenuModel menu;

    /**
     * 个性化菜单
     */
    private List<WxCondMenuModel> conditionalmenu;

    public WxMenuModel getMenu() {
        return menu;
    }

    public void setMenu(WxMenuModel menu) {
        this.menu = menu;
    }

    public List<WxCondMenuModel> getConditionalmenu() {
        return conditionalmenu;
    }

    public void setConditionalmenu(List<WxCondMenuModel> conditionalmenu) {
        this.conditionalmenu = conditionalmenu;
    }
}