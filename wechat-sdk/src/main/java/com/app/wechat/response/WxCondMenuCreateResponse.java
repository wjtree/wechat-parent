package com.app.wechat.response;

/**
 * <p>功 能：创建个性化菜单API的响应结果</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月6日 下午6:54:14</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxCondMenuCreateResponse extends AbstractWxResponse {
    private static final long serialVersionUID = 1L;

    private String menuid;

    public String getMenuid() {
        return menuid;
    }

    public void setMenuid(String menuid) {
        this.menuid = menuid;
    }
}