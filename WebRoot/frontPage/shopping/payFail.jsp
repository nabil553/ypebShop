<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>操作失败</title>
	<link rel="stylesheet" type="text/css" href="<%=path %>/frontCss/shopping/payComplete.css">
  </head>
  <body>
	<div class="box">
    	<div class="nav_top">
        </div>
        <div class="center">
        	<img src="<%=path %>/upload/image/error/error.png" width="45px" height="45px" />
        	<span>操作失败</span>
            <p>尊敬的用户!本次交易失败,${erro },请核对信息重新下单!感谢您的合作!</p>
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
