/**
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.app.wechat.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.app.wechat.domain.msg.WxMiniProMsgModel;

import java.util.Map;

/**
 * 模版消息-发送模板消息API请求对象
 *
 * @author wjtree
 * @version 1.0
 */
public class WxTempSendModel extends WxObject {
    private static final long serialVersionUID = 1L;

    /**
     * 接收者openid
     */
    @JSONField(name = "touser")
    private String toUser;

    /**
     * 模板ID
     */
    @JSONField(name = "template_id")
    private String templateId;

    /**
     * 模板跳转链接
     */
    private String url;

    /**
     * 跳小程序所需数据，不需跳小程序可不用传该数据
     */
    @JSONField(name = "miniprogram")
    private WxMiniProMsgModel miniProgram;

    /**
     * 模板数据
     */
    private Map<String, WxTempSendDataModel> data;

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public WxMiniProMsgModel getMiniProgram() {
        return miniProgram;
    }

    public void setMiniProgram(WxMiniProMsgModel miniProgram) {
        this.miniProgram = miniProgram;
    }

    public Map<String, WxTempSendDataModel> getData() {
        return data;
    }

    public void setData(Map<String, WxTempSendDataModel> data) {
        this.data = data;
    }
}