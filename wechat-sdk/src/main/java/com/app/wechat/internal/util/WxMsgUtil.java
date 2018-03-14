package com.app.wechat.internal.util;

import com.app.wechat.domain.msg.*;
import com.app.wechat.internal.code.Constant;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * <p>功 能：微信公众号消息对象组装工具类</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月15日 下午12:24:06</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxMsgUtil {
    /**
     * 获取文本消息对象
     *
     * @param content 文本消息内容
     * @return WxTextMsgModel
     */
    public static WxTextMsgModel getWxTextMsgModel(String content) {
        WxTextMsgModel model = new WxTextMsgModel();
        model.setContent(content);
        return model;
    }

    /**
     * 获取图片消息对象
     *
     * @param mediaId 媒体id
     * @return WxImgMsgModel
     */
    public static WxImgMsgModel getWxImgMsgModel(String mediaId) {
        WxImgMsgModel model = new WxImgMsgModel();
        model.setMediaId(mediaId);
        return model;
    }

    /**
     * 获取语音消息对象
     *
     * @param mediaId 媒体id
     * @return WxVoiceMsgModel
     */
    public static WxVoiceMsgModel getWxVoiceMsgModel(String mediaId) {
        WxVoiceMsgModel model = new WxVoiceMsgModel();
        model.setMediaId(mediaId);
        return model;
    }

    /**
     * 获取视频消息对象，预览群发视频消息API使用
     *
     * @param mediaId 通过素材管理中的接口上传多媒体文件，得到的id
     * @return WxVideoMsgModel
     */
    public static WxVideoMsgModel getWxVideoMsgModel(String mediaId) {
        return getWxVideoMsgModel(mediaId, null, null, null);
    }

    /**
     * 获取视频消息对象，自动回复消息API使用
     *
     * @param mediaId     通过素材管理中的接口上传多媒体文件，得到的id
     * @param title       视频消息的标题
     * @param description 视频消息的描述
     * @return WxVideoMsgModel
     */
    public static WxVideoMsgModel getWxVideoMsgModel(String mediaId, String title, String description) {
        return getWxVideoMsgModel(mediaId, null, title, description);
    }

    /**
     * 获取视频消息对象，客服消息API使用
     *
     * @param mediaId      通过素材管理中的接口上传多媒体文件，得到的id
     * @param thumbMediaId 缩略图的媒体ID
     * @param title        视频消息的标题
     * @param description  视频消息的描述
     * @return WxVideoMsgModel
     */
    public static WxVideoMsgModel getWxVideoMsgModel(String mediaId, String thumbMediaId, String title, String description) {
        WxVideoMsgModel model = new WxVideoMsgModel();
        model.setMediaId(mediaId);
        model.setThumbMediaId(thumbMediaId);
        model.setTitle(title);
        model.setDescription(description);
        return model;
    }

    /**
     * 获取音乐消息对象
     *
     * @param title        音乐标题
     * @param description  音乐描述
     * @param musicURL     音乐链接
     * @param hqMusicUrl   高质量音乐链接，WIFI环境优先使用该链接播放音乐
     * @param thumbMediaId 缩略图的媒体id，通过素材管理中的接口上传多媒体文件，得到的id
     * @return WxMusicMsgModel
     */
    public static WxMusicMsgModel getWxMusicMsgModel(String title, String description, String musicURL, String hqMusicUrl, String thumbMediaId) {
        WxMusicMsgModel model = new WxMusicMsgModel();
        model.setTitle(title);
        model.setDescription(description);
        model.setMusicUrl(hqMusicUrl);
        model.setHqMusicUrl(hqMusicUrl);
        model.setThumbMediaId(thumbMediaId);
        return model;
    }

    /**
     * 获取卡券对象
     *
     * @param cardId 卡券编号
     * @return WxCardMsgModel
     */
    public static WxCardMsgModel getWxCardMsgModel(String cardId) {
        return getWxCardMsgModel(cardId, null);
    }

    /**
     * 获取卡券对象
     *
     * @param cardId  卡券编号
     * @param cardExt 卡券附加参数
     * @return WxCardMsgModel
     */
    public static WxCardMsgModel getWxCardMsgModel(String cardId, String cardExt) {
        WxCardMsgModel model = new WxCardMsgModel();
        model.setCardId(cardId);
        model.setCardExt(cardExt);
        return model;
    }

    /**
     * 获取小程序卡片对象
     *
     * @param title        标题
     * @param appId        小程序的appid，要求小程序的appid需要与公众号有关联关系
     * @param pagePath     小程序的页面路径，跟app.json对齐，支持参数，比如pages/index/index?foo=bar
     * @param thumbMediaId 小程序卡片图片的媒体ID，小程序卡片图片建议大小为520*416
     * @return WxMiniProMsgModel
     */
    public static WxMiniProMsgModel getWxMiniProMsgModel(String title, String appId, String pagePath, String thumbMediaId) {
        WxMiniProMsgModel model = new WxMiniProMsgModel();
        model.setTitle(title);
        model.setAppId(appId);
        model.setPagePath(pagePath);
        model.setThumbMediaId(thumbMediaId);
        return model;
    }

    /**
     * 获取图文消息（点击跳转到图文消息页面）对象，客服消息API使用
     *
     * @param mediaId 媒体id，可以调用多媒体文件下载接口拉取数据
     * @return WxMpNewsMsgModel
     */
    public static WxMpNewsMsgModel getWxMpNewsMsgModel(String mediaId) {
        WxMpNewsMsgModel model = new WxMpNewsMsgModel();
        model.setMediaId(mediaId);
        return model;
    }

    /**
     * 获取图文消息对象，自动回复消息API使用
     *
     * @param title       图文消息标题
     * @param description 图文消息描述
     * @param picUrl      图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
     * @param url         点击图文消息跳转链接
     * @return WxNewsItemMsgModel
     */
    public static WxNewsItemMsgModel getWxNewsItemMsgModel(String title, String description, String picUrl, String url) {
        return getWxNewsItemMsgModel(title, description, picUrl, url, null, null, null, null, null, null);
    }

    /**
     * 封装群发图文消息对象的参数，上传图文消息素材API使用
     * <p>显示封面图，不显示作者和“阅读原文”链接，并抓取正文前64个字作为默认图文描述</p>
     *
     * @param thumbMediaId 图文消息缩略图的media_id，可以在基础支持-上传多媒体文件接口中获得
     * @param title        图文消息的标题
     * @param content      图文消息页面的内容，支持HTML标签
     * @return WxNewsItemMsgModel
     */
    public static WxNewsItemMsgModel getWxNewsItemMsgModel(String thumbMediaId, String title, String content) {
        return getWxNewsItemMsgModel(thumbMediaId, title, null, content, null);
    }

    /**
     * 封装群发图文消息对象的参数，上传图文消息素材API使用
     * <p>显示封面图，不显示作者</p>
     *
     * @param thumbMediaId     图文消息缩略图的media_id，可以在基础支持-上传多媒体文件接口中获得
     * @param title            图文消息的标题
     * @param contentSourceUrl 在图文消息页面点击“阅读原文”后的页面
     * @param content          图文消息页面的内容，支持HTML标签
     * @param digest           图文消息的描述，如本字段为空，则默认抓取正文前64个字
     * @return WxNewsItemMsgModel
     */
    public static WxNewsItemMsgModel getWxNewsItemMsgModel(String thumbMediaId, String title, String contentSourceUrl, String content, String digest) {
        return getWxNewsItemMsgModel(thumbMediaId, null, title, contentSourceUrl, content, digest, Constant.YES);
    }

    /**
     * 获取图文消息对象，上传图文消息素材API使用
     *
     * @param thumbMediaId     图文消息缩略图的media_id
     * @param author           图文消息的作者
     * @param title            图文消息标题
     * @param contentSourceUrl 在图文消息页面点击“阅读原文”后的页面
     * @param content          图文消息页面的内容
     * @param digest           图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空
     * @param showCoverPic     是否显示封面，1为显示，0为不显示
     * @return WxNewsItemMsgModel
     */
    public static WxNewsItemMsgModel getWxNewsItemMsgModel(String thumbMediaId, String author, String title, String contentSourceUrl, String content, String digest, Short showCoverPic) {
        return getWxNewsItemMsgModel(title, null, null, null, thumbMediaId, author, contentSourceUrl, content, digest, showCoverPic);
    }

    /**
     * 获取图文消息对象
     *
     * @param title            图文消息标题
     * @param description      图文消息描述
     * @param picUrl           图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
     * @param url              点击图文消息跳转链接
     * @param thumbMediaId     图文消息缩略图的media_id
     * @param author           图文消息的作者
     * @param contentSourceUrl 在图文消息页面点击“阅读原文”后的页面
     * @param content          图文消息页面的内容
     * @param digest           图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空
     * @param showCoverPic     是否显示封面，1为显示，0为不显示
     * @return WxNewsItemMsgModel
     */
    public static WxNewsItemMsgModel getWxNewsItemMsgModel(String title, String description, String picUrl, String url, String thumbMediaId, String author, String contentSourceUrl, String content, String digest, Short showCoverPic) {
        WxNewsItemMsgModel model = new WxNewsItemMsgModel();
        model.setTitle(title);
        model.setDescription(description);
        model.setPicUrl(picUrl);
        model.setUrl(url);
        model.setThumbMediaId(thumbMediaId);
        model.setAuthor(author);
        model.setContentSourceUrl(contentSourceUrl);
        model.setContent(content);
        model.setDigest(digest);
        model.setShowCoverPic(showCoverPic);
        return model;
    }

    /**
     * 获取“单条”图文消息对象，自动回复消息API使用
     *
     * @param title       图文消息标题
     * @param description 图文消息描述
     * @param picUrl      图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
     * @param url         点击图文消息跳转链接
     * @return WxNewsMsgModel
     */
    public static WxNewsMsgModel getWxNewsMsgModel(String title, String description, String picUrl, String url) {
        WxNewsItemMsgModel newsItemMsgModel = getWxNewsItemMsgModel(title, description, picUrl, url);
        return getWxNewsMsgModel(newsItemMsgModel);
    }

    /**
     * 获取“单条”图文消息对象，新增永久图文素材API和上传图文消息素材API使用
     * <p>显示封面图，不显示作者和“阅读原文”链接，并抓取正文前64个字作为默认图文描述</p>
     *
     * @param thumbMediaId 图文消息缩略图的media_id，可以在基础支持-上传多媒体文件接口中获得
     * @param title        图文消息的标题
     * @param content      图文消息页面的内容，支持HTML标签
     * @return WxNewsMsgModel
     */
    public static WxNewsMsgModel getWxNewsMsgModel(String thumbMediaId, String title, String content) {
        return getWxNewsMsgModel(thumbMediaId, title, null, content, null);
    }

    /**
     * 获取“单条”图文消息对象，新增永久图文素材API和上传图文消息素材API使用
     * <p>显示封面图，不显示作者</p>
     *
     * @param thumbMediaId     图文消息缩略图的media_id，可以在基础支持-上传多媒体文件接口中获得
     * @param title            图文消息的标题
     * @param contentSourceUrl 在图文消息页面点击“阅读原文”后的页面
     * @param content          图文消息页面的内容，支持HTML标签
     * @param digest           图文消息的描述，如本字段为空，则默认抓取正文前64个字
     * @return WxNewsMsgModel
     */
    public static WxNewsMsgModel getWxNewsMsgModel(String thumbMediaId, String title, String contentSourceUrl, String content, String digest) {
        return getWxNewsMsgModel(thumbMediaId, null, title, contentSourceUrl, content, digest, Constant.YES);
    }

    /**
     * 获取“单条”图文消息对象，新增永久图文素材API和上传图文消息素材API使用
     *
     * @param thumbMediaId     图文消息缩略图的media_id
     * @param author           图文消息的作者
     * @param title            图文消息标题
     * @param contentSourceUrl 在图文消息页面点击“阅读原文”后的页面
     * @param content          图文消息页面的内容
     * @param digest           图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空
     * @param showCoverPic     是否显示封面，1为显示，0为不显示
     * @return WxNewsMsgModel
     */
    public static WxNewsMsgModel getWxNewsMsgModel(String thumbMediaId, String author, String title, String contentSourceUrl, String content, String digest, Short showCoverPic) {
        WxNewsItemMsgModel newsItemMsgModel = getWxNewsItemMsgModel(thumbMediaId, author, title, contentSourceUrl, content, digest, showCoverPic);
        return getWxNewsMsgModel(newsItemMsgModel);
    }

    /**
     * 获取图文消息对象
     *
     * @param articles 图文消息对象数组
     * @return WxNewsMsgModel
     */
    public static WxNewsMsgModel getWxNewsMsgModel(WxNewsItemMsgModel... articles) {
        return getWxNewsMsgModel(Lists.newArrayList(articles));
    }

    /**
     * 获取图文消息对象
     *
     * @param articles 图文消息对象集合
     * @return WxNewsMsgModel
     */
    public static WxNewsMsgModel getWxNewsMsgModel(List<WxNewsItemMsgModel> articles) {
        WxNewsMsgModel model = new WxNewsMsgModel();
        model.setArticles(articles);
        return model;
    }

    /**
     * 封装图文消息页面的内容，内容中插入小程序卡片，上传图文消息素材API使用
     * <p>小程序卡片跳转小程序</p>
     *
     * @param appid  小程序的AppID
     * @param path   小程序要打开的路径
     * @param title  小程序卡片的标题，不超过35个字
     * @param imgUrl 小程序卡片的封面图链接，图片必须为1080*864像素
     * @return content 图文消息页面的内容
     */
    public static String getMiniCardContent(String appid, String path, String title, String imgUrl) {
        String content = "<mp-miniprogram data-miniprogram-appid=\"%1$s\" data-miniprogram-path=\"%2$s\" data-miniprogram-title=\"%3$s\" data-progarm-imageurl=\"%4$s\"></mp-miniprogram>";
        return String.format(content, appid, path, title, imgUrl);
    }

    /**
     * 封装图文消息页面的内容，内容中插入小程序卡片，上传图文消息素材API使用
     * <p>文字跳转小程序</p>
     *
     * @param appid 小程序的AppID
     * @param path  小程序要打开的路径
     * @param title 小程序卡片的标题，不超过35个字
     * @return content 图文消息页面的内容
     */
    public static String getMiniTextContent(String appid, String path, String title) {
        String content = "<p><a data-miniprogram-appid=\"%1$s\" data-miniprogram-path=\"%2$s\" href=\"\">%3$s</a></p>";
        return String.format(content, appid, path, title);
    }

    /**
     * 封装图文消息页面的内容，内容中插入小程序卡片，上传图文消息素材API使用
     * <p>图片跳转小程序</p>
     *
     * @param appid  小程序的AppID
     * @param path   小程序要打开的路径
     * @param imgUrl 小程序卡片的封面图链接，图片必须为1080*864像素
     * @return content 图文消息页面的内容
     */
    public static String getMiniImgContent(String appid, String path, String imgUrl) {
        String content = "<p><a data-miniprogram-appid=\"%1$s\" data-miniprogram-path=\"%2$s\" href=\"\"><img data-src=\"%3$s\"></a></p>";
        return String.format(content, appid, path, imgUrl);
    }
}