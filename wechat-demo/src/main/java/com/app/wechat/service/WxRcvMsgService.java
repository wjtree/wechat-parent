package com.app.wechat.service;

import com.app.wechat.core.WxRcvMsg;
import com.app.wechat.domain.receive.*;
import com.app.wechat.internal.code.Symbol;
import com.app.wechat.internal.util.WxRepUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>功 能：微信公众平台普通消息处理接口实现类</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月14日 下午5:59:20</p>
 * @author 王建
 * @version 1.0
 */
@Service
public class WxRcvMsgService implements WxRcvMsg {

	public String handleRcvTextMsg(WxRcvTextMsgDto dto) {
		return WxRepUtil.repTextMsg(dto, dto.getContent());
	}

	public String handleRcvVoiceMsg(WxRcvVoiceMsgDto dto) {
		return WxRepUtil.repVoiceMsg(dto, dto.getMediaId());
	}

	public String handleRcvImageMsg(WxRcvImgMsgDto dto) {
		return WxRepUtil.repImageMsg(dto, dto.getMediaId());
	}

	public String handleRcvVideoMsg(WxRcvVideoMsgDto dto) {
		return WxRepUtil.repVideoMsg(dto, dto.getMediaId(), "视频", "自动回复视频消息");
	}

	public String handleRcvShtVideoMsg(WxRcvVideoMsgDto dto) {
		return WxRepUtil.repVideoMsg(dto, dto.getMediaId(), "小视频", "自动回复小视频消息");
	}

	public String handleRcvLocMsg(WxRcvLocMsgDto dto) {
		String loc = StringUtils.joinWith(Symbol.LINE_BREAK.getSymbol(), dto.getLabel(), dto.getLocationX(), dto.getLocationY(), dto.getScale());
		return WxRepUtil.repTextMsg(dto, loc);
	}

	public String handleRcvLinkMsg(WxRcvLinkMsgDto dto) {
		return WxRepUtil.repTextMsg(dto, dto.getUrl());
	}
}