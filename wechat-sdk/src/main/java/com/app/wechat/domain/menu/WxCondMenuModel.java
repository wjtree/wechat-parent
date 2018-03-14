package com.app.wechat.domain.menu;

/**
 * <p>功 能：创建个性化菜单一级菜单数据结构</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月7日 上午9:24:41</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxCondMenuModel extends WxMenuModel {
    private static final long serialVersionUID = 1L;

    /**
     * 个性化菜单匹配规则
     */
    private WxCondMenuRuleModel matchrule;

    public WxCondMenuRuleModel getMatchrule() {
        return matchrule;
    }

    public void setMatchrule(WxCondMenuRuleModel matchrule) {
        this.matchrule = matchrule;
    }
}