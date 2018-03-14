package com.app.wechat.core;

import com.app.wechat.domain.receive.WxRcvImgMsgDto;
import com.app.wechat.domain.receive.WxRcvLinkMsgDto;
import com.app.wechat.domain.receive.WxRcvLocMsgDto;
import com.app.wechat.domain.receive.WxRcvTextMsgDto;
import com.app.wechat.domain.receive.WxRcvVideoMsgDto;
import com.app.wechat.domain.receive.WxRcvVoiceMsgDto;

/**
 * <p>功 能：微信公众平台普通消息处理接口</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月14日 下午5:01:40</p>
 * @author 王建
 * @version 1.0
 */
public interface WxRcvMsg {
	/**
	 * 处理接收的文本消息
	 * @param dto {@link WxRcvTextMsgDto}
	 * @return
	 */
	String handleRcvTextMsg(WxRcvTextMsgDto dto);

	/**
	 * 处理接收的语音消息
	 * @param dto {@link WxRcvVoiceMsgDto}
	 * @return
	 */
	String handleRcvVoiceMsg(WxRcvVoiceMsgDto dto);

	/**
	 * 处理接收的图片消息
	 * @param dto {@link WxRcvImgMsgDto}
	 * @return
	 */
	String handleRcvImageMsg(WxRcvImgMsgDto dto);

	/**
	 * 处理接收的视频消息
	 * @param dto {@link WxRcvVideoMsgDto}
	 * @return
	 */
	String handleRcvVideoMsg(WxRcvVideoMsgDto dto);

	/**
	 * 处理接收的小视频消息
	 * @param dto {@link WxRcvVideoMsgDto}
	 * @return
	 */
	String handleRcvShtVideoMsg(WxRcvVideoMsgDto dto);

	/**
	 * 处理接收的地理位置消息
	 * @param dto {@link WxRcvLocMsgDto}
	 * @return
	 */
	String handleRcvLocMsg(WxRcvLocMsgDto dto);

	/**
	 * 处理接收的链接消息
	 * @param dto {@link WxRcvLinkMsgDto}
	 * @return
	 */
	String handleRcvLinkMsg(WxRcvLinkMsgDto dto);
}