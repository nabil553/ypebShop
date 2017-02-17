<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<base href="<%=basePath%>">
<script src="frontJs/jquery.js"></script>
<link type="text/css" rel="stylesheet" href="frontCss/user/recharge.css">
<script src="frontJs/jquery.js"></script>
</head>

<body>
<form action="frontUser_PersonalCenter_recharge" method="post" onsubmit="return mysubmit();">
	<div class="headline">
		<p>请输入申请的微信昵称：</p>
		<p>请输入你需要充值的金额：</p>
	</div>
	<div class="number">
		<input class="number1" type="text" name="webChat"/>
		<input class="number2" type="text" name="num"
						onkeyup="value=value.replace(/[^\d]/g,'')" 
				onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,'')) />
	</div>
	<div class="moneyImg">
			<img src="upload/image/moneyWeChat.png" width="120px" height="120px"/>
			<span>扫描二维码支付</span>
	</div>
	<div class="clearfix"></div>
	<input class="apply_for" type="submit" value="确认申请">
</form>
<script>
		function mysubmit(){
			if ($("input[name='webChat']").val()=='') {
				alert("请输入微信昵称!");
				return false; 
			} else {
			}
			if ($("input[name='num']").val()=='') {
				alert("请输入充值金额!");
				return false; 
			} else {
				 
			}
		}
	</script>
</body>
</html>
