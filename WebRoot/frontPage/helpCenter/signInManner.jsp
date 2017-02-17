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
	<link rel="stylesheet" type="text/css" href="<%=path %>/frontCss/helpCenter/signInManner.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/frontCss/helpCenter/universal.css">
	<script type="text/javascript" src="<%=path %>/bootstrap/js/jquery-2.1.4.min.js"></script>
  </head>

 <body>
	<div class="box">
		<h1>注册方式</h1>
		<p>1.点击页面顶部的“免费注册”进入注册页面</p>
		<img src="upload/image/help/1.png">
		<p>2.按照提示输入你的注册信息</p>
		<img src="upload/image/help/2.png">
		<p>3.可以在“我的信息”界面编辑你的信息</p>
		<img src="upload/image/help/3.png">
	</div>
	

	<!-- 解决iframe跳转页面时位置如何返回顶部问题 -->
	<script type="text/javascript">
		function parentGoTop(){
		parent.scrollTo(0,0);
		}
		function addClick(){
		var aList=document.getElementsByTagName("a");
		for(var i=0;i<aList.length;i++){
			aList[i].onclick=function(){parentGoTop();}
			}
		}
		window.onload=function(){addClick();}
	</script>
 </body>
</html>
