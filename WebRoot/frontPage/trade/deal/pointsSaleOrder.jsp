<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>填写积分售卖订单（交易中心）</title>
    
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
    <!-- ************交易中心积分售卖下单页面****************
    1、售卖者ID使用隐藏表单存到pointsSale.buyID中
    2、订单单价、数量、售卖人ID等信息写到pointsTrade.saleID等中。
<<<<<<< HEAD
    3、提交表单，提交ACTION为"frontTrade_TradeDeal_salePoints",提交之后返回状态码state,200为交易成功，201为挂卖积分超出购买申请（此时剩余售卖积分进入积分中心显示），
=======
    3、提交表单之后返回状态码state,200为交易成功，201为挂卖积分超出购买申请（此时剩余售卖积分进入积分中心显示），
>>>>>>> refs/remotes/origin/master
    202为挂载积分价格过高，暂时不会在积分中心显示。205为积分不足，206为未知原因。
    
     -->
  </body>
</html>
