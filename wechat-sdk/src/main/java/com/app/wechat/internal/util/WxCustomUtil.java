package com.app.wechat.internal.util;

import com.app.wechat.domain.WxCustomModel;
import com.app.wechat.domain.WxCustomSendModel;
import com.app.wechat.domain.msg.*;
import com.app.wechat.internal.code.WxCustomCommand;
import com.app.wechat.internal.code.WxMsgType;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * 微信公众平台客服API工具类
 *
 * @author Administrator
 * @version 1.0
 */
public class WxCustomUtil {
    /**
     * 封装客服帐号信息对象，用于“客服消息”接口指定客服发送消息
     *
     * @param kfAccount 客服帐号
     * @return WxCustomModel
     */
    public static WxCustomModel getWxCustomModel(String kfAccount) {
        return StringUtils.isNotBlank(kfAccount) ? getWxCustomModel(kfAccount, null, null, null, null, null) : null;
    }

    /**
     * 封装客服帐号信息对象，用于“客服帐号管理”接口传参
     *
     * @param kfAccount 客服帐号
     * @param nickname  客服昵称
     * @param password  客服密码
     * @return WxCustomModel
     */
    public static WxCustomModel getWxCustomModel(String kfAccount, String nickname, String password) {
        return getWxCustomModel(kfAccount, null, null, null, nickname, password);
    }

    /**
     * 封装客服帐号信息对象
     *
     * @param kfAccount    客服帐号
     * @param kfNick       客服昵称
     * @param kfId         客服编号
     * @param kfHeadImgUrl 客服头像URL
     * @param nickname     客服昵称
     * @param password     客服密码
     * @return WxCustomModel
     */
    public static WxCustomModel getWxCustomModel(String kfAccount, String kfNick, String kfId, String kfHeadImgUrl, String nickname, String password) {
        WxCustomModel model = new WxCustomModel();
        model.setKfAccount(kfAccount);
        model.setKfNick(kfNick);
        model.setKfId(kfId);
        model.setKfHeadImgUrl(kfHeadImgUrl);
        model.setNickname(nickname);
        model.setPassword(password);
        return model;
    }

    /**
     * 封装客服消息对象，用于“客服输入状态”接口传参
     *
     * @param toUser  客服消息接收方（openid）
     * @param command 客服消息输入状态
     * @return WxCustomSendModel
     */
    public static WxCustomSendModel getWxCustomSendModel(String toUser, WxCustomCommand command) {
        return getWxCustomSendModel(toUser, command, null, null);
    }

    /**
     * 封装客服消息对象，用于“客服消息”接口传参
     *
     * @param toUser    客服消息接收方（openid）
     * @param msgType   客服消息类型
     * @param kfAccount 客服帐号
     * @return WxCustomSendModel
     */
    public static WxCustomSendModel getWxCustomSendModel(String toUser, WxMsgType msgType, String kfAccount) {
        WxCustomModel customModel = getWxCustomModel(kfAccount);
        return (StringUtils.isNotBlank(toUser) && msgType != null) ? getWxCustomSendModel(toUser, null, msgType, customModel) : null;
    }

    /**
     * 封装客服消息对象
     *
     * @param toUser        客服消息接收方（openid）
     * @param command       客服消息输入状态
     * @param msgType       客服消息类型
     * @param customService 客服帐号信息对象
     * @return WxCustomSendModel
     */
    public static WxCustomSendModel getWxCustomSendModel(String toUser, WxCustomCommand command, WxMsgType msgType, WxCustomModel customService) {
        WxCustomSendModel model = new WxCustomSendModel();
        model.setToUser(toUser);
        model.setCommand(command != null ? command.getCode() : null);
        model.setMsgType(msgType != null ? msgType.name().toLowerCase() : null);
        model.setCustomService(customService);
        return model;
    }

    /**
     * 客服消息-发送文本消息
     *
     * @param toUser  客服消息接收方（openid）
     * @param content 文本消息内容
     * @return WxCustomSendModel
     */
    public static WxCustomSendModel getTextMsg(String toUser, String content) {
        return getTextMsg(toUser, content, null);
    }

