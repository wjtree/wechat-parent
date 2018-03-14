package com.app.wechat.domain.receive;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * <p>功 能：微信公众平台接收普通语音消息API数据结构</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月13日 上午11:59:55</p>
 * @author 王建
 * @version 1.0
 */
public class WxRcvVoiceMsgDto extends WxRcvMsgDto {
    private static final long serialVersionUID = 1L;

    /** 语音消息媒体id，可以调用多媒体文件下载接口拉取数据 */
    @XStreamAlias("MediaId")
    private String mediaId;

    /** 语音格式，如amr，speex等 */
    @XStreamAlias("Format")
    private String format;

    /** 语音识别结果，UTF8编码 */
    @XStreamAlias("Recognition")
    private String recognition;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getRecognition() {
        return recognition;
    }

    public void setRecognition(String recognition) {
        this.recognition = recognition;
    }
}