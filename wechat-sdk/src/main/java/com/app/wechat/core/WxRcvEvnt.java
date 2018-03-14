package com.app.wechat.core;

import com.app.wechat.domain.receive.WxRcvLocEvntDto;
import com.app.wechat.domain.receive.WxRcvMenuClickEvntDto;
import com.app.wechat.domain.receive.WxRcvMenuEvntDto;
import com.app.wechat.domain.receive.WxRcvMenuLocEvntDto;
import com.app.wechat.domain.receive.WxRcvMenuPicEvntDto;
import com.app.wechat.domain.receive.WxRcvMenuScanEvntDto;
import com.app.wechat.domain.receive.WxRcvMenuViewEvntDto;
import com.app.wechat.domain.receive.WxRcvScanEvntDto;
import com.app.wechat.domain.receive.WxRcvSubEvntDto;

/**
 * <p>功 能：微信公众平台事件推送消息处理接口</p>
 * <p>描 述：此接口用于处理微信用户与公众号交互触发的事件推送</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月14日 下午5:01:59</p>
 * @author 王建
 * @version 1.0
 */
public interface WxRcvEvnt {
	/**
	 * 处理关注事件
	 * @param dto {@link WxRcvSubEvntDto}
	 * @return
	 */
	String handleSubscribeEvnt(WxRcvSubEvntDto dto);

	/**
	 * 处理取消关注事件
	 * @param dto {@link WxRcvSubEvntDto}
	 * @return
	 */
	String handleUnSubscribeEvnt(WxRcvSubEvntDto dto);

	/**
	 * 处理扫描带参数二维码事件
	 * @param dto {@link WxRcvScanEvntDto}
	 * @return
	 */
	String handleScanEvnt(WxRcvScanEvntDto dto);

	/**
	 * 处理上报地理位置事件
	 * @param dto {@link WxRcvLocEvntDto}
	 * @return
	 */
	String handleLocationEvnt(WxRcvLocEvntDto dto);

	/**
	 * 处理自定义菜单点击事件
	 * @param dto {@link WxRcvMenuClickEvntDto}
	 * @return
	 */
	String handleMenuClickEvnt(WxRcvMenuClickEvntDto dto);

	/**
	 * 处理自定义菜单跳转链接事件
	 * @param dto {@link WxRcvMenuViewEvntDto}
	 * @return
	 */
	String handleMenuViewEvnt(WxRcvMenuViewEvntDto dto);

	/**
	 * 处理自定义菜单扫码推事件
	 * @param dto {@link WxRcvMenuScanEvntDto}
	 * @return
	 */
	String handleMenuScanCodeEvnt(WxRcvMenuScanEvntDto dto);

	/**
	 * 处理自定义菜单弹出系统拍照发图事件
	 * @param dto {@link WxRcvMenuPicEvntDto}
	 * @return
	 */
	String handleMenuPicEvnt(WxRcvMenuPicEvntDto dto);

	/**
	 * 处理自定义菜单弹出地理位置选择器事件
	 * @param dto {@link WxRcvMenuLocEvntDto}
	 * @return
	 */
	String handleMenuLocationSelectEvnt(WxRcvMenuLocEvntDto dto);

	/**
	 * 处理自定义菜单下发消息（除文本消息）事件
	 * <p>数据结构待完善</p>
	 * @param dto {@link WxRcvMenuEvntDto}
	 * @return
	 */
	String handleMenuMediaIdEvnt(WxRcvMenuEvntDto dto);

	/**
	 * 处理自定义菜单跳转图文消息URL事件
	 * <p>数据结构待完善</p>
	 * @param dto {@link WxRcvMenuEvntDto}
	 * @return
	 */
	String handleMenuViewLimitedEvnt(WxRcvMenuEvntDto dto);
}