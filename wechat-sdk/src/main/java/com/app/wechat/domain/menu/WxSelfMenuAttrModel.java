/**
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.app.wechat.domain.menu;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * <p>功 能：微信公众平台网站设置的自定义菜单数据结构</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月7日 上午9:41:14</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxSelfMenuAttrModel extends WxMenuBaseModel {
    private static final long serialVersionUID = 1L;

    /**
     * 菜单的响应动作类型，必填
     */
    private String type;

    /**
     * 该属性仅用于微信公众平台官网设置的自定义菜单
     * <p>不同菜单类型对应该字段的含义不同，具体如下：</p>
     * <ol>
     * <li>news：保存图文消息到news_info，同时保存mediaID到value</li>
     * <li>img、voice：保存mediaID到value</li>
     * <li>video：保存视频下载链接到value</li>
     * <li>view：保存链接到url</li>
     * <li>text：保存文字到value</li>
     * </ol>
     */
    private String value;

    /**
     * click等点击类型必须，菜单KEY值，用于消息接口推送，不超过128字节
     */
    private String key;

    /**
     * view、miniprogram类型必须，网页链接，用户点击菜单可打开链接，不超过1024字节。type为miniprogram时，不支持小程序的老版本客户端将打开本url。
     */
    private String url;

    /**
     * 图文消息
     */
    @JSONField(name = "news_info")
    private WxSelfMenuNewsListModel newsInfo;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    public WxSelfMenuNewsListModel getNewsInfo() {
        return newsInfo;
    }

    public void setNewsInfo(WxSelfMenuNewsListModel newsInfo) {
        this.newsInfo = newsInfo;
    }
}