    /**
     * 客服消息-发送文本消息
     *
     * @param toUser    客服消息接收方（openid）
     * @param content   文本消息内容
     * @param kfAccount 客服帐号
     * @return WxCustomSendModel
     */
    public static WxCustomSendModel getTextMsg(String toUser, String content, String kfAccount) {
        // 封装客服文本消息对象
        WxTextMsgModel text = WxMsgUtil.getWxTextMsgModel(content);

        // 封装客服消息对象
        WxCustomSendModel model = getWxCustomSendModel(toUser, WxMsgType.TEXT, kfAccount);
        model.setText(text);
        return model;
    }

    /**
     * 客服消息-发送图片消息
     *
     * @param toUser  客服消息接收方（openid）
     * @param mediaId 媒体ID
     * @return WxCustomSendModel
     */
    public static WxCustomSendModel getImgMsg(String toUser, String mediaId) {
        return getImgMsg(toUser, mediaId, null);
    }

    /**
     * 客服消息-发送图片消息
     *
     * @param toUser    客服消息接收方（openid）
     * @param mediaId   媒体ID
     * @param kfAccount 客服帐号
     * @return WxCustomSendModel
     */
    public static WxCustomSendModel getImgMsg(String toUser, String mediaId, String kfAccount) {
        // 封装客服图片消息对象
        WxImgMsgModel image = WxMsgUtil.getWxImgMsgModel(mediaId);

        // 封装客服消息对象
        WxCustomSendModel model = getWxCustomSendModel(toUser, WxMsgType.IMAGE, kfAccount);
        model.setImage(image);
        return model;
    }

    /**
     * 客服消息-发送语音消息
     *
     * @param toUser  客服消息接收方（openid）
     * @param mediaId 媒体ID
     * @return WxCustomSendModel
     */
    public static WxCustomSendModel getVoiceMsg(String toUser, String mediaId) {
        return getVoiceMsg(toUser, mediaId, null);
    }

    /**
     * 客服消息-发送语音消息
     *
     * @param toUser    客服消息接收方（openid）
     * @param mediaId   媒体ID
     * @param kfAccount 客服帐号
     * @return WxCustomSendModel
     */
    public static WxCustomSendModel getVoiceMsg(String toUser, String mediaId, String kfAccount) {
        // 封装客服语音消息对象
        WxVoiceMsgModel voice = WxMsgUtil.getWxVoiceMsgModel(mediaId);

        // 封装客服消息对象
        WxCustomSendModel model = getWxCustomSendModel(toUser, WxMsgType.VOICE, kfAccount);
        model.setVoice(voice);
        return model;
    }

    /**
     * 客服消息-发送视频消息
     *
     * @param toUser       客服消息接收方（openid）
     * @param mediaId      媒体ID
     * @param thumbMediaId 缩略图媒体ID
     * @param title        标题
     * @param description  描述
     * @return WxCustomSendModel
     */
    public static WxCustomSendModel getVideoMsg(String toUser, String mediaId, String thumbMediaId, String title, String description) {
        return getVideoMsg(toUser, mediaId, thumbMediaId, title, description, null);
    }

    /**
     * 客服消息-发送视频消息
     *
     * @param toUser       客服消息接收方（openid）
     * @param mediaId      媒体ID
     * @param thumbMediaId 缩略图媒体ID
     * @param title        标题
     * @param description  描述
     * @param kfAccount    客服帐号
     * @return WxCustomSendModel
     */
    public static WxCustomSendModel getVideoMsg(String toUser, String mediaId, String thumbMediaId, String title, String description, String kfAccount) {
        // 封装客服视频消息对象
        WxVideoMsgModel video = WxMsgUtil.getWxVideoMsgModel(mediaId, thumbMediaId, title, description);

        // 封装客服消息对象
        WxCustomSendModel model = getWxCustomSendModel(toUser, WxMsgType.VIDEO, kfAccount);
        model.setVideo(video);
        return model;
    }

