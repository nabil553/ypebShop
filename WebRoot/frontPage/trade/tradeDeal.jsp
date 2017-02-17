<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>积分买卖</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body onload="window.parent.document.getElementById('mytrade').height=document.body.scrollHeight;">
    <!-- ********** 进行积分交易的页面**********
<<<<<<< HEAD
    1、积分列表，数据类dealRequestList中共12个,boolean值request为1的是售卖对象6个，为0的是购买对象
    6个，尽量做道动态刷新。
    2、我要买（frontTrade_TradeDeal_buyPointsPre）,购买人和售卖人ID存在pointsTrade对象中。
    3、我要卖（frontTrade_TradeDeal_salePointsPre）,购买人和售卖人ID存在pointsTrade对象中
=======
    1、积分列表，数据类dealRequestList中共12个,boolean值request为1的是售卖对象6个，为2的是购买对象
    6个，尽量做道动态刷新。
    2、我要买（front_PointsTrade_buyPointsPre）,购买人和售卖人ID存在pointsTrade对象中。
    3、我要卖（front_PointsTrade_salePointsPre）,购买人和售卖人ID存在pointsTrade对象中
>>>>>>> refs/remotes/origin/master
    
    -->
  </body>
</html>
