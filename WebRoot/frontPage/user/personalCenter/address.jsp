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
<link type="text/css" rel="stylesheet"
	href="frontCss/header_and_footer.css">
<link type="text/css" rel="stylesheet" href="frontCss/user/address.css">
<style>
</style>
</head>

<body>
	<div class="ra_box">
		<!--我的地址-->
		<div class="my_ra">
			<c:forEach items="${addressList }" var="list">
				<div class="ra">
					<p><span>收&nbsp;件&nbsp;人:&nbsp;</span>${list.name }（收）</p>
					<p><span>联系方式:&nbsp;</span>${list.telephone }</p>
					<p><span>收货地址:&nbsp;</span>${list.address }</p>
					<div class="ra_img">
						<a
							href="frontUser_PersonalCenter_deleteAddress?addressId=${list.id }">
							<img src="img/personal_information/shanchu.png">
						</a>
					</div>
				</div>
				<div class="clearfix"></div>
			</c:forEach>

			<div class="clearfix"></div>
			<div class="ra_add_btn">添加新地址</div>
			<div class="clearfix"></div>
		</div>
		<!--编辑地址-->
		<div class="chenge_ra_box">
			<div class="change_ra">
				<p>收件人</p>
				<input type="text">
				<div class="clearfix"></div>
			</div>
			<div class="change_ra">
				<p>手机号码</p>
				<input type="text">
				<div class="clearfix"></div>
			</div>
			<!--收件地址-->
			<textarea class="input-1"></textarea>
			<input type="button" class="input-2" value="确认添加">
		</div>
		<!--添加地址-->
		<div class="add_ra_box">
			<form action="frontUser_PersonalCenter_addAddress" method="post" onsubmit="return mysubmit();">
				<div class="change_ra">
					<p>收件人:</p>
					<input class="updatePeop" maxlength="8" type="text" name="address.name" placeholder="请输入收件人姓名" >
					<div class="clearfix"></div>
				</div>
				<div class="change_ra">
					<p>手机号码:</p>
					<input type="text" name="address.telephone" maxlength="11" placeholder="请输入你的手机号"
					onkeyup="this.value=this.value.replace(/[^\d]/g,'') " onafterpaste="this.value=this.value.replace(/[^\d]/g,'') " />
					<div class="clearfix"></div>
				</div>
				<!--收件地址-->
				<div class="fontaddres">地&nbsp;&nbsp;址:</div>
				<textarea class="input-1" maxlength="45" name="address.address" placeholder="请输入详细地址, 如:街道,小区,楼层,门牌号等"></textarea>
				<input type="submit" class="input-2" value="确认更改" />
			</form>
		</div>

	</div>
	<script>
		function mysubmit(){
			if ($("input[name='address.name']").val()=='') {
				alert("请输入收件人!");
				return false; 
			} else {
			}
			var phone = $("input[name='address.telephone']").val();
			if (phone && /^1[3|4|5|7|8]\d{9}$/.test(phone)) {
				//alert($("input[name='phone']").val());
			} else {
				alert("手机号码格式不正确!");
				return false; 
			}
			if ($("input[name='address.address']").val()=='') {
				alert("请输入收件地址!");
				return false; 
			} else {
				 
			}
		}
	</script>
	<script>
		$(".my_ra").siblings().hide();
		//点击事件
		$(".ra_add_btn").click(function() {
			$(".add_ra_box").show().siblings().hide();
		});
		$(".bianji1").click(function() {
			$(".chenge_ra_box").show().siblings().hide();
		});
	</script>
</body>
</html>