    /**
     * 客服消息-发送音乐消息
     *
     * @param toUser       客服消息接收方（openid）
     * @param title        标题
     * @param description  描述
     * @param musicUrl     音乐链接
     * @param hqMusicUrl   高品质音乐链接，wifi环境优先使用该链接播放音乐
     * @param thumbMediaId 缩略图媒体ID
     * @return WxCustomSendModel
     */
    public static WxCustomSendModel getMusicMsg(String toUser, String title, String description, String musicUrl, String hqMusicUrl, String thumbMediaId) {
        return getMusicMsg(toUser, title, description, musicUrl, hqMusicUrl, thumbMediaId, null);
    }

    /**
     * 客服消息-发送音乐消息
     *
     * @param toUser       客服消息接收方（openid）
     * @param title        标题
     * @param description  描述
     * @param musicUrl     音乐链接
     * @param hqMusicUrl   高品质音乐链接，wifi环境优先使用该链接播放音乐
     * @param thumbMediaId 缩略图媒体ID
     * @param kfAccount    客服帐号
     * @return WxCustomSendModel
     */
    public static WxCustomSendModel getMusicMsg(String toUser, String title, String description, String musicUrl, String hqMusicUrl, String thumbMediaId, String kfAccount) {
        // 封装客服音乐消息对象
        WxMusicMsgModel music = WxMsgUtil.getWxMusicMsgModel(title, description, musicUrl, hqMusicUrl, thumbMediaId);

        // 封装客服消息对象
        WxCustomSendModel model = getWxCustomSendModel(toUser, WxMsgType.MUSIC, kfAccount);
        model.setMusic(music);
        return model;
    }

    /**
     * 客服消息-发送图文消息（点击跳转到外链）
     * <p>发送单条图文消息</p>
     *
     * @param toUser      客服消息接收方（openid）
     * @param title       标题
     * @param description 描述
     * @param picUrl      图文消息的图片链接，支持JPG、PNG格式，较好的效果为大图640*320，小图80*80
     * @param url         图文消息被点击后跳转的链接
     * @return WxCustomSendModel
     */
    public static WxCustomSendModel getNewsMsg(String toUser, String title, String description, String picUrl, String url) {
        return getNewsMsg(toUser, title, description, picUrl, url, null);
    }

    /**
     * 客服消息-发送图文消息（点击跳转到外链）
     * <p>发送单条图文消息</p>
     *
     * @param toUser      客服消息接收方（openid）
     * @param title       标题
     * @param description 描述
     * @param picUrl      图文消息的图片链接，支持JPG、PNG格式，较好的效果为大图640*320，小图80*80
     * @param url         图文消息被点击后跳转的链接
     * @param kfAccount   客服帐号
     * @return WxCustomSendModel
     */
    public static WxCustomSendModel getNewsMsg(String toUser, String title, String description, String picUrl, String url, String kfAccount) {
        // 封装客服图文消息对象
        WxNewsMsgModel news = WxMsgUtil.getWxNewsMsgModel(title, description, picUrl, url);

        // 封装客服消息对象
        WxCustomSendModel model = getWxCustomSendModel(toUser, WxMsgType.NEWS, kfAccount);
        model.setNews(news);
        return model;
    }

    /**
     * 客服消息-发送图文消息（点击跳转到外链）
     *
     * @param toUser   客服消息接收方（openid）
     * @param articles 图文消息对象集合
     * @return WxCustomSendModel
     */
    public static WxCustomSendModel getNewsMsg(String toUser, List<WxNewsItemMsgModel> articles) {
        return getNewsMsg(toUser, articles, null);
    }

    /**
     * 客服消息-发送图文消息（点击跳转到外链）
     *
     * @param toUser    客服消息接收方（openid）
     * @param articles  图文消息对象集合
     * @param kfAccount 客服帐号
     * @return WxCustomSendModel
     */
    public static WxCustomSendModel getNewsMsg(String toUser, List<WxNewsItemMsgModel> articles, String kfAccount) {
        // 封装客服图文消息对象
        WxNewsMsgModel news = WxMsgUtil.getWxNewsMsgModel(articles);

        // 封装客服消息对象
        WxCustomSendModel model = getWxCustomSendModel(toUser, WxMsgType.NEWS, kfAccount);
        model.setNews(news);
        return model;
    }

