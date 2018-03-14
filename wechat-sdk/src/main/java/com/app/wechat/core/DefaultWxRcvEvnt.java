package com.app.wechat.core;

import com.app.wechat.domain.receive.*;
import com.app.wechat.internal.code.Status;

/**
 * <p>功 能：微信公众平台事件推送消息处理接口默认实现类</p>
 * <p>描 述：此接口用于处理微信用户与公众号交互触发的事件推送</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月14日 下午5:59:01</p>
 * @author 王建
 * @version 1.0
 */
public class DefaultWxRcvEvnt implements WxRcvEvnt {

	public String handleSubscribeEvnt(WxRcvSubEvntDto dto) {
		return Status.SUCCESS.name();
	}

	public String handleUnSubscribeEvnt(WxRcvSubEvntDto dto) {
		return Status.SUCCESS.name();
	}

	public String handleScanEvnt(WxRcvScanEvntDto dto) {
		return Status.SUCCESS.name();
	}

	public String handleLocationEvnt(WxRcvLocEvntDto dto) {
		return Status.SUCCESS.name();
	}

	public String handleMenuClickEvnt(WxRcvMenuClickEvntDto dto) {
		return Status.SUCCESS.name();
	}

	public String handleMenuViewEvnt(WxRcvMenuViewEvntDto dto) {
		return Status.SUCCESS.name();
	}

	public String handleMenuScanCodeEvnt(WxRcvMenuScanEvntDto dto) {
		return Status.SUCCESS.name();
	}

	public String handleMenuPicEvnt(WxRcvMenuPicEvntDto dto) {
		return Status.SUCCESS.name();
	}

	public String handleMenuLocationSelectEvnt(WxRcvMenuLocEvntDto dto) {
		return Status.SUCCESS.name();
	}

	public String handleMenuMediaIdEvnt(WxRcvMenuEvntDto dto) {
		return Status.SUCCESS.name();
	}

	public String handleMenuViewLimitedEvnt(WxRcvMenuEvntDto dto) {
		return Status.SUCCESS.name();
	}
}