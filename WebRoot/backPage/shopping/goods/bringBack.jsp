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
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'bringBack.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<div class="pageContent">
	<div class="pageFormContent" layoutH="58">
		<ul class="tree ">
		<span>请选择商品所属2级分类</span>
			<c:forEach items="${categoryByLevel}" var="list">
				<li><a href="javascript:">${list.name }</a>
					<ul>
						<c:forEach items="${list.secCategoryList }" var="category">
							<li><a href="javascript:"
								onclick="$.bringBack({id1:'${list.id}', id2:'${category.id}',cate2:'${category.name}', cate1:'${list.name}'})">${category.name}</a></li>
						</c:forEach>
					</ul></li>
			</c:forEach>
		</ul>
	</div>

	<div class="formBar">
		<ul>
			<li><div class="button">
					<div class="buttonContent">
						<button class="close" type="button">关闭</button>
					</div>
				</div></li>
		</ul>
	</div>
</div>
</html>
