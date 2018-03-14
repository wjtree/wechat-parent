package com.app.wechat.internal.code;

import org.apache.commons.lang3.ArrayUtils;

/**
 * <p>功 能：微信公众号事件类型枚举</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月13日 上午11:20:11</p>
 *
 * @author 王建
 * @version 1.0
 */
public enum WxEventType {
    /**
     * 关注事件
     */
    SUBSCRIBE, /**
     * 取消关注事件
     */
    UNSUBSCRIBE, /**
     * 扫描带参数二维码事件
     */
    SCAN, /**
     * 上报地理位置事件
     */
    LOCATION, /**
     * 菜单事件-点击推事件
     */
    CLICK, /**
     * 菜单事件-跳转URL
     */
    VIEW, /**
     * 菜单事件-扫码推事件
     */
    SCANCODE_PUSH, /**
     * 菜单事件-扫码推事件且弹出“消息接收中”提示框
     */
    SCANCODE_WAITMSG, /**
     * 菜单事件-弹出系统拍照发图
     */
    PIC_SYSPHOTO, /**
     * 菜单事件-弹出拍照或者相册发图
     */
    PIC_PHOTO_OR_ALBUM, /**
     * 菜单事件-弹出微信相册发图器
     */
    PIC_WEIXIN, /**
     * 菜单事件-弹出地理位置选择器
     */
    LOCATION_SELECT, /**
     * 菜单事件-下发消息（除文本消息）
     */
    MEDIA_ID, /**
     * 菜单事件-跳转图文消息URL
     */
    VIEW_LIMITED, /**
     * 群发消息结果推送事件
     */
    MASSSENDJOBFINISH, /**
     * 模板消息结果推送事件
     */
    TEMPLATESENDJOBFINISH, /**
     * 微信认证事件-资质认证成功
     */
    QUALIFICATION_VERIFY_SUCCESS, /**
     * 微信认证事件-资质认证失败
     */
    QUALIFICATION_VERIFY_FAIL, /**
     * 微信认证事件-名称认证成功
     */
    NAMING_VERIFY_SUCCESS, /**
     * 微信认证事件-名称认证失败
     */
    NAMING_VERIFY_FAIL, /**
     * 微信认证事件-年审通知
     */
    ANNUAL_RENEW, /**
     * 微信认证事件-认证过期失效通知
     */
    VERIFY_EXPIRED;

    /**
     * 用户交互型的事件类型数组
     */
    public static final WxEventType[] USER_EVNT_ARR = {SUBSCRIBE, UNSUBSCRIBE, SCAN, LOCATION};

    /**
     * 用户交互型（菜单触发）的事件类型数组
     */
    public static final WxEventType[] USER_MENU_EVNT_ARR = {CLICK, VIEW, SCANCODE_PUSH, SCANCODE_WAITMSG, PIC_SYSPHOTO, PIC_PHOTO_OR_ALBUM, PIC_WEIXIN, LOCATION_SELECT, MEDIA_ID, VIEW_LIMITED};

    /**
     * 通知型的事件类型数组
     */
    public static final WxEventType[] NOTIFY_EVNT_ARR = {MASSSENDJOBFINISH, TEMPLATESENDJOBFINISH};

    /**
     * 通知型（微信认证）的事件类型数组
     */
    public static final WxEventType[] NOTIFY_VERIFY_EVNT_ARR = {QUALIFICATION_VERIFY_SUCCESS, QUALIFICATION_VERIFY_FAIL, NAMING_VERIFY_SUCCESS, NAMING_VERIFY_FAIL, ANNUAL_RENEW, VERIFY_EXPIRED};

    /**
     * 用户交互型（菜单触发）的事件类型数组
     */
    public static final String[] USER_MENU_SCAN_EVNT_ARR = {SCANCODE_PUSH.name(), SCANCODE_WAITMSG.name()};

    /**
     * 用户交互型（菜单触发）的事件类型数组
     */
    public static final String[] USER_MENU_PIC_EVNT_ARR = {PIC_SYSPHOTO.name(), PIC_PHOTO_OR_ALBUM.name(), PIC_WEIXIN.name()};

    /**
     * 判断是否为用户交互型的事件推送
     *
     * @param event 事件类型
     * @return true/false
     */
    public static boolean isUserEvnt(String event) {
        return ArrayUtils.contains(USER_EVNT_ARR, WxEventType.valueOf(event.toUpperCase()));
    }

    /**
     * 判断是否为用户交互型（菜单触发）的事件推送
     *
     * @param event 事件类型
     * @return true/false
     */
    public static boolean isUserMenuEvnt(String event) {
        return ArrayUtils.contains(USER_MENU_EVNT_ARR, WxEventType.valueOf(event.toUpperCase()));
    }

    /**
     * 判断是否为通知型的事件推送
     *
     * @param event 事件类型
     * @return true/false
     */
    public static boolean isNotifyEvnt(String event) {
        return ArrayUtils.contains(NOTIFY_EVNT_ARR, WxEventType.valueOf(event.toUpperCase()));
    }

    /**
     * 判断是否为通知型（微信认证）的事件推送
     *
     * @param event 事件类型
     * @return true/false
     */
    public static boolean isNotifyVerifyEvnt(String event) {
        return ArrayUtils.contains(NOTIFY_VERIFY_EVNT_ARR, WxEventType.valueOf(event.toUpperCase()));
    }
}