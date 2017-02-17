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
<link type="text/css" rel="stylesheet" href="frontCss/user/bankCard.css">
<style>
</style>
</head>

<body>
	<div class="bankcardTop">
		<c:forEach items="${bankCardList }" var="bankCard">
			<div class="bankcard">
				<p>${bankCard.cardNum}</p>
				<a href="frontUser_PersonalCenter_deleteBankCard?bankCardId=${bankCard.id }">
					<img src="img/personal_information/shanchu.png">
				</a>
			</div>
		</c:forEach>
			<input class="add_bankcard" type="button" value="添加银行卡" />
	</div>
	
		<div class="add_bankcards">
			<form action="frontUser_PersonalCenter_addBankCard" method="post" onsubmit="return mysubmit();">
			
			<div class="change_sign_up">
			<div class="box">
				<p >请输入开户人：</p>
				<input type="text" name="bankCard.name" maxlength="8" />
				<div class="clearfix"></div>
			</div>
			<div class="box">
				<p>请输入开户银行：</p>
				<input type="text" name="bankCard.bankName"  maxlength="15"/>
				<div class="clearfix"></div>
			</div>
			<div class="box">
				<p>请输入银行卡号：</p>
				<input type="text" name="bankCard.cardNum" maxlength="30"  
				onkeyup="value=value.replace(/[^\d]/g,'')" 
				onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,'')) />
				<div class="clearfix" ></div>
			</div>
			<input class="confirm" type="submit" value="确定添加" />
		</div>
			</form>
		</div>
	<script>
		function mysubmit(){
			if ($("input[name='bankCard.name']").val()=='') {
				alert("请输入开户人!");
				return false; 
			} else {
			}
			if ($("input[name='bankCard.bankName']").val()=='') {
				alert("请输入开户银行!");
				return false; 
			} else {
			}
			if ($("input[name='bankCard.cardNum']").val()=='') {
				alert("请输入银行卡号!");
				return false; 
			} else {
				 
			}
		}
	</script>
	<script>
		$(".bankcardTop").siblings().hide();
		//点击事件
		$(".add_bankcard").click(function() {
			$(".add_bankcards").show().siblings().hide();
		});
	</script>
</body>
</html>
