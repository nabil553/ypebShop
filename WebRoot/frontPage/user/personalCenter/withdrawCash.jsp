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
<link type="text/css" rel="stylesheet" href="frontCss/user/withdrawCash.css">
<style>
</style>
</head>

<body>
<form action="frontUser_PersonalCenter_withdraw" method="post" onsubmit="return mysubmit();">
	<div class="headline">
		<p>请输入你需要提现的金额：</p>
	</div>
	<div class="number">
		<input class="number1"  type="text" name="num"
		onkeyup="value=value.replace(/[^\d]/g,'')" 
		onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,'')) />
	</div>
	<div class="clearfix"></div>
	<input class="apply_for" type="submit" value="确认申请">
</form>
<script>
		function mysubmit(){
			if ($("input[name='num']").val()=='') {
				alert("请输入要提现金额!");
				return false; 
			} else {
				 
			}
		}
	</script>
</body>
</html>
