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
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>用户登录</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" href="frontCss/header_and_footer.css"
	type="text/css">
<link rel="stylesheet" href="frontCss/user/login.css" type="text/css">
<script src="bootstrap/js/jquery-2.1.4.min.js"></script>
<!--引用城市插件-->
<link href="frontJs/user/areaselect.css" type="text/css"
	rel="stylesheet" />
<script type="text/javascript" src="frontJs/user/data.js"></script>
<script type="text/javascript" src="frontJs/user/areaselect.js"></script>
</head>

<body>
	<!-- 
     		************用户登录页面***************
    1.登录使用手机号和登录密码登录，信息存在user对象中
    2.警告信息alerts，使用boostrap实现。包括手机号错误（状态码state=201），密码错误（202）
    验证码错误（203），未知原因（205）。
    3.验证码。使用front_Login_verification方法处理,验证码存在SEESION里面。
     -->

	<div class="logo1">
		<img src="img/user/logo.png" onClick="indexlogo();" />
	</div>
	<div class="activity">
		<img src="img/user/banner_bg.png" class="bg_img">
	</div>
		
		<!--登陆-->
		<div class="bg_box">
		<div class="login_box">
			<h1>会员登陆</h1>
			<h2><a href="frontUser_Login_goRegister">免费注册&gt;</a></h2>
			<br />
			<br />
			<div class="clearfix"></div>
			<form action="frontUser_Login_login" method="post">
				<div class="login1">
					<span>手机号</span> <input type="text"
						style="background-image: url(img/user/yonghu.png)" class="input5"
						name="user.telephone" maxlength="11"
						onkeyup="this.value=this.value.replace(/[^\d]/g,'') "
						onafterpaste="this.value=this.value.replace(/[^\d]/g,'') "
						name="f_order" />
					<div class="clearfix"></div>
				</div>
				<div class="login1">
					<span>密 码</span> <input type="password" class="input6"
						name="user.password">
					<div class="clearfix"></div>
				</div>
				<c:if test="${message!=null && message!='' }">
					<div class="login1">
						<span>${message }</span>
						<div class="clearfix"></div>
				</c:if>
				<%-- <div class="login1">
					<span>验证码</span> <input type="text" style="width: 154px"
						class="input7"> <img src="img/user/yzm.png"
						class="login_img">
					<div class="clearfix"></div>
				</div>
				<p class="wjmm">
					忘记密码</span> --%>
				<div class="clearfix"></div>
				<div class="login_btn">
					<button type="submit">登&nbsp;录</button>
				</div>
			</form>
		</div>
	</div>
	<script>
		function indexlogo(){
			location.href="frontShopping_Index_indexData";
		}
	</script>
		<!-- 验证手机号格式是否正确 -->
		<script>
			function phone() {
				var phone = $("input[user.telephone]").val();
				if (phone && /^1[3|4|5|7|8]\d{9}$/.test(phone)) {
					//alert($("input[name='phone']").val());
				} else {
					alert("手机号码格式不正确!");
				}
			}
		</script>
</body>
</html>