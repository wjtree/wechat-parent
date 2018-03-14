/**
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.app.wechat.domain.mass;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 群发消息-根据标签进行群发API
 *
 * @author wjtree
 * @version 1.0
 */
public class WxMassPreviewModel extends WxMassBaseModel {
    private static final long serialVersionUID = 1L;

    /**
     * 接收消息用户对应该公众号的openid数组
     */
    @JSONField(name = "touser")
    private String toUser;

    /**
     * 接收消息用户的微信号<br/>
     * 群发消息-预览接口API使用
     */
    @JSONField(name = "towxname")
    private String toWxName;

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getToWxName() {
        return toWxName;
    }

    public void setToWxName(String toWxName) {
        this.toWxName = toWxName;
    }
}