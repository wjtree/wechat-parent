<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 网络协议(http / https)
	String scheme = request.getScheme();
	// 服务器域名
	String serverName = request.getServerName();
	// 服务器端口
	int serverPort = request.getServerPort();
	// 应用上下文
	String contextPath = request.getContextPath();

	// 拼接应用请求的公共网址
	String address = scheme + "://" + serverName;
	// 隐藏80端口号
	if (serverPort != 80)
		address += (":" + serverPort);
	// 拼接上下文
	address += (contextPath + "/");
%>

<!-- 网站 LOGO -->
<link rel="shortcut icon" type="image/x-icon" href="<%=address%>favicon.ico" />
<link rel="icon" type="image/x-icon" href="<%=address%>favicon.ico" />

<!-- JavaScript 公共变量 -->
<script type="text/javascript">
	var appConst = {
		address : '<%=address%>'
	};
</script>