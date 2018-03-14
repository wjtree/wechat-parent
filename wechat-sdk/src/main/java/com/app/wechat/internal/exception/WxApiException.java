package com.app.wechat.internal.exception;

/**
 * <p>功 能：微信公众平台API请求与响应异常</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月4日 下午2:52:40</p>
 * @author 王建
 * @version 1.0
 */
public class WxApiException extends Exception {
	private static final long serialVersionUID = 1L;

	/** 错误码 */
	private String errCode;

	/** 错误消息 */
	private String errMsg;

	public WxApiException() {
		super();
	}

	public WxApiException(String message, Throwable cause) {
		super(message, cause);
	}

	public WxApiException(String message) {
		super(message);
	}

	public WxApiException(Throwable cause) {
		super(cause);
	}

	public WxApiException(String errCode, String errMsg) {
		super("[" + errCode + "] " + errMsg);
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

	public String getErrCode() {
		return errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}
}