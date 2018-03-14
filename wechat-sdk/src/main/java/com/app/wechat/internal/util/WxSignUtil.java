package com.app.wechat.internal.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import com.app.wechat.domain.WxMsgDto;
import com.app.wechat.domain.WxSignDto;

/**
 * <p>功 能：微信签名校验工具类</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年5月5日 下午6:30:20</p>
 * @author 王建
 * @version 1.0
 */
public class WxSignUtil {
	/**
	 * 验证微信签名
	 * @param token
	 * @param wxSignDto
	 * @return
	 */
	public static boolean checkSignature(final String token, final WxSignDto wxSignDto) throws Exception {
		// 获取签名参数
		String signature = wxSignDto.getSignature();
		String timestamp = wxSignDto.getTimestamp();
		String nonce = wxSignDto.getNonce();

		// 获取参数签名
		String sign = getSignature(token, timestamp, nonce);

		// 校验签名参数
		return StringUtils.equals(sign, signature);
	}

	/**
	 * 验证微信加解密签名
	 * @param token
	 * @param wxSignDto
	 * @param wxMsgDto
	 * @return
	 * @throws Exception
	 */
	public static boolean checkCryptSignature(final String token, final WxSignDto wxSignDto, final WxMsgDto wxMsgDto) throws Exception {
		// 获取签名参数
		String msgSignature = wxSignDto.getMsgSignature();
		String timestamp = wxSignDto.getTimestamp();
		String nonce = wxSignDto.getNonce();
		String encrypt = wxMsgDto.getEncrypt();

		// 获取参数签名
		String sign = getSignature(token, timestamp, nonce, encrypt);

		// 校验签名参数
		return StringUtils.equals(sign, msgSignature);
	}

	/**
	 * 使用SHA1加密算法，获取微信公众号消息签名
	 * @param params 校验参数集
	 * @return
	 * @throws Exception
	 */
	public static String getSignature(final String... params) throws Exception {
		String sign = null;
		if (!StringUtils.isAnyBlank(params)) {
			// 获取字典排序结果，并拼接字符串
			String param = StringUtil.sortParams(params);
			// 对拼接的字符串进行SHA1加密
			sign = DigestUtils.sha1Hex(param);
		}
		return sign;
	}
}