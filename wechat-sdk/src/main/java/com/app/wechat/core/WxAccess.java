package com.app.wechat.core;

import com.app.wechat.domain.WxMsgDto;
import com.app.wechat.domain.WxSignDto;
import com.app.wechat.domain.receive.*;
import com.app.wechat.internal.code.HttpMethod;
import com.app.wechat.internal.code.Status;
import com.app.wechat.internal.code.WxEventType;
import com.app.wechat.internal.code.WxMsgType;
import com.app.wechat.internal.util.MapUtil;
import com.app.wechat.internal.util.WxCryptUtil;
import com.app.wechat.internal.util.WxSignUtil;
import com.app.wechat.internal.util.XmlUtil;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * <p>功 能：微信公众平台与微信公众号服务器交互接口实现类</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年5月8日 上午10:15:42</p>
 * @author 王建
 * @version 1.0
 */
public class WxAccess {
	private static final Logger LOG = LogManager.getLogger(WxAccess.class);

	/** 令牌(Token) */
	private static String token;

	/** 消息加解密密钥(EncodingAESKey) */
	private static String encodingAESKey;

	/** 开发者ID(AppID) */
	private static String appId;

	/** 接收用户交互型事件推送，并返回被动回复消息 */
	private static WxRcvEvnt wxRcvEvnt;

	/** 接收通知型事件推送，根据通知内容进行逻辑处理 */
	private static WxRcvNotifyEvnt wxRcvNotifyEvnt;

	/** 接收普通消息，并返回被动回复消息 */
	private static WxRcvMsg wxRcvMsg;

	/** 消息超时重试时的排重处理 */
	private static WxExcludeReptMsg wxReptMsg;

	/**
	 * 初始化微信公众号开发模式入口对象
	 * <p>使用默认的消息排重处理器，并且不处理任何事件推送和普通消息</p>
	 * @param token 令牌(Token)
	 * @param encodingAESKey 消息加解密密钥(EncodingAESKey)
	 * @param appId 开发者ID(AppID)
	 */
	public WxAccess(String token, String encodingAESKey, String appId) {
		this(token, encodingAESKey, appId, null, null, null, null);
	}

	/**
	 * 初始化微信公众号开发模式入口对象
	 * <p>使用默认的消息排重处理器，并且只处理普通消息</p>
	 * @param token 令牌(Token)
	 * @param encodingAESKey 消息加解密密钥(EncodingAESKey)
	 * @param appId 开发者ID(AppID)
	 * @param wxRcvMsg {@link WxRcvMsg} 接收普通消息，并返回被动回复消息
	 */
	public WxAccess(String token, String encodingAESKey, String appId, WxRcvMsg wxRcvMsg) {
		this(token, encodingAESKey, appId, null, null, wxRcvMsg, null);
	}

	/**
	 * 初始化微信公众号开发模式入口对象
	 * <p>使用默认的消息排重处理器，并且只处理用户交互型事件推送和普通消息</p>
	 * @param token 令牌(Token)
	 * @param encodingAESKey 消息加解密密钥(EncodingAESKey)
	 * @param appId 开发者ID(AppID)
	 * @param wxRcvEvnt {@link WxRcvEvnt} 接收用户交互型事件推送，并返回被动回复消息
	 * @param wxRcvMsg {@link WxRcvMsg} 接收普通消息，并返回被动回复消息
	 */
	public WxAccess(String token, String encodingAESKey, String appId, WxRcvEvnt wxRcvEvnt, WxRcvMsg wxRcvMsg) {
		this(token, encodingAESKey, appId, wxRcvEvnt, null, wxRcvMsg, null);
	}

