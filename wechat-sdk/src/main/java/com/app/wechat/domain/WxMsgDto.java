package com.app.wechat.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * <p>功 能：微信公众平台消息管理API基础数据结构</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月10日 下午5:30:32</p>
 * @author 王建
 * @version 1.0
 */
public class WxMsgDto extends WxObject {
	private static final long serialVersionUID = 1L;

	/** 开发者微信号 */
	@XStreamAlias("ToUserName")
	private String toUserName;

	/** 发送方帐号（OpenID） */
	@XStreamAlias("FromUserName")
	private String fromUserName;

	/** 消息创建时间 （整型） */
	@XStreamAlias("CreateTime")
	private Long createTime;

	/** 消息类型 */
	@XStreamAlias("MsgType")
	private String msgType;

	/** 加密消息体 */
	@XStreamAlias("Encrypt")
	private String encrypt;

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getEncrypt() {
		return encrypt;
	}

	public void setEncrypt(String encrypt) {
		this.encrypt = encrypt;
	}
}