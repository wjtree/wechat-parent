/**
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.app.wechat.domain.mass;

import com.alibaba.fastjson.annotation.JSONField;
import com.app.wechat.domain.WxObject;
import com.app.wechat.domain.msg.*;

/**
 * 群发消息-根据标签进行群发API
 *
 * @author wjtree
 * @version 1.0
 */
public class WxMassBaseModel extends WxObject {
    private static final long serialVersionUID = 1L;

    /**
     * 图文消息
     */
    @JSONField(name = "mpnews")
    private WxMpNewsMsgModel mpNews;

    /**
     * 文本消息
     */
    private WxTextMsgModel text;

    /**
     * 语音/音频消息
     */
    private WxVoiceMsgModel voice;

    /**
     * 图片消息
     */
    private WxImgMsgModel image;

    /**
     * 视频消息
     */
    @JSONField(name = "mpvideo")
    private WxVideoMsgModel mpVideo;

    /**
     * 卡券消息
     */
    @JSONField(name = "wxcard")
    private WxCardMsgModel wxCard;

    /**
     * 群发的消息类型
     */
    @JSONField(name = "msgtype")
    private String msgType;

    public WxMpNewsMsgModel getMpNews() {
        return mpNews;
    }

    public void setMpNews(WxMpNewsMsgModel mpNews) {
        this.mpNews = mpNews;
    }

    public WxTextMsgModel getText() {
        return text;
    }

    public void setText(WxTextMsgModel text) {
        this.text = text;
    }

    public WxVoiceMsgModel getVoice() {
        return voice;
    }

    public void setVoice(WxVoiceMsgModel voice) {
        this.voice = voice;
    }

    public WxImgMsgModel getImage() {
        return image;
    }

    public void setImage(WxImgMsgModel image) {
        this.image = image;
    }

    public WxVideoMsgModel getMpVideo() {
        return mpVideo;
    }

    public void setMpVideo(WxVideoMsgModel mpVideo) {
        this.mpVideo = mpVideo;
    }

    public WxCardMsgModel getWxCard() {
        return wxCard;
    }

    public void setWxCard(WxCardMsgModel wxCard) {
        this.wxCard = wxCard;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }
}