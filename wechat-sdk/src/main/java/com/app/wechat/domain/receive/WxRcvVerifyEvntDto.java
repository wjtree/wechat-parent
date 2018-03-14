package com.app.wechat.domain.receive;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * <p>功 能：微信认证事件推送API数据结构</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月8日 下午2:24:09</p>
 * 
 * <p>请注意：</p>
 * <ol>
 * 	<li>资质认证成功后，公众号就获得了认证相关接口权限，资质认证成功一定发生在名称认证成功之前</li>
 * 	<li>名称认证成功后，公众号才在微信客户端中获得打勾认证标识</li>
 * </ol>
 * 
 * @author 王建
 * @version 1.0
 */
public class WxRcvVerifyEvntDto extends WxRcvEvntDto {
	private static final long serialVersionUID = 1L;

	/** 有效期 (整形)，指的是时间戳，将于该时间戳认证过期 */
	@XStreamAlias("ExpiredTime")
	private Long expiredTime;

	/** 失败发生时间 (整形)，时间戳 */
	@XStreamAlias("FailTime")
	private Long failTime;

	/** 认证失败的原因 */
	@XStreamAlias("FailReason")
	private String failReason;

	public Long getExpiredTime() {
		return expiredTime;
	}

	public void setExpiredTime(Long expiredTime) {
		this.expiredTime = expiredTime;
	}

	public Long getFailTime() {
		return failTime;
	}

	public void setFailTime(Long failTime) {
		this.failTime = failTime;
	}

	public String getFailReason() {
		return failReason;
	}

	public void setFailReason(String failReason) {
		this.failReason = failReason;
	}
}