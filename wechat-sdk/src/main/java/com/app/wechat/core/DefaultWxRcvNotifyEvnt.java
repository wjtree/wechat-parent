package com.app.wechat.core;

import com.app.wechat.domain.receive.WxRcvMsSendEvntDto;
import com.app.wechat.domain.receive.WxRcvTmplSendEvntDto;
import com.app.wechat.domain.receive.WxRcvVerifyEvntDto;
import com.app.wechat.internal.code.Status;

/**
 * <p>功 能：微信公众平台事件推送消息处理接口默认实现类</p>
 * <p>描 述：此接口用于处理非微信用户触发，直接由微信公众平台推送的事件通知，比如群发消息的群发结果通知等</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月14日 下午5:59:01</p>
 * @author 王建
 * @version 1.0
 */
public class DefaultWxRcvNotifyEvnt implements WxRcvNotifyEvnt {

	public String handleMsSendEvnt(WxRcvMsSendEvntDto dto) {
		return Status.SUCCESS.name();
	}

	public String handleTmplSendEvnt(WxRcvTmplSendEvntDto dto) {
		return Status.SUCCESS.name();
	}

	public String handleQualVerifySuccEvnt(WxRcvVerifyEvntDto dto) {
		return Status.SUCCESS.name();
	}

	public String handleQualVerifyFailEvnt(WxRcvVerifyEvntDto dto) {
		return Status.SUCCESS.name();
	}

	public String handleNameVerifySuccEvnt(WxRcvVerifyEvntDto dto) {
		return Status.SUCCESS.name();
	}

	public String handleNameVerifyFailEvnt(WxRcvVerifyEvntDto dto) {
		return Status.SUCCESS.name();
	}

	public String handleAnnualRenewEvnt(WxRcvVerifyEvntDto dto) {
		return Status.SUCCESS.name();
	}

	public String handleVerifyExpireEvnt(WxRcvVerifyEvntDto dto) {
		return Status.SUCCESS.name();
	}
}