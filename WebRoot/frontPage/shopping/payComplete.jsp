<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>支付成功</title>
	<link rel="stylesheet" type="text/css" href="<%=path %>/frontCss/shopping/payComplete.css">
  </head>
  <body>
	<div class="box">
    	<div class="nav_top">
        </div>
        <div class="center">
        	<img src="<%=path %>/upload/image/error/success.png" width="45px" height="45px" />
        	<span>支付成功</span>
            <p>感谢您在本商城购物!您的订单已经提交成功!我们会尽快为您发货!祝您购物愉快!</p>
            <a href="frontShopping_Index_bodyData" target="index"><div class="successdiv"><span>确&nbsp;认</span></div></a>
        </div>
    </div>
    <div class="addHei"></div>
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
