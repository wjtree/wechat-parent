package com.app.wechat.code;


import com.app.wechat.internal.util.PropUtil;

/**
 * <p>功 能：微信公众号配置信息常量</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年5月8日 上午10:24:23</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxConstant {
    /**
     * 公众号AppID
     */
    public static final String APP_ID = PropUtil.getString("wx.app.id");
    /**
     * 公众号AppSecret
     */
    public static final String APP_SECRET = PropUtil.getString("wx.app.secret");
    /**
     * 微信号
     */
    public static final String APP_ORIGNID = PropUtil.getString("wx.app.orignid");

    /**
     * 公众号服务器Token
     */
    public static final String APP_TOKEN = PropUtil.getString("wx.app.token");
    /**
     * 消息加解密密钥
     */
    public static final String APP_AES_KEY = PropUtil.getString("wx.app.aes.key");
}