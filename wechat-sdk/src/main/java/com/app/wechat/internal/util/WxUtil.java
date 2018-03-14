package com.app.wechat.internal.util;

/**
 * <p>功 能：微信SDK工具类</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年5月5日 下午6:30:20</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxUtil {
    /**
     * 获取微信接口返回码对应的说明信息
     *
     * @param wxCode 微信接口返回码
     * @return 返回码信息
     */
    public static String getWxCodeMsg(String wxCode) {
        return I18NUtil.getMessage("i18n.wxCode", wxCode);
    }
}