	/**
	 * 初始化微信公众号开发模式入口对象
	 * <p>使用默认的消息排重处理器</p>
	 * @param token 令牌(Token)
	 * @param encodingAESKey 消息加解密密钥(EncodingAESKey)
	 * @param appId 开发者ID(AppID)
	 * @param wxRcvEvnt {@link WxRcvEvnt} 接收用户交互型事件推送，并返回被动回复消息
	 * @param wxRcvNotifyEvnt {@link WxRcvEvnt} 接收通知型事件推送，并返回被动回复消息
	 * @param wxRcvMsg {@link WxRcvMsg} 接收普通消息，并返回被动回复消息
	 */
	public WxAccess(String token, String encodingAESKey, String appId, WxRcvEvnt wxRcvEvnt, WxRcvNotifyEvnt wxRcvNotifyEvnt, WxRcvMsg wxRcvMsg) {
		this(token, encodingAESKey, appId, wxRcvEvnt, wxRcvNotifyEvnt, wxRcvMsg, null);
	}

	/**
	 * 初始化微信公众号开发模式入口对象
	 * @param token 令牌(Token)
	 * @param encodingAESKey 消息加解密密钥(EncodingAESKey)
	 * @param appId 开发者ID(AppID)
	 * @param wxRcvEvnt {@link WxRcvEvnt} 接收用户交互型事件推送，并返回被动回复消息
	 * @param wxRcvNotifyEvnt {@link WxRcvEvnt} 接收通知型事件推送，并返回被动回复消息
	 * @param wxRcvMsg {@link WxRcvMsg} 接收普通消息，并返回被动回复消息
	 * @param wxReptMsg {@link WxExcludeReptMsg} 消息超时重试时的排重处理
	 */
	public WxAccess(String token, String encodingAESKey, String appId, WxRcvEvnt wxRcvEvnt, WxRcvNotifyEvnt wxRcvNotifyEvnt, WxRcvMsg wxRcvMsg, WxExcludeReptMsg wxReptMsg) {
		try {
			// 如果token为空，直接抛异常
			if (StringUtils.isBlank(token))
				throw new Exception("微信公众号令牌(Token)不能为空");

			// 该参数必填，用于消息签名校验
			WxAccess.token = token;

			// 以下2个参数在启用加密模式的情况下必填，否则可为空
			WxAccess.encodingAESKey = encodingAESKey;
			WxAccess.appId = appId;

			// 初始化用户交互型事件推送消息的处理器，参数为空时使用默认实现
			if (WxAccess.wxRcvEvnt == null)
				WxAccess.wxRcvEvnt = (wxRcvEvnt == null ? new DefaultWxRcvEvnt() : wxRcvEvnt);

			// 初始化通知型事件推送消息的处理器，参数为空时使用默认实现
			if (WxAccess.wxRcvNotifyEvnt == null)
				WxAccess.wxRcvNotifyEvnt = (wxRcvNotifyEvnt == null ? new DefaultWxRcvNotifyEvnt() : wxRcvNotifyEvnt);

			// 初始化普通消息的处理器，参数为空时使用默认实现
			if (WxAccess.wxRcvMsg == null)
				WxAccess.wxRcvMsg = (wxRcvMsg == null ? new DefaultWxRcvMsg() : wxRcvMsg);

			// 初始化消息排重处理器，参数为空时使用默认实现
			if (WxAccess.wxReptMsg == null)
				WxAccess.wxReptMsg = (wxReptMsg == null ? new DefaultWxExcludeReptMsg() : wxReptMsg);
		} catch (Exception e) {
			LOG.error("初始化微信公众号开发模式入口对象出错", e);
		}
	}

