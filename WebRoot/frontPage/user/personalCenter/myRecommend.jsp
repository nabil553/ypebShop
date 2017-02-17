<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<base href="<%=basePath%>">
<script src="frontJs/jquery.js"></script>
<link type="text/css" rel="stylesheet"
	href="frontCss/user/recommend_record.css">
<style>
</style>
</head>

<body>
<c:forEach items="${userList }" var="list">
	<div class="item">
		<h1>${list.name }</h1>
		<h2>通过你分享的链接注册成为沂品商城会员</h2>
		
		<div class="clearfix"></div>
		</c:forEach>
	</div>
	
</body>
</html>
