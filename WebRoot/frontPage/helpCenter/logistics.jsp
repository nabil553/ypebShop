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
	<link rel="stylesheet" type="text/css" href="<%=path %>/frontCss/helpCenter/logistics.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/frontCss/helpCenter/universal.css">
	<script type="text/javascript" src="<%=path %>/bootstrap/js/jquery-2.1.4.min.js"></script>
  </head>

 <body>
	<div class="box">
		<h1>物流配送</h1>
		<p>你购买的商品我们会尽快安排仓库发货，交由第三方物流公司配送（如顺丰、申通、圆通、韵达等），建议你在购买商品时认真确认收货信息，避免不必要的麻烦。</p>
	</div>
 </body>
</html>
