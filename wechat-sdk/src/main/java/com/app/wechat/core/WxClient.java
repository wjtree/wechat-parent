package com.app.wechat.core;

import com.app.wechat.internal.exception.WxApiException;
import com.app.wechat.request.AbstractWxRequest;
import com.app.wechat.response.AbstractWxResponse;

/**
 * <p>功 能：微信公众平台API统一请求接口</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月14日 上午10:43:04</p>
 * @author 王建
 * @version 1.0
 */
public interface WxClient {
	/**
	 * 执行API请求，获取请求结果
	 * @param request API请求参数
	 * @return API请求响应
	 * @throws WxApiException
	 */
	<T extends AbstractWxResponse> T execute(AbstractWxRequest<T> request) throws WxApiException;
}