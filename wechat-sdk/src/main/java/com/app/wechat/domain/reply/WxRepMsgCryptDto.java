package com.app.wechat.domain.reply;

import com.app.wechat.domain.WxObject;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * <p>功 能：微信公众平台被动回复加密消息实体类</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月28日 下午5:33:46</p>
 * @author 王建
 * @version 1.0
 */
public class WxRepMsgCryptDto extends WxObject {
    private static final long serialVersionUID = 1L;

    /** 密文消息签名 */
    @XStreamAlias("MsgSignature")
    private String msgSignature;

    /** 时间戳 */
    @XStreamAlias("TimeStamp")
    private String timeStamp;

    /** 随机字符串 */
    @XStreamAlias("Nonce")
    private String nonce;

    /** 密文消息 */
    @XStreamAlias("Encrypt")
    private String encrypt;

    public WxRepMsgCryptDto() {
    }

    public WxRepMsgCryptDto(String msgSignature, String timeStamp, String nonce, String encrypt) {
        this.msgSignature = msgSignature;
        this.timeStamp = timeStamp;
        this.nonce = nonce;
        this.encrypt = encrypt;
    }

    public String getMsgSignature() {
        return msgSignature;
    }

    public void setMsgSignature(String msgSignature) {
        this.msgSignature = msgSignature;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getEncrypt() {
        return encrypt;
    }

    public void setEncrypt(String encrypt) {
        this.encrypt = encrypt;
    }
}