package com.app.wechat.core;

import com.app.wechat.domain.receive.WxRcvMsSendEvntDto;
import com.app.wechat.domain.receive.WxRcvTmplSendEvntDto;
import com.app.wechat.domain.receive.WxRcvVerifyEvntDto;

/**
 * <p>功 能：微信公众平台事件推送消息处理接口</p>
 * <p>描 述：此接口用于处理非微信用户触发，直接由微信公众平台推送的事件通知，比如群发消息的群发结果通知等</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月8日 下午2:47:46</p>
 * @author 王建
 * @version 1.0
 */
public interface WxRcvNotifyEvnt {
	/**
	 * 处理群发消息结果推送事件
	 * @param dto {@link WxRcvMsSendEvntDto}
	 * @return
	 */
	String handleMsSendEvnt(WxRcvMsSendEvntDto dto);

	/**
	 * 处理模板消息结果推送事件
	 * @param dto {@link WxRcvTmplSendEvntDto}
	 * @return
	 */
	String handleTmplSendEvnt(WxRcvTmplSendEvntDto dto);

	/**
	 * 处理微信认证事件-资质认证成功
	 * @param dto {@link WxRcvVerifyEvntDto}
	 * @return
	 */
	String handleQualVerifySuccEvnt(WxRcvVerifyEvntDto dto);

	/**
	 * 处理微信认证事件-资质认证失败
	 * @param dto {@link WxRcvVerifyEvntDto}
	 * @return
	 */
	String handleQualVerifyFailEvnt(WxRcvVerifyEvntDto dto);

	/**
	 * 处理微信认证事件-名称认证成功
	 * @param dto {@link WxRcvVerifyEvntDto}
	 * @return
	 */
	String handleNameVerifySuccEvnt(WxRcvVerifyEvntDto dto);

	/**
	 * 处理微信认证事件-名称认证失败
	 * @param dto {@link WxRcvVerifyEvntDto}
	 * @return
	 */
	String handleNameVerifyFailEvnt(WxRcvVerifyEvntDto dto);

	/**
	 * 处理微信认证事件-年审通知
	 * @param dto {@link WxRcvVerifyEvntDto}
	 * @return
	 */
	String handleAnnualRenewEvnt(WxRcvVerifyEvntDto dto);

	/**
	 * 处理微信认证事件-认证过期失效通知
	 * @param dto {@link WxRcvVerifyEvntDto}
	 * @return
	 */
	String handleVerifyExpireEvnt(WxRcvVerifyEvntDto dto);
}