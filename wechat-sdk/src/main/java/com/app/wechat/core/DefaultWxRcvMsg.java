package com.app.wechat.core;

import com.app.wechat.domain.receive.*;
import com.app.wechat.internal.code.Status;

/**
 * <p>功 能：微信公众平台普通消息处理接口默认实现类</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月14日 下午5:59:20</p>
 * @author 王建
 * @version 1.0
 */
public class DefaultWxRcvMsg implements WxRcvMsg {

	public String handleRcvTextMsg(WxRcvTextMsgDto dto) {
		return Status.SUCCESS.name();
	}

	public String handleRcvImageMsg(WxRcvImgMsgDto dto) {
		return Status.SUCCESS.name();
	}

	public String handleRcvVoiceMsg(WxRcvVoiceMsgDto dto) {
		return Status.SUCCESS.name();
	}

	public String handleRcvVideoMsg(WxRcvVideoMsgDto dto) {
		return Status.SUCCESS.name();
	}

	public String handleRcvShtVideoMsg(WxRcvVideoMsgDto dto) {
		return Status.SUCCESS.name();
	}

	public String handleRcvLocMsg(WxRcvLocMsgDto dto) {
		return Status.SUCCESS.name();
	}

	public String handleRcvLinkMsg(WxRcvLinkMsgDto dto) {
		return Status.SUCCESS.name();
	}
}