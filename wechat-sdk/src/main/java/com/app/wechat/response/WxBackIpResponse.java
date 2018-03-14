package com.app.wechat.response;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * <p>功 能：微信服务器IP地址列表API的响应结果</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月5日 下午2:19:41</p>
 * @author 王建
 * @version 1.0
 */
public class WxBackIpResponse extends AbstractWxResponse {
	private static final long serialVersionUID = 1L;

	/** 微信服务器IP地址列表 */
	@JSONField(name = "ip_list")
	private String[] ipList;

	public String[] getIpList() {
		return ipList;
	}

	public void setIpList(String[] ipList) {
		this.ipList = ipList;
	}
}