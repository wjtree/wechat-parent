package com.app.wechat.domain.menu;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * <p>功 能：自定义菜单创建接口菜单属性数据结构</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月7日 上午9:41:14</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxMenuAttrModel extends WxMenuBaseModel {
    private static final long serialVersionUID = 1L;

    /**
     * 菜单的响应动作类型，必填
     */
    private String type;

    /**
     * click等点击类型必须，菜单KEY值，用于消息接口推送，不超过128字节
     */
    private String key;

    /**
     * view、miniprogram类型必须，网页链接，用户点击菜单可打开链接，不超过1024字节。type为miniprogram时，不支持小程序的老版本客户端将打开本url。
     */
    private String url;

    /**
     * media_id类型和view_limited类型必须，调用新增永久素材接口返回的合法media_id
     */
    @JSONField(name = "media_id")
    private String mediaId;

    /**
     * miniprogram类型必须，小程序的appid（仅认证公众号可配置）
     */
    @JSONField(name = "appid")
    private String appId;

    /**
     * miniprogram类型必须，小程序的页面路径
     */
    @JSONField(name = "pagepath")
    private String pagePath;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPagePath() {
        return pagePath;
    }

    public void setPagePath(String pagePath) {
        this.pagePath = pagePath;
    }
}