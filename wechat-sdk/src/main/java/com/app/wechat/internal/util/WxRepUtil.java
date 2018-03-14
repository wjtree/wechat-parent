package com.app.wechat.internal.util;

import com.app.wechat.domain.WxMsgDto;
import com.app.wechat.domain.msg.*;
import com.app.wechat.domain.reply.*;
import com.app.wechat.internal.code.WxMsgType;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * 微信公众平台自动回复消息API工具类
 *
 * @author Administrator
 * @version 1.0
 */
public class WxRepUtil {
    /**
     * 绑定微信公众号公共消息属性
     *
     * @param t         {@link WxMsgDto} 微信公众号发送给用户的消息对象
     * @param f         {@link WxMsgDto} 微信公众号接收来自用户的消息对象
     * @param wxMsgType 消息类型枚举
     */
    private static <T extends WxMsgDto, F extends WxMsgDto> void bindCommonMsg(T t, F f, WxMsgType wxMsgType) {
        t.setToUserName(f.getFromUserName());
        t.setFromUserName(f.getToUserName());
        t.setCreateTime(System.currentTimeMillis());
        t.setMsgType(wxMsgType.name());
    }

    /**
     * 被动回复文本消息
     *
     * @param f       {@link WxMsgDto} 微信公众号接收来自用户的消息对象
     * @param content 回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）
     * @return String
     */
    public static <F extends WxMsgDto> String repTextMsg(F f, String content) {
        WxRepTextMsgDto dto = new WxRepTextMsgDto();

        // 装载公共消息属性
        bindCommonMsg(dto, f, WxMsgType.TEXT);
        // 装载文本消息属性
        dto.setContent(content);

        // 将文本消息实体类转换为XML格式字符串
        return XmlUtil.toXmlWithCData(dto);
    }

    /**
     * 被动回复图片消息
     *
     * @param f       {@link WxMsgDto} 微信公众号接收来自用户的消息对象
     * @param mediaId 通过素材管理中的接口上传多媒体文件，得到的id
     * @return String
     */
    public static <F extends WxMsgDto> String repImageMsg(F f, String mediaId) {
        WxRepImgMsgDto dto = new WxRepImgMsgDto();

        // 装载公共消息属性
        bindCommonMsg(dto, f, WxMsgType.IMAGE);
        // 装载图片消息属性
        WxImgMsgModel model = WxMsgUtil.getWxImgMsgModel(mediaId);
        dto.setImage(model);

        // 将图片消息实体类转换为XML格式字符串
        return XmlUtil.toXmlWithCData(dto);
    }

    /**
     * 被动回复语音消息
     *
     * @param f       {@link WxMsgDto} 微信公众号接收来自用户的消息对象
     * @param mediaId 通过素材管理中的接口上传多媒体文件，得到的id
     * @return String
     */
    public static <F extends WxMsgDto> String repVoiceMsg(F f, String mediaId) {
        WxRepVoiceMsgDto dto = new WxRepVoiceMsgDto();

        // 装载公共消息属性
        bindCommonMsg(dto, f, WxMsgType.VOICE);
        // 装载语音消息属性
        WxVoiceMsgModel model = WxMsgUtil.getWxVoiceMsgModel(mediaId);
        dto.setVoice(model);

        // 将语音消息实体类转换为XML格式字符串
        return XmlUtil.toXmlWithCData(dto);
    }

    /**
     * 被动回复视频消息
     *
     * @param f           {@link WxMsgDto} 微信公众号接收来自用户的消息对象
     * @param mediaId     通过素材管理中的接口上传多媒体文件，得到的id
     * @param title       视频消息的标题
     * @param description 视频消息的描述
     * @return String
     */
    public static <F extends WxMsgDto> String repVideoMsg(F f, String mediaId, String title, String description) {
        WxRepVideoMsgDto dto = new WxRepVideoMsgDto();

        // 装载公共消息属性
        bindCommonMsg(dto, f, WxMsgType.VIDEO);
        // 装载视频消息属性
        WxVideoMsgModel model = WxMsgUtil.getWxVideoMsgModel(mediaId, title, description);
        dto.setVideo(model);

        // 将视频消息实体类转换为XML格式字符串
        return XmlUtil.toXmlWithCData(dto);
    }

    /**
     * 被动回复音乐消息
     *
     * @param f            {@link WxMsgDto} 微信公众号接收来自用户的消息对象
     * @param title        音乐标题
     * @param description  音乐描述
     * @param musicURL     音乐链接
     * @param hqMusicUrl   高质量音乐链接，WIFI环境优先使用该链接播放音乐
     * @param thumbMediaId 缩略图的媒体id，通过素材管理中的接口上传多媒体文件，得到的id
     * @return String
     */
    public static <F extends WxMsgDto> String repMusicMsg(F f, String title, String description, String musicURL, String hqMusicUrl, String thumbMediaId) {
        WxRepMusicMsgDto dto = new WxRepMusicMsgDto();

        // 装载公共消息属性
        bindCommonMsg(dto, f, WxMsgType.MUSIC);
        // 装载音乐消息属性
        WxMusicMsgModel model = WxMsgUtil.getWxMusicMsgModel(title, description, musicURL, hqMusicUrl, thumbMediaId);
        dto.setMusic(model);

        // 将音乐消息实体类转换为XML格式字符串
        return XmlUtil.toXmlWithCData(dto);
    }

    /**
     * 被动回复图文消息
     * <p>多条图文消息，不能多于8条</p>
     *
     * @param f        {@link WxMsgDto} 微信公众号接收来自用户的消息对象
     * @param articles 图文消息对象集合
     * @return String
     */
    public static <F extends WxMsgDto> String repNewsMsg(F f, List<WxNewsItemMsgModel> articles) {
        WxRepNewsMsgDto dto = new WxRepNewsMsgDto();

        // 装载公共消息属性
        bindCommonMsg(dto, f, WxMsgType.NEWS);
        // 装载图文消息属性
        dto.setArticleCount(articles.size());
        dto.setArticles(articles);

        // 将图文消息实体类转换为XML格式字符串
        return XmlUtil.toXmlWithCData(dto);
    }

    /**
     * 被动回复图文消息
     * <p>多条图文消息，不能多于8条</p>
     *
     * @param f        {@link WxMsgDto} 微信公众号接收来自用户的消息对象
     * @param articles 图文消息对象数组
     * @return String
     */
    public static <F extends WxMsgDto> String repNewsMsg(F f, WxNewsItemMsgModel... articles) {
        return repNewsMsg(f, Lists.newArrayList(articles));
    }

    /**
     * 被动回复图文消息
     * <p>单条图文消息</p>
     *
     * @param f           {@link WxMsgDto} 微信公众号接收来自用户的消息对象
     * @param title       图文消息标题
     * @param description 图文消息描述
     * @param picUrl      图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
     * @param url         点击图文消息跳转链接
     * @return String
     */
    public static <F extends WxMsgDto> String repNewsMsg(F f, String title, String description, String picUrl, String url) {
        // 获取单个图文消息对象
        WxNewsItemMsgModel model = WxMsgUtil.getWxNewsItemMsgModel(title, description, picUrl, url);

        return repNewsMsg(f, model);
    }
}
