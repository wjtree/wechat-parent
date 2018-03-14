<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<%@ include file="../public/head.jsp"%>
<title>异常页面</title>
</head>
<body>
	<!-- 使用 exception 获取异常信息 -->
	<h3>${exception.exceptionMsg}</h3>
	<br />
	<img alt="exception" src="<%=address%>images/404.jpg">
</body>
</html>