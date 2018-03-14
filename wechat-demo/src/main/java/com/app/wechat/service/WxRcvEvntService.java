package com.app.wechat.service;

import com.app.wechat.core.WxRcvEvnt;
import com.app.wechat.domain.receive.*;
import com.app.wechat.internal.code.Status;
import com.app.wechat.internal.util.WxRepUtil;
import org.springframework.stereotype.Service;

/**
 * <p>功 能：微信公众平台事件推送消息处理接口实现类</p>
 * <p>描 述：此接口用于处理微信用户与公众号交互触发的事件推送</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月14日 下午5:59:01</p>
 * @author 王建
 * @version 1.0
 */
@Service
public class WxRcvEvntService implements WxRcvEvnt {

	public String handleSubscribeEvnt(WxRcvSubEvntDto dto) {
		String imgUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1497524945058&di=efbd0212ae254905b875de6cf3be6742&imgtype=0&src=http%3A%2F%2Fphotocdn.sohu.com%2F20160311%2Fmp63043414_1457687324306_5.jpeg";
		return WxRepUtil.repNewsMsg(dto, "欢迎关注", "自媒体平台", imgUrl, "http://m.soso.com");
	}

	public String handleUnSubscribeEvnt(WxRcvSubEvntDto dto) {
		return Status.SUCCESS.name();
	}

	public String handleScanEvnt(WxRcvScanEvntDto dto) {
		return WxRepUtil.repTextMsg(dto, "扫描带参数二维码事件");
	}

	public String handleLocationEvnt(WxRcvLocEvntDto dto) {
		return WxRepUtil.repTextMsg(dto, "上报地理位置事件");
	}

	public String handleMenuClickEvnt(WxRcvMenuClickEvntDto dto) {
		return WxRepUtil.repTextMsg(dto, "自定义菜单点击事件");
	}

	public String handleMenuViewEvnt(WxRcvMenuViewEvntDto dto) {
		return WxRepUtil.repTextMsg(dto, "自定义菜单跳转链接事件");
	}

	public String handleMenuScanCodeEvnt(WxRcvMenuScanEvntDto dto) {
		return WxRepUtil.repTextMsg(dto, "自定义菜单扫码推事件");
	}

	public String handleMenuPicEvnt(WxRcvMenuPicEvntDto dto) {
		return WxRepUtil.repTextMsg(dto, "自定义菜单弹出系统拍照发图事件");
	}

	public String handleMenuLocationSelectEvnt(WxRcvMenuLocEvntDto dto) {
		return WxRepUtil.repTextMsg(dto, "自定义菜单弹出地理位置选择器事件");
	}

	public String handleMenuMediaIdEvnt(WxRcvMenuEvntDto dto) {
		return WxRepUtil.repTextMsg(dto, "自定义菜单下发消息（除文本消息）事件");
	}

	public String handleMenuViewLimitedEvnt(WxRcvMenuEvntDto dto) {
		return WxRepUtil.repTextMsg(dto, "自定义菜单跳转图文消息URL事件");
	}
}