	/**
	 * 识别微信公众平台发送的请求类型，以及对应的消息或事件类型，并返回处理结果
	 * <p>默认返回“SUCCESS”字符串</p>
	 * @param request {@link HttpServletRequest}
	 * @return {@link String}
	 */
	public String filterRequest(final HttpServletRequest request) {
		String result = Status.SUCCESS.name();
		try {
			// 获取所有请求参数
			Map<String, String[]> paramsMap = request.getParameterMap();
			// 获取请求输入流，并转换为字符串，使用 UTF-8 编码
			String inStr = IOUtils.toString(request.getInputStream(), StandardCharsets.UTF_8.name());
			// 获取请求方法
			String method = request.getMethod();

			// 使用 Debug模式打印请求参数和请求流的日志
			if (LOG.isDebugEnabled()) {
				LOG.debug("微信公众平台请求参数：{}", paramsMap);
				LOG.debug("微信公众平台请求消息：{}", inStr);
			}

			// 获取请求的响应
			result = filterRequest(paramsMap, inStr, method);
		} catch (Exception e) {
			LOG.error("微信公众平台请求出错", e);
		}
		return StringUtils.defaultString(result, Status.SUCCESS.name());
	}

	/**
	 * 识别微信公众平台发送的请求类型，以及对应的消息或事件类型，并返回处理结果
	 * <p>默认返回“SUCCESS”字符串</p>
	 * @param paramsMap 请求参数，通过 request.getParameterMap() 获取
	 * @param inStr 请求输入流的字符串形式，通过将 request.getInputStream() 流转换为字符串获取
	 * @param method 请求方法，通过 request.getMethod() 获取
	 * @return {@link String}
	 */
	public String filterRequest(final Map<String, String[]> paramsMap, final String inStr, final String method) {
		String result = Status.SUCCESS.name();
		try {
			// 获取请求参数
			WxSignDto dto = MapUtil.arrayToBean(paramsMap, WxSignDto.class);

			// 首先进行请求参数的签名校验
			if (WxSignUtil.checkSignature(token, dto)) {
				// 然后判断请求方法，GET表示启用公众号开发者模式，POST表示接受消息
				if (HttpMethod.GET.matches(method))
					result = dto.getEchostr();
				else if (HttpMethod.POST.matches(method))
					result = filterPost(inStr, dto);
			}
		} catch (Exception e) {
			LOG.error("微信公众平台请求出错", e);
		}
		return StringUtils.defaultString(result, Status.SUCCESS.name());
	}

	/**
	 * 识别微信公众号消息类型（消息或事件），并将消息分发给相应的逻辑处理
	 * @param inStr 微信公众平台请求XML字符串
	 * @param wxSignDto 请求参数
	 * @return
	 * @throws Exception
	 */
	protected String filterPost(String inStr, WxSignDto wxSignDto) {
		String result = Status.SUCCESS.name();
		try {
			// 判断微信公众号是否启用消息加密模式
			boolean cryptFlag = WxCryptUtil.isMsgCrypt(wxSignDto.getEncryptType());
			// 如果消息体加密，则获取解密后的XML字符串
			if (cryptFlag)
				inStr = WxCryptUtil.decryptMsg(inStr, wxSignDto, token, encodingAESKey, appId);

			// 将XML字符串转化为微信基础消息对象，用于识别普通消息和事件推送
			WxMsgDto dto = XmlUtil.toBeanWithCData(inStr, WxMsgDto.class);
			// 识别消息是普通消息还是事件推送，并分发给相应逻辑处理
			if (StringUtils.equalsIgnoreCase(dto.getMsgType(), WxMsgType.EVENT.name()))
				result = filterEvent(inStr);
			else
				result = filterMsg(inStr);

			// 如果已启用消息加密模式，则对回复消息进行加密
			if (cryptFlag)
				result = WxCryptUtil.encryptMsg(result, token, encodingAESKey, appId);
		} catch (Exception e) {
			LOG.error("微信公众平台POST请求出错", e);
		}
		return result;
	}

