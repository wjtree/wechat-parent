<%@page import="com.wechat.util.base.WeixinUtil"%>
<%@page import="com.wechat.entity.sys.user.authorize.AccessTokenWy"%>
<%@page import="com.wechat.util.depend.Constant"%>
<%@page import="java.util.Map"%>
<%@page import="com.wechat.util.base.JsSdkSign"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<title>Wechat-JS-SDK</title>
<%
	//String urlStr = request.getScheme() + "://" + request.getServerName();
	String url = request.getRequestURL().toString();
	String pars = request.getQueryString(); // 获取参数
	if(null != pars)
		url += "?" + pars;
	System.out.println(url);
	
	String code = request.getParameter("code");
	String state = request.getParameter("state");
	AccessTokenWy token = WeixinUtil.getAccessTokenWy(Constant.APPID, Constant.APPSECRET, code);
	
	Map<String, String> map = JsSdkSign.sign(url);
	String appId = Constant.APPID;
	String timestamp = map.get("timestamp").toString();
	String nonceStr = map.get("nonceStr").toString();
	String signature = map.get("signature").toString();
%>
</head>
<body>
	<h3>网页授权和JS校验</h3>
	code:<%=code %><br>
	state:<%=state %><br>
	tokenWy:<%=token.getTokenWy() %><br>
	openid:<%=token.getOpenid() %><br>
	<hr>
	<h3 id="menu-image">图像接口</h3>
	<span>拍照或从手机相册中选图接口</span><br>
	<button id="chooseImage">chooseImage</button><br><br>
	<span>预览图片接口</span><br><br>
	<button id="previewImage">previewImage</button><br><br>
	<span>上传图片接口</span><br><br>
	<button id="uploadImage">uploadImage</button><br><br>
	<span>下载图片接口</span><br><br>
	<button id="downloadImage">downloadImage</button><br><br>
</body>
<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script>
	/*
	 * 注意：
	 * 1. 所有的JS接口只能在公众号绑定的域名下调用，公众号开发者需要先登录微信公众平台进入“公众号设置”的“功能设置”里填写“JS接口安全域名”。
	 * 2. 如果发现在 Android 不能分享自定义内容，请到官网下载最新的包覆盖安装，Android 自定义分享接口需升级至 6.0.2.58 版本及以上。
	 * 3. 常见问题及完整 JS-SDK 文档地址：http://mp.weixin.qq.com/wiki/7/aaa137b55fb2e0456bf8dd9148dd613f.html
	 *
	 * 开发中遇到问题详见文档“附录5-常见错误及解决办法”解决，如仍未能解决可通过以下渠道反馈：
	 * 邮箱地址：weixin-open@qq.com
	 * 邮件主题：【微信JS-SDK反馈】具体问题
	 * 邮件内容说明：用简明的语言描述问题所在，并交代清楚遇到该问题的场景，可附上截屏图片，微信团队会尽快处理你的反馈。
	 */
	 wx.config({
		debug : true,
		appId : '<%=appId%>',
		timestamp : <%=timestamp%>,
		nonceStr : '<%=nonceStr%>',
		signature : '<%=signature%>',
		jsApiList : [ 'checkJsApi', 'onMenuShareTimeline',
				'onMenuShareAppMessage', 'onMenuShareQQ', 'onMenuShareWeibo',
				'onMenuShareQZone', 'hideMenuItems', 'showMenuItems',
				'hideAllNonBaseMenuItem', 'showAllNonBaseMenuItem',
				'translateVoice', 'startRecord', 'stopRecord',
				'onVoiceRecordEnd', 'playVoice', 'onVoicePlayEnd',
				'pauseVoice', 'stopVoice', 'uploadVoice', 'downloadVoice',
				'chooseImage', 'previewImage', 'uploadImage', 'downloadImage',
				'getNetworkType', 'openLocation', 'getLocation',
				'hideOptionMenu', 'showOptionMenu', 'closeWindow',
				'scanQRCode', 'chooseWXPay', 'openProductSpecificView',
				'addCard', 'chooseCard', 'openCard' ]
	});
</script>
<script type="text/javascript" src="../script/demo.js"></script>
</html>