    /**
     * 客服消息-发送图文消息（点击跳转到图文消息页面）
     *
     * @param toUser  客服消息接收方（openid）
     * @param mediaId 媒体ID
     * @return WxCustomSendModel
     */
    public static WxCustomSendModel getMpNewsMsg(String toUser, String mediaId) {
        return getMpNewsMsg(toUser, mediaId, null);
    }

    /**
     * 客服消息-发送图文消息（点击跳转到图文消息页面）
     *
     * @param toUser    客服消息接收方（openid）
     * @param mediaId   媒体ID
     * @param kfAccount 客服帐号
     * @return WxCustomSendModel
     */
    public static WxCustomSendModel getMpNewsMsg(String toUser, String mediaId, String kfAccount) {
        // 封装客服图文消息对象
        WxMpNewsMsgModel mpNews = WxMsgUtil.getWxMpNewsMsgModel(mediaId);

        // 封装客服消息对象
        WxCustomSendModel model = getWxCustomSendModel(toUser, WxMsgType.MPNEWS, kfAccount);
        model.setMpNews(mpNews);
        return model;
    }

    /**
     * 客服消息-发送微信卡券
     *
     * @param toUser 客服消息接收方（openid）
     * @param cardId 卡券编号
     * @return WxCustomSendModel
     */
    public static WxCustomSendModel getCardMsg(String toUser, String cardId) {
        return getCardMsg(toUser, cardId, null);
    }

    /**
     * 客服消息-发送微信卡券
     *
     * @param toUser    客服消息接收方（openid）
     * @param cardId    卡券编号
     * @param kfAccount 客服帐号
     * @return WxCustomSendModel
     */
    public static WxCustomSendModel getCardMsg(String toUser, String cardId, String kfAccount) {
        // 封装微信卡券信息
        WxCardMsgModel wxCard = WxMsgUtil.getWxCardMsgModel(cardId);

        // 封装客服消息对象
        WxCustomSendModel model = getWxCustomSendModel(toUser, WxMsgType.WXCARD, kfAccount);
        model.setWxCard(wxCard);
        return model;
    }

    /**
     * 客服消息-发送小程序卡片
     *
     * @param toUser       客服消息接收方（openid）
     * @param title        标题
     * @param appId        小程序的appid，要求小程序的appid需要与公众号有关联关系
     * @param pagePath     小程序的页面路径，跟app.json对齐，支持参数
     * @param thumbMediaId 缩略图媒体ID
     * @return WxCustomSendModel
     */
    public static WxCustomSendModel getMiniMsg(String toUser, String title, String appId, String pagePath, String thumbMediaId) {
        return getMiniMsg(toUser, title, appId, pagePath, thumbMediaId, null);
    }

    /**
     * 客服消息-发送小程序卡片
     *
     * @param toUser       客服消息接收方（openid）
     * @param title        标题
     * @param appId        小程序的appid，要求小程序的appid需要与公众号有关联关系
     * @param pagePath     小程序的页面路径，跟app.json对齐，支持参数
     * @param thumbMediaId 缩略图媒体ID
     * @param kfAccount    客服帐号
     * @return WxCustomSendModel
     */
    public static WxCustomSendModel getMiniMsg(String toUser, String title, String appId, String pagePath, String thumbMediaId, String kfAccount) {
        // 封装小程序卡片信息
        WxMiniProMsgModel mini = WxMsgUtil.getWxMiniProMsgModel(title, appId, pagePath, thumbMediaId);

        // 封装客服消息对象
        WxCustomSendModel model = getWxCustomSendModel(toUser, WxMsgType.MINIPROGRAMPAGE, kfAccount);
        model.setMiniProgramPage(mini);
        return model;
    }
}