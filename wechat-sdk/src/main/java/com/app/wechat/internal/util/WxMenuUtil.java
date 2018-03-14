package com.app.wechat.internal.util;

import com.app.wechat.domain.menu.*;
import com.app.wechat.internal.code.WxClientPlatformType;
import com.app.wechat.internal.code.WxLanguage;
import com.app.wechat.internal.code.WxMenuType;
import com.app.wechat.internal.code.WxSex;
import com.app.wechat.internal.exception.WxApiException;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * <p>功 能：微信公众号菜单对象组装工具类</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月7日 上午11:52:16</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxMenuUtil {
    /**
     * 组装个性化菜单的菜单匹配规则
     *
     * @param sex                性别
     * @param clientPlatformType 客户端版本
     * @param language           语言信息
     * @param tagId              用户标签的id
     * @param country            国家信息
     * @param province           省份信息
     * @param city               城市信息
     * @return WxCondMenuRuleModel 菜单匹配规则
     */
    public static WxCondMenuRuleModel getWxCondMenuRuleModel(WxSex sex, WxClientPlatformType clientPlatformType, WxLanguage language, String tagId, String country, String province, String city) {
        WxCondMenuRuleModel model = new WxCondMenuRuleModel();
        model.setSex(sex != null ? sex.getSex() : null);
        model.setClientPlatformType(clientPlatformType != null ? clientPlatformType.getCode() : null);
        model.setLanguage(language != null ? language.getLang() : null);
        model.setTagId(tagId);
        model.setCountry(country);
        model.setProvince(province);
        model.setCity(city);
        return model;
    }

    /**
     * 获取个性化菜单数据结构，以不定参形式传入参数
     * <p>菜单匹配规则仅使用“性别”匹配</p>
     *
     * @param sex    性别
     * @param models 菜单数据结构
     * @return WxCondMenuModel
     */
    public static WxCondMenuModel getWxCondMenuModel(WxSex sex, WxSubMenuModel... models) {
        // 组装个性化菜单的菜单匹配规则
        WxCondMenuRuleModel menuRuleModel = getWxCondMenuRuleModel(sex, null, null, null, null, null, null);
        // 获取个性化菜单数据结构，以不定参形式传入参数
        return getWxCondMenuModel(menuRuleModel, models);
    }

    /**
     * 获取个性化菜单数据结构，以不定参形式传入参数
     * <p>菜单匹配规则仅使用“客户端版本”匹配</p>
     *
     * @param clientPlatformType 客户端版本
     * @param models             菜单数据结构
     * @return WxCondMenuModel
     */
    public static WxCondMenuModel getWxCondMenuModel(WxClientPlatformType clientPlatformType, WxSubMenuModel... models) {
        // 组装个性化菜单的菜单匹配规则
        WxCondMenuRuleModel menuRuleModel = getWxCondMenuRuleModel(null, clientPlatformType, null, null, null, null, null);
        // 获取个性化菜单数据结构，以不定参形式传入参数
        return getWxCondMenuModel(menuRuleModel, models);
    }

    /**
     * 获取个性化菜单数据结构，以不定参形式传入参数
     * <p>菜单匹配规则仅使用“语言信息”匹配</p>
     *
     * @param language 语言信息
     * @param models   菜单数据结构
     * @return WxCondMenuModel
     */
    public static WxCondMenuModel getWxCondMenuModel(WxLanguage language, WxSubMenuModel... models) {
        // 组装个性化菜单的菜单匹配规则
        WxCondMenuRuleModel menuRuleModel = getWxCondMenuRuleModel(null, null, language, null, null, null, null);
        // 获取个性化菜单数据结构，以不定参形式传入参数
        return getWxCondMenuModel(menuRuleModel, models);
    }

    /**
     * 获取个性化菜单数据结构，以不定参形式传入参数
     * <p>菜单匹配规则仅使用“用户标签的id”匹配</p>
     *
     * @param tagId  用户标签的id，使用用户标签API获取
     * @param models 菜单数据结构
     * @return WxCondMenuModel
     */
    public static WxCondMenuModel getWxCondMenuModel(String tagId, WxSubMenuModel... models) {
        // 组装个性化菜单的菜单匹配规则
        WxCondMenuRuleModel menuRuleModel = getWxCondMenuRuleModel(null, null, null, tagId, null, null, null);
        // 获取个性化菜单数据结构，以不定参形式传入参数
        return getWxCondMenuModel(menuRuleModel, models);
    }

    /**
     * 获取个性化菜单数据结构，以不定参形式传入参数
     * <p>菜单匹配规则仅使用“地区信息”匹配</p>
     *
     * @param country  国家信息
     * @param province 省份信息
     * @param city     城市信息
     * @param models   菜单数据结构
     * @return WxCondMenuModel
     */
    public static WxCondMenuModel getWxCondMenuModel(String country, String province, String city, WxSubMenuModel... models) {
        // 组装个性化菜单的菜单匹配规则
        WxCondMenuRuleModel menuRuleModel = getWxCondMenuRuleModel(null, null, null, null, country, province, city);
        // 获取个性化菜单数据结构，以不定参形式传入参数
        return getWxCondMenuModel(menuRuleModel, models);
    }

    /**
     * 获取个性化菜单数据结构，以不定参形式传入参数
     *
     * @param menuRuleModel 菜单匹配规则
     * @param models        菜单数据结构
     * @return WxCondMenuModel
     */
    public static WxCondMenuModel getWxCondMenuModel(WxCondMenuRuleModel menuRuleModel, WxSubMenuModel... models) {
        List<WxSubMenuModel> button = Lists.newArrayList(models);
        return getWxCondMenuModel(menuRuleModel, button);
    }

    /**
     * 获取个性化菜单数据结构
     *
     * @param menuRuleModel 菜单匹配规则
     * @param button        菜单数据结构
     * @return WxCondMenuModel
     */
    public static WxCondMenuModel getWxCondMenuModel(WxCondMenuRuleModel menuRuleModel, List<WxSubMenuModel> button) {
        WxCondMenuModel model = new WxCondMenuModel();
        model.setMatchrule(menuRuleModel);
        model.setButton(button);
        return model;
    }

    /**
     * 获取自定义菜单数据结构，以不定参形式传入参数
     * <p>一级菜单应为1~3个，菜单标题不超过16个字节</p>
     *
     * @param models 菜单数据结构
     * @return WxMenuModel
     */
    public static WxMenuModel getWxMenuModel(WxSubMenuModel... models) {
        List<WxSubMenuModel> button = Lists.newArrayList(models);
        return getWxMenuModel(button);
    }

    /**
     * 获取自定义菜单数据结构
     * <p>一级菜单应为1~3个，菜单标题不超过16个字节</p>
     *
     * @param button 各个菜单及子菜单的属性
     * @return WxMenuModel
     */
    public static WxMenuModel getWxMenuModel(List<WxSubMenuModel> button) {
        WxMenuModel model = new WxMenuModel();
        model.setButton(button);
        return model;
    }

    /**
     * 获取自定义菜单数据结构
     * <p>一级菜单应为1~3个，菜单标题不超过16个字节</p>
     *
     * @param menuId 菜单编号
     * @return WxMenuModel
     */
    public static WxMenuModel getWxMenuModel(String menuId) {
        WxMenuModel model = new WxMenuModel();
        model.setMenuId(menuId);
        return model;
    }

    /**
     * 获取自定义二级菜单数据结构，以不定参形式传入参数
     * <p>二级菜单应为1~5个，菜单标题不超过60个字节</p>
     *
     * @param name   父菜单标题
     * @param models 各个子菜单属性
     * @return WxSubMenuModel
     */
    public static WxSubMenuModel getWxSubMenuModel(String name, WxMenuAttrModel... models) {
        List<WxMenuAttrModel> subButton = Lists.newArrayList(models);
        return getWxSubMenuModel(name, subButton);
    }

    /**
     * 获取自定义二级菜单数据结构
     * <p>二级菜单应为1~5个，菜单标题不超过60个字节</p>
     *
     * @param name      父菜单标题
     * @param subButton 各个子菜单属性
     * @return WxSubMenuModel
     */
    public static WxSubMenuModel getWxSubMenuModel(String name, List<WxMenuAttrModel> subButton) {
        WxSubMenuModel model = new WxSubMenuModel();
        model.setName(name);
        model.setSubButton(subButton);
        return model;
    }

    /**
     * 装载指定类型菜单的详细属性
     *
     * @param menuType   菜单类型
     * @param menuParams 菜单参数
     * @return WxSubMenuModel
     */
    public static WxSubMenuModel loadMenuAttr(WxMenuType menuType, String... menuParams) throws WxApiException {
        switch (menuType) {
            case CLICK:
                return loadClickMenuAttr(menuParams[0], menuParams[1]);
            case VIEW:
                return loadViewMenuAttr(menuParams[0], menuParams[1]);
            case SCANCODE_PUSH:
                return loadScanCodePushMenuAttr(menuParams[0], menuParams[1]);
            case SCANCODE_WAITMSG:
                return loadScanCodeWaitMsgMenuAttr(menuParams[0], menuParams[1]);
            case PIC_SYSPHOTO:
                return loadPicSysPhotoMenuAttr(menuParams[0], menuParams[1]);
            case PIC_PHOTO_OR_ALBUM:
                return loadPicPhotoOrAlbumMenuAttr(menuParams[0], menuParams[1]);
            case PIC_WEIXIN:
                return loadPicWeiXinMenuAttr(menuParams[0], menuParams[1]);
            case LOCATION_SELECT:
                return loadLocationSelectMenuAttr(menuParams[0], menuParams[1]);
            case MEDIA_ID:
                return loadMediaIdMenuAttr(menuParams[0], menuParams[1]);
            case VIEW_LIMITED:
                return loadViewLimitedMenuAttr(menuParams[0], menuParams[1]);
            case MINIPROGRAM:
                return loadMiniProgramMenuAttr(menuParams[0], menuParams[1], menuParams[2], menuParams[3]);
            default:
                throw new WxApiException("菜单类型[menuType]参数无效");
        }
    }

    /**
     * 装载 click 类型（点击推事件）菜单的详细属性
     *
     * @param name 菜单标题
     * @param key  菜单KEY值，用于消息接口推送，不超过128字节
     * @return WxSubMenuModel
     */
    public static WxSubMenuModel loadClickMenuAttr(String name, String key) {
        WxSubMenuModel model = new WxSubMenuModel();
        model.setType(WxMenuType.CLICK.name().toLowerCase());
        model.setName(name);
        model.setKey(key);
        return model;
    }

    /**
     * 装载 view 类型（跳转URL）菜单的详细属性
     *
     * @param name 菜单标题
     * @param url  网页链接
     * @return WxSubMenuModel
     */
    public static WxSubMenuModel loadViewMenuAttr(String name, String url) {
        WxSubMenuModel model = new WxSubMenuModel();
        model.setType(WxMenuType.VIEW.name().toLowerCase());
        model.setName(name);
        model.setUrl(url);
        return model;
    }

    /**
     * 装载 scancode_push 类型（扫码推事件）菜单的详细属性
     *
     * @param name 菜单标题
     * @param key  菜单KEY值，用于消息接口推送，不超过128字节
     * @return WxSubMenuModel
     */
    public static WxSubMenuModel loadScanCodePushMenuAttr(String name, String key) {
        WxSubMenuModel model = new WxSubMenuModel();
        model.setType(WxMenuType.SCANCODE_PUSH.name().toLowerCase());
        model.setName(name);
        model.setKey(key);
        return model;
    }

    /**
     * 装载 scancode_waitmsg 类型（扫码推事件且弹出“消息接收中”提示框）菜单的详细属性
     *
     * @param name 菜单标题
     * @param key  菜单KEY值，用于消息接口推送，不超过128字节
     * @return WxSubMenuModel
     */
    public static WxSubMenuModel loadScanCodeWaitMsgMenuAttr(String name, String key) {
        WxSubMenuModel model = new WxSubMenuModel();
        model.setType(WxMenuType.SCANCODE_WAITMSG.name().toLowerCase());
        model.setName(name);
        model.setKey(key);
        return model;
    }

    /**
     * 装载 pic_sysphoto 类型（弹出系统拍照发图）菜单的详细属性
     *
     * @param name 菜单标题
     * @param key  菜单KEY值，用于消息接口推送，不超过128字节
     * @return WxSubMenuModel
     */
    public static WxSubMenuModel loadPicSysPhotoMenuAttr(String name, String key) {
        WxSubMenuModel model = new WxSubMenuModel();
        model.setType(WxMenuType.PIC_SYSPHOTO.name().toLowerCase());
        model.setName(name);
        model.setKey(key);
        return model;
    }

    /**
     * 装载 pic_photo_or_album 类型（弹出拍照或者相册发图）菜单的详细属性
     *
     * @param name 菜单标题
     * @param key  菜单KEY值，用于消息接口推送，不超过128字节
     * @return WxSubMenuModel
     */
    public static WxSubMenuModel loadPicPhotoOrAlbumMenuAttr(String name, String key) {
        WxSubMenuModel model = new WxSubMenuModel();
        model.setType(WxMenuType.PIC_PHOTO_OR_ALBUM.name().toLowerCase());
        model.setName(name);
        model.setKey(key);
        return model;
    }

    /**
     * 装载 pic_weixin 类型（弹出微信相册发图器）菜单的详细属性
     *
     * @param name 菜单标题
     * @param key  菜单KEY值，用于消息接口推送，不超过128字节
     * @return WxSubMenuModel
     */
    public static WxSubMenuModel loadPicWeiXinMenuAttr(String name, String key) {
        WxSubMenuModel model = new WxSubMenuModel();
        model.setType(WxMenuType.PIC_WEIXIN.name().toLowerCase());
        model.setName(name);
        model.setKey(key);
        return model;
    }

    /**
     * 装载 location_select 类型（弹出地理位置选择器）菜单的详细属性
     *
     * @param name 菜单标题
     * @param key  菜单KEY值，用于消息接口推送，不超过128字节
     * @return WxSubMenuModel
     */
    public static WxSubMenuModel loadLocationSelectMenuAttr(String name, String key) {
        WxSubMenuModel model = new WxSubMenuModel();
        model.setType(WxMenuType.LOCATION_SELECT.name().toLowerCase());
        model.setName(name);
        model.setKey(key);
        return model;
    }

    /**
     * 装载 media_id 类型（下发消息（除文本消息））菜单的详细属性
     *
     * @param name    菜单标题
     * @param mediaId 调用新增永久素材接口返回的合法media_id
     * @return WxSubMenuModel
     */
    public static WxSubMenuModel loadMediaIdMenuAttr(String name, String mediaId) {
        WxSubMenuModel model = new WxSubMenuModel();
        model.setType(WxMenuType.MEDIA_ID.name().toLowerCase());
        model.setName(name);
        model.setMediaId(mediaId);
        return model;
    }

    /**
     * 装载 view_limited 类型（跳转图文消息URL）菜单的详细属性
     *
     * @param name    菜单标题
     * @param mediaId 调用新增永久素材接口返回的合法media_id
     * @return WxSubMenuModel
     */
    public static WxSubMenuModel loadViewLimitedMenuAttr(String name, String mediaId) {
        WxSubMenuModel model = new WxSubMenuModel();
        model.setType(WxMenuType.VIEW_LIMITED.name().toLowerCase());
        model.setName(name);
        model.setMediaId(mediaId);
        return model;
    }

    /**
     * 装载 miniprogram 类型（小程序）菜单的详细属性
     *
     * @param name     菜单标题
     * @param url      网页链接，不支持小程序的老版本客户端将打开本url
     * @param appid    小程序的appid（仅认证公众号可配置）
     * @param pagepath 小程序的页面路径
     * @return WxSubMenuModel
     */
    public static WxSubMenuModel loadMiniProgramMenuAttr(String name, String url, String appid, String pagepath) {
        WxSubMenuModel model = new WxSubMenuModel();
        model.setType(WxMenuType.MINIPROGRAM.name().toLowerCase());
        model.setName(name);
        model.setUrl(url);
        model.setAppId(appid);
        model.setPagePath(pagepath);
        return model;
    }
}