	/**
	 * 识别具体的微信公众号事件推送类型，并分发给对应的事件处理逻辑
	 * @param inStr 微信公众平台请求XML字符串
	 * @return
	 * @throws Exception
	 */
	protected String filterEvent(String inStr) throws Exception {
		// 将XML字符串转化为微信事件推送实体类
		WxRcvEvntDto dto = XmlUtil.toBeanWithCData(inStr, WxRcvEvntDto.class);

		// 事件推送排重，重复消息直接返回空，不做任何处理
		if (wxReptMsg.isEventRepeat(dto.getFromUserName(), dto.getCreateTime())) {
			if (LOG.isInfoEnabled())
				LOG.info("接收到重复事件推送，来自 {} 的此次事件推送将被忽略", dto.getFromUserName());
			return Status.SUCCESS.name();
		}

		String result = null;
		String event = dto.getEvent();

		// 判断事件通知属于用户交互型还是通知型
		if (WxEventType.isUserEvnt(event))
			result = chooseUserEvent(inStr, event);
		else if (WxEventType.isUserMenuEvnt(event))
			result = chooseUserMenuEvent(inStr, event);
		else if (WxEventType.isNotifyEvnt(event))
			result = chooseNotifyEvent(inStr, event);
		else if (WxEventType.isNotifyVerifyEvnt(event))
			result = chooseNotifyVerifyEvent(inStr, event);

		return result;
	}

	/**
	 * 识别用户交互型事件类型，并获取返回结果
	 * @param inStr 消息XML字符串
	 * @param event 事件类型
	 * @return
	 * @throws Exception
	 */
	protected String chooseUserEvent(String inStr, String event) throws Exception {
		String result = Status.SUCCESS.name();

		if (StringUtils.equalsIgnoreCase(event, WxEventType.SUBSCRIBE.name())) {

			WxRcvSubEvntDto dto = XmlUtil.toBeanWithCData(inStr, WxRcvSubEvntDto.class);
			result = wxRcvEvnt.handleSubscribeEvnt(dto);
		} else if (StringUtils.equalsIgnoreCase(event, WxEventType.UNSUBSCRIBE.name())) {

			WxRcvSubEvntDto dto = XmlUtil.toBeanWithCData(inStr, WxRcvSubEvntDto.class);
			result = wxRcvEvnt.handleUnSubscribeEvnt(dto);
		} else if (StringUtils.equalsIgnoreCase(event, WxEventType.SCAN.name())) {

			WxRcvScanEvntDto dto = XmlUtil.toBeanWithCData(inStr, WxRcvScanEvntDto.class);
			result = wxRcvEvnt.handleScanEvnt(dto);
		} else if (StringUtils.equalsIgnoreCase(event, WxEventType.LOCATION.name())) {

			WxRcvLocEvntDto dto = XmlUtil.toBeanWithCData(inStr, WxRcvLocEvntDto.class);
			result = wxRcvEvnt.handleLocationEvnt(dto);
		}

		return result;
	}

