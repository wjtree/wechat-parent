package com.app.wechat.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.util.IocUtil;
import com.app.wechat.code.WxConstant;
import com.app.wechat.core.WxAccess;
import com.app.wechat.core.WxRcvEvnt;
import com.app.wechat.core.WxRcvMsg;
import com.app.wechat.service.WxRcvEvntService;
import com.app.wechat.service.WxRcvMsgService;

/**
 * <p>功 能：微信公众平台与微信公众号服务器交互接口</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年5月5日 下午5:15:06</p>
 * @author 王建
 * @version 1.0
 */
@RestController
@RequestMapping(produces = "text/plain; charset=UTF-8")
public class WxAccessController {
	/**
	 * 微信公众号接口配置与消息接收入口
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/wxAccess", method = { RequestMethod.GET, RequestMethod.POST })
	public String wxAccess(HttpServletRequest request) {
		// 初始化微信公众平台事件推送消息处理接口
		WxRcvEvnt wxRcvEvnt = IocUtil.getBean(WxRcvEvntService.class);
		// 初始化微信公众平台普通消息处理接口
		WxRcvMsg wxRcvMsg = IocUtil.getBean(WxRcvMsgService.class);

		// 初始化微信公众平台与微信公众号服务器交互接口实现类
		WxAccess wxAccess = new WxAccess(WxConstant.APP_TOKEN, WxConstant.APP_AES_KEY, WxConstant.APP_ID, wxRcvEvnt, wxRcvMsg);

		// 识别微信公众平台发送的请求类型，以及对应的消息或事件类型，并返回处理结果
		return wxAccess.filterRequest(request);
	}
}