package com.app.wechat.domain;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * <p>功 能：微信公众平台签名校验属性</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月10日 下午4:08:35</p>
 * @author 王建
 * @version 1.0
 */
public class WxSignDto extends WxObject {
	private static final long serialVersionUID = 1L;

	/** 微信加密签名 */
	private String signature;

	/** 时间戳 */
	private String timestamp;

	/** 随机数 */
	private String nonce;

	/** 随机字符串 */
	private String echostr;

	/** 微信用户标识 */
	private String openid;

	/** 加密类型 */
	@JSONField(name = "encrypt_type")
	private String encryptType;

	/** 加密消息体签名 */
	@JSONField(name = "msg_signature")
	private String msgSignature;

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getNonce() {
		return nonce;
	}

	public void setNonce(String nonce) {
		this.nonce = nonce;
	}

	public String getEchostr() {
		return echostr;
	}

	public void setEchostr(String echostr) {
		this.echostr = echostr;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getEncryptType() {
		return encryptType;
	}

	public void setEncryptType(String encryptType) {
		this.encryptType = encryptType;
	}

	public String getMsgSignature() {
		return msgSignature;
	}

	public void setMsgSignature(String msgSignature) {
		this.msgSignature = msgSignature;
	}
}