	/**
	 * 识别用户交互型（菜单触发）事件类型，并获取返回结果
	 * @param inStr 消息XML字符串
	 * @param event 事件类型
	 * @return
	 * @throws Exception
	 */
	protected String chooseUserMenuEvent(String inStr, String event) throws Exception {
		String result = Status.SUCCESS.name();

		if (StringUtils.equalsIgnoreCase(event, WxEventType.CLICK.name())) {

			WxRcvMenuClickEvntDto dto = XmlUtil.toBeanWithCData(inStr, WxRcvMenuClickEvntDto.class);
			result = wxRcvEvnt.handleMenuClickEvnt(dto);
		} else if (StringUtils.equalsIgnoreCase(event, WxEventType.VIEW.name())) {

			WxRcvMenuViewEvntDto dto = XmlUtil.toBeanWithCData(inStr, WxRcvMenuViewEvntDto.class);
			result = wxRcvEvnt.handleMenuViewEvnt(dto);
		} else if (StringUtils.equalsAnyIgnoreCase(event, WxEventType.USER_MENU_SCAN_EVNT_ARR)) {

			WxRcvMenuScanEvntDto dto = XmlUtil.toBeanWithCData(inStr, WxRcvMenuScanEvntDto.class);
			result = wxRcvEvnt.handleMenuScanCodeEvnt(dto);
		} else if (StringUtils.equalsAnyIgnoreCase(event, WxEventType.USER_MENU_PIC_EVNT_ARR)) {

			WxRcvMenuPicEvntDto dto = XmlUtil.toBeanWithCData(inStr, WxRcvMenuPicEvntDto.class);
			result = wxRcvEvnt.handleMenuPicEvnt(dto);
		} else if (StringUtils.equalsIgnoreCase(event, WxEventType.LOCATION_SELECT.name())) {

			WxRcvMenuLocEvntDto dto = XmlUtil.toBeanWithCData(inStr, WxRcvMenuLocEvntDto.class);
			result = wxRcvEvnt.handleMenuLocationSelectEvnt(dto);
		} else if (StringUtils.equalsIgnoreCase(event, WxEventType.MEDIA_ID.name())) {

			WxRcvMenuEvntDto dto = XmlUtil.toBeanWithCData(inStr, WxRcvMenuEvntDto.class);
			result = wxRcvEvnt.handleMenuMediaIdEvnt(dto);
		} else if (StringUtils.equalsIgnoreCase(event, WxEventType.VIEW_LIMITED.name())) {

			WxRcvMenuEvntDto dto = XmlUtil.toBeanWithCData(inStr, WxRcvMenuEvntDto.class);
			result = wxRcvEvnt.handleMenuViewLimitedEvnt(dto);
		}

		return result;
	}

	/**
	 * 识别通知型事件类型，并获取返回结果
	 * @param inStr 消息XML字符串
	 * @param event 事件类型
	 * @return
	 * @throws Exception
	 */
	protected String chooseNotifyEvent(String inStr, String event) throws Exception {
		String result = Status.SUCCESS.name();

		if (StringUtils.equalsIgnoreCase(event, WxEventType.MASSSENDJOBFINISH.name())) {

			WxRcvMsSendEvntDto dto = XmlUtil.toBeanWithCData(inStr, WxRcvMsSendEvntDto.class);
			result = wxRcvNotifyEvnt.handleMsSendEvnt(dto);
		} else if (StringUtils.equalsIgnoreCase(event, WxEventType.TEMPLATESENDJOBFINISH.name())) {

			WxRcvTmplSendEvntDto dto = XmlUtil.toBeanWithCData(inStr, WxRcvTmplSendEvntDto.class);
			result = wxRcvNotifyEvnt.handleTmplSendEvnt(dto);
		}

		return result;
	}

	/**
	 * 识别通知型（微信认证）事件类型，并获取返回结果
	 * @param inStr 消息XML字符串
	 * @param event 事件类型
	 * @return
	 * @throws Exception
	 */
	protected String chooseNotifyVerifyEvent(String inStr, String event) throws Exception {
		String result = Status.SUCCESS.name();

		// 将XML字符串转换为JavaBean
		WxRcvVerifyEvntDto dto = XmlUtil.toBeanWithCData(inStr, WxRcvVerifyEvntDto.class);

		if (StringUtils.equalsIgnoreCase(event, WxEventType.QUALIFICATION_VERIFY_SUCCESS.name()))
			result = wxRcvNotifyEvnt.handleQualVerifySuccEvnt(dto);

		else if (StringUtils.equalsIgnoreCase(event, WxEventType.QUALIFICATION_VERIFY_FAIL.name()))
			result = wxRcvNotifyEvnt.handleQualVerifyFailEvnt(dto);

		else if (StringUtils.equalsIgnoreCase(event, WxEventType.NAMING_VERIFY_SUCCESS.name()))
			result = wxRcvNotifyEvnt.handleNameVerifySuccEvnt(dto);

		else if (StringUtils.equalsIgnoreCase(event, WxEventType.NAMING_VERIFY_FAIL.name()))
			result = wxRcvNotifyEvnt.handleNameVerifyFailEvnt(dto);

		else if (StringUtils.equalsIgnoreCase(event, WxEventType.ANNUAL_RENEW.name()))
			result = wxRcvNotifyEvnt.handleAnnualRenewEvnt(dto);

		else if (StringUtils.equalsIgnoreCase(event, WxEventType.VERIFY_EXPIRED.name()))
			result = wxRcvNotifyEvnt.handleVerifyExpireEvnt(dto);

		return result;
	}

