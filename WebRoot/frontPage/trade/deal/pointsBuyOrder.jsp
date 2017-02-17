<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>填写积分购买订单（交易中心）</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <!-- ************交易中心积分购买下单页面****************
    1、购买者ID使用隐藏表单存到pointsTrade.buyID中
    2、订单单价、数量、售卖人ID等信息写到pointsTrade.saleID等中。
    注意：订单默认的数量是pointsSale表中挂卖的剩余量，购买者输入的数量不能超过这个值。
    表单提交处理方法：frontTrade_pointsTrade_buyPoints
    3、提交表单之后返回状态码state,200为交易成功，201为按此价格不能购买到足够的积分（例如订单是以
    1.1元价格购买3000，但是1.1的只有1200，则默认成交1200积分），205为现金余额不足，206为未知原因。
    
     -->
  </body>
</html>
