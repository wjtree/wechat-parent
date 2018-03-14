package com.app.wechat.core;

/**
 * <p>功 能：微信公众平台消息排重处理接口</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月22日 下午4:14:13</p>
 * @author 王建
 * @version 1.0
 */
public interface WxExcludeReptMsg {
	/**
	 * 检查接收的事件推送是否重复
	 * @param fromUserName 发送方帐号（一个OpenID）
	 * @param createTime 消息创建时间 （整型）
	 * @return
	 */
	boolean isEventRepeat(String fromUserName, Long createTime);

	/**
	 * 检查接收的普通消息是否重复
	 * @param msgId 消息id，64位整型
	 * @return
	 */
	boolean isMsgRepeat(String msgId);
}