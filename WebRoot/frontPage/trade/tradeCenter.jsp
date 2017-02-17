<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
 	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link type="text/css" rel="stylesheet" href="frontCss/trade/tradeCenter.css">
  </head>
  
  <body onload="window.parent.document.getElementById('index').height=document.body.scrollHeight;">
    <!-- ************交易中心页面***********
    iframe布局。
   1. 左侧。
   		左侧为“交易中心”，“积分买卖”、“交易记录”三个栏目。
   		处理方法为frontTrade_TradeCenter_tradeCenter,front_TradeCenter_dealList,
   		frontTrade_TradeCenter_queryRecord(把userId带到后台).
   	2.右侧。
   		右侧为局部刷新。局部刷新页面分别为tradeGraph.jsp,tradeDeal,tradeRecord。
     -->
	     <div class="trade">
	    	<a href="frontTrade_TradeCenter_tradeCenter"  target="mytrade"><span class="tradeGraph">交易中心</span></a><br />
	        <a href="frontPage/trade/tradeDeal.jsp" target="mytrade"><span class="pointsBuy">积分购买</span></a><br />
	        <a href="frontPage/trade/tradeRecord.jsp" target="mytrade"><span class="tradeRecord">交易记录</span></a>
	     </div>
	    
	    <div style="width:80%; margin-left:10%;">
	    	<iframe name="mytrade" id="mytrade"  frameborder="1px" scrolling="no" marginheight="0" marginwidth="0" width="100%"  src="frontPage/trade/tradeGraph.jsp"></iframe>
	    </div>
  </body>
</html>
