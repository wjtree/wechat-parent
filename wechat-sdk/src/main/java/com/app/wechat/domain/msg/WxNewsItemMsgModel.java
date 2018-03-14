package com.app.wechat.domain.msg;

import com.alibaba.fastjson.annotation.JSONField;
import com.app.wechat.domain.WxObject;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * <p>功 能：微信公众平台回复图文消息API数据结构</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月14日 上午9:23:15</p>
 *
 * @author 王建
 * @version 1.0
 */
@XStreamAlias("item")
public class WxNewsItemMsgModel extends WxObject {
    private static final long serialVersionUID = 1L;

    /**
     * 图文消息标题
     */
    @XStreamAlias("Title")
    private String title;

    /**
     * 图文消息描述
     */
    @XStreamAlias("Description")
    private String description;

    /**
     * 图片链接，支持JPG、PNG格式，较好的效果为大图640*320，小图80*80
     */
    @JSONField(name = "picurl")
    @XStreamAlias("PicUrl")
    private String picUrl;

    /**
     * 点击图文消息跳转链接
     */
    @XStreamAlias("Url")
    private String url;

    /**
     * 图文消息缩略图的media_id
     */
    @JSONField(name = "thumb_media_id")
    private String thumbMediaId;

    /**
     * 图文消息的作者
     */
    private String author;

    /**
     * 在图文消息页面点击“阅读原文”后的页面<br/>
     * 受安全限制，如需跳转Appstore，可以使用itun.es或appsto.re的短链服务，并在短链后增加 #wechat_redirect 后缀
     */
    @JSONField(name = "content_source_url")
    private String contentSourceUrl;

    /**
     * 图文消息页面的内容
     * <br/>
     * <p>请注意：</p>
     * <ol>
     * <li>支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS</li>
     * <li>具备微信支付权限的公众号，可以使用a标签，其他公众号不能使用</li>
     * <li>涉及图片url必须来源"上传图文消息内的图片获取URL"接口获取，外部图片url将被过滤</li>
     * </ol>
     */
    private String content;

    /**
     * 图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空<br/>
     * 如果本字段为没有填写，则默认抓取正文前64个字
     */
    private String digest;

    /**
     * 是否显示封面，1为显示，0为不显示
     */
    @JSONField(name = "show_cover_pic")
    private Short showCoverPic;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContentSourceUrl() {
        return contentSourceUrl;
    }

    public void setContentSourceUrl(String contentSourceUrl) {
        this.contentSourceUrl = contentSourceUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public Short getShowCoverPic() {
        return showCoverPic;
    }

    public void setShowCoverPic(Short showCoverPic) {
        this.showCoverPic = showCoverPic;
    }
}