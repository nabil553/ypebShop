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
    
    <title>沂品电子商务平台</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
<link rel="shortcut icon" href="image/favicon.ico">
	<link rel="stylesheet" type="text/css" href="frontCss/index.css">
	<link rel="stylesheet" type="text/css" href="frontCss/header.css">
	<link rel="stylesheet" type="text/css" href="frontCss/bottom.css">
	<script type="text/javascript" src="bootstrap/js/jquery-2.1.4.min.js"></script>
  </head>
  
  <body >
   <!-- *********沂品电子商务平台首页--商城首页*************
   	首页包括head.jsp，body.jsp，bottom.jsp三个文件使用iframe布局。body.jsp中菜单栏（商城/交易中心）下面为刷新页面
   	head
   1、登录状态，用户ID（变量名userID）存在session中，点击用户中心之后刷新body.jsp页面
   2、显示购物车数量（shoppingCarNum）
   3、搜索框。搜索条件存在search中。
   body
   4、栏目。allCategoryList集合中存储了所有的栏目记录
   5、轮播广告。rollList中存放所有轮播广告信息。
   6、广告。advertiseList
   7、楼层。floorList中存放所有楼层。floorList中每个对象为一个category对象，每个楼层左侧的广告也存在category对象中
   	集合数量即为楼层数量。
   8、首页商品。goodsList为集合对面，它的每一个对象为一个floorList对象，floorList对象中存放的是各
   楼层 的商品对象。
   
   bottom
   9、底部要有备案信息。其他信息UI设计，不涉及动态。
    -->
    <%@ include file="head.jsp" %>
	<iframe  frameborder=0 name="index" id="index" width=100% marginheight=0 marginwidth=0  onload="this.height=500"  scrolling=no src="frontShopping_Index_bodyData"></iframe>
	<%@ include file="bottom.jsp" %>
	<!-- iframe高度自适应问题 -->
	<script type="text/javascript">
		function reinitIframe(){
		    var iframe = document.getElementById("index");
		    try{
		        var bHeight = iframe.contentWindow.document.body.scrollHeight,
		            dHeight = iframe.contentWindow.document.documentElement.scrollHeight,
		            height = Math.max(bHeight, dHeight);
		        iframe.height =  height;
		    }catch (ex){}
		}
		window.setInterval("reinitIframe()", 200);
	</script>
  </body>
</html>
