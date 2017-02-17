<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>帮助中心</title>
	<link rel="stylesheet" type="text/css" href="<%=path %>/frontCss/helpCenter/firm_introduce.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/frontCss/helpCenter/universal.css">
	<script type="text/javascript" src="<%=path %>/bootstrap/js/jquery-2.1.4.min.js"></script>
  </head>

 <body>
	<div class="iframe">
		<h1>公司介绍</h1>
		<p></p>
	</div>
 </body>
</html>
