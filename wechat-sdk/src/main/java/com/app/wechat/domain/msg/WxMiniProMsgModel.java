package com.app.wechat.domain.msg;

import com.alibaba.fastjson.annotation.JSONField;
import com.app.wechat.domain.WxObject;

/**
 * <p>功 能：客服消息-发送小程序卡片API数据结构</p>
 * <p>描 述：要求小程序与公众号已关联</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月10日 下午5:30:32</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxMiniProMsgModel extends WxObject {
    private static final long serialVersionUID = 1L;

    /**
     * 标题
     */
    private String title;

    /**
     * 小程序的appid，要求小程序的appid需要与公众号有关联关系
     */
    @JSONField(name = "appid")
    private String appId;

    /**
     * 小程序的页面路径，跟app.json对齐，支持参数，比如pages/index/index?foo=bar
     */
    @JSONField(name = "pagepath")
    private String pagePath;

    /**
     * 小程序卡片图片的媒体ID，小程序卡片图片建议大小为520*416
     */
    @JSONField(name = "thumb_media_id")
    private String thumbMediaId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }
}