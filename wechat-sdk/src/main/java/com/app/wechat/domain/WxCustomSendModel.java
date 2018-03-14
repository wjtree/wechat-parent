package com.app.wechat.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.app.wechat.domain.msg.*;

/**
 * <p>功 能：客服消息API基础数据结构</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月10日 下午5:30:32</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxCustomSendModel extends WxObject {
    private static final long serialVersionUID = 1L;

    /**
     * 普通用户（openid）
     */
    @JSONField(name = "touser")
    private String toUser;

    /**
     * 客服输入状态<br/>
     * "Typing"：对用户下发“正在输入"状态<br/>
     * "CancelTyping"：取消对用户的”正在输入"状态
     */
    private String command;

    /**
     * 消息类型 {@link com.app.wechat.internal.code.WxMsgType}
     */
    @JSONField(name = "msgtype")
    private String msgType;

    /**
     * 如果需要以某个客服帐号来发消息，则需在JSON数据包的后半部分加入customservice参数
     */
    @JSONField(name = "customservice")
    private WxCustomModel customService;

    /**
     * 文本消息
     */
    private WxTextMsgModel text;

    /**
     * 图片消息
     */
    private WxImgMsgModel image;

    /**
     * 语音消息
     */
    private WxVoiceMsgModel voice;

    /**
     * 视频消息
     */
    private WxVideoMsgModel video;

    /**
     * 音乐消息
     */
    private WxMusicMsgModel music;

    /**
     * 图文消息（点击跳转到外链）
     */
    private WxNewsMsgModel news;

    /**
     * 图文消息（点击跳转到图文消息页面）
     */
    @JSONField(name = "mpnews")
    private WxMpNewsMsgModel mpNews;

    /**
     * 卡券
     */
    @JSONField(name = "wxcard")
    private WxCardMsgModel wxCard;

    /**
     * 小程序卡片
     */
    @JSONField(name = "miniprogrampage")
    private WxMiniProMsgModel miniProgramPage;

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public WxCustomModel getCustomService() {
        return customService;
    }

    public void setCustomService(WxCustomModel customService) {
        this.customService = customService;
    }

    public WxTextMsgModel getText() {
        return text;
    }

    public void setText(WxTextMsgModel text) {
        this.text = text;
    }

    public WxImgMsgModel getImage() {
        return image;
    }

    public void setImage(WxImgMsgModel image) {
        this.image = image;
    }

    public WxVoiceMsgModel getVoice() {
        return voice;
    }

    public void setVoice(WxVoiceMsgModel voice) {
        this.voice = voice;
    }

    public WxVideoMsgModel getVideo() {
        return video;
    }

    public void setVideo(WxVideoMsgModel video) {
        this.video = video;
    }

    public WxMusicMsgModel getMusic() {
        return music;
    }

    public void setMusic(WxMusicMsgModel music) {
        this.music = music;
    }

    public WxNewsMsgModel getNews() {
        return news;
    }

    public void setNews(WxNewsMsgModel news) {
        this.news = news;
    }

    public WxMpNewsMsgModel getMpNews() {
        return mpNews;
    }

    public void setMpNews(WxMpNewsMsgModel mpNews) {
        this.mpNews = mpNews;
    }

    public WxCardMsgModel getWxCard() {
        return wxCard;
    }

    public void setWxCard(WxCardMsgModel wxCard) {
        this.wxCard = wxCard;
    }

    public WxMiniProMsgModel getMiniProgramPage() {
        return miniProgramPage;
    }

    public void setMiniProgramPage(WxMiniProMsgModel miniProgramPage) {
        this.miniProgramPage = miniProgramPage;
    }
}