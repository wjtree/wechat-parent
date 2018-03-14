<%@page import="com.wechat.entity.sys.user.authorize.UserDetailWy"%>
<%@page import="com.wechat.entity.sys.user.authorize.AccessTokenWy"%>
<%@page import="com.wechat.util.depend.Constant"%>
<%@page import="com.wechat.util.base.WeixinUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<title>网页授权测试页</title>
	<%
		String code = request.getParameter("code");
		String state = request.getParameter("state");
		AccessTokenWy token = WeixinUtil.getAccessTokenWy(Constant.APPID, Constant.APPSECRET, code);
		//UserDetailWy user = WeixinUtil.getUserDetailWy(token.getTokenWy(), token.getOpenid());
	%>
</head>
<body>
	code:<%=code %><br>
	state:<%=state %><br>
	tokenWy:<%=token.getTokenWy() %><br>
	openid:<%=token.getOpenid() %><br>
	<%-- name:<%=user.getNickname() %> --%>
</body>
</html>