	/**
	 * 识别具体的微信公众号普通消息类型，并分发给对应的消息处理逻辑
	 * @param inStr 微信公众平台请求XML字符串
	 * @return
	 * @throws Exception
	 */
	protected String filterMsg(String inStr) throws Exception {
		// 将XML字符串转化为微信普通消息实体类
		WxRcvMsgDto dto = XmlUtil.toBeanWithCData(inStr, WxRcvMsgDto.class);

		// 普通消息排重，重复消息直接返回空，不做任何处理
		if (wxReptMsg.isMsgRepeat(dto.getMsgId())) {
			if (LOG.isInfoEnabled())
				LOG.info("接收到重复普通消息，消息 {} 将被忽略", dto.getMsgId());
			return Status.SUCCESS.name();
		}

		// 根据不同的消息类型，分发给对应的消息处理逻辑
		return chooseMsg(inStr, dto.getMsgType());
	}

	/**
	 * 根据不同的消息类型，分发给对应的消息处理逻辑
	 * @param inStr 消息XML字符串
	 * @param msgType 消息类型
	 * @return
	 * @throws Exception
	 */
	protected String chooseMsg(String inStr, String msgType) throws Exception {
		String result = Status.SUCCESS.name();

		if (StringUtils.equalsIgnoreCase(msgType, WxMsgType.TEXT.name())) {

			WxRcvTextMsgDto dto = XmlUtil.toBeanWithCData(inStr, WxRcvTextMsgDto.class);
			result = wxRcvMsg.handleRcvTextMsg(dto);
		} else if (StringUtils.equalsIgnoreCase(msgType, WxMsgType.IMAGE.name())) {

			WxRcvImgMsgDto dto = XmlUtil.toBeanWithCData(inStr, WxRcvImgMsgDto.class);
			result = wxRcvMsg.handleRcvImageMsg(dto);
		} else if (StringUtils.equalsIgnoreCase(msgType, WxMsgType.VOICE.name())) {

			WxRcvVoiceMsgDto dto = XmlUtil.toBeanWithCData(inStr, WxRcvVoiceMsgDto.class);
			result = wxRcvMsg.handleRcvVoiceMsg(dto);
		} else if (StringUtils.equalsIgnoreCase(msgType, WxMsgType.VIDEO.name())) {

			WxRcvVideoMsgDto dto = XmlUtil.toBeanWithCData(inStr, WxRcvVideoMsgDto.class);
			result = wxRcvMsg.handleRcvVideoMsg(dto);
		} else if (StringUtils.equalsIgnoreCase(msgType, WxMsgType.SHORTVIDEO.name())) {

			WxRcvVideoMsgDto dto = XmlUtil.toBeanWithCData(inStr, WxRcvVideoMsgDto.class);
			result = wxRcvMsg.handleRcvShtVideoMsg(dto);
		} else if (StringUtils.equalsIgnoreCase(msgType, WxMsgType.LOCATION.name())) {

			WxRcvLocMsgDto dto = XmlUtil.toBeanWithCData(inStr, WxRcvLocMsgDto.class);
			result = wxRcvMsg.handleRcvLocMsg(dto);
		} else if (StringUtils.equalsIgnoreCase(msgType, WxMsgType.LINK.name())) {

			WxRcvLinkMsgDto dto = XmlUtil.toBeanWithCData(inStr, WxRcvLinkMsgDto.class);
			result = wxRcvMsg.handleRcvLinkMsg(dto);
		}

		return result;
	}
}