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

<title>用户注册</title>

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
	**********用户简单注册界面**************
	注册流程：
	1、注册信息。输入手机号作为登录名，用户名只用作别称，区域包括：省市县，使用下拉框插件实现
	用户登录密码，密码确认，！！要检查密码和手机号是否符合规范(密码6-11位，包含数字和字符)!!。
	注册信息全部存在user对象里面提交给front_Login_simpleRegist方法处理。
	2、验证码。使用front_Login_verification方法处理,验证码存在SEESION里面。
	3、推荐人ID。推荐人ID在页面获取之后赋值给user.referrer，如果没有要给其赋值"0"。
	4、返回信息。提交之后如果手机号已经被注册要有提示行。
	
	  -->


	<div class="logo1">
		<img src="img/user/logo.png" onClick="indexlogo();" />
	</div>
	<div class="activity">
		<img src="img/user/banner_bg.png" class="bg_img">
	</div>
		
		<!--zhuce-->
		<div class="bg_box">
		<div class="regsiter_box">
			<h1>会员注册</h1>
			<h2><a href="frontUser_Login_goLogin">登录&gt;</a></h2>
			<br />
			<br />
			<div class="clearfix"></div>
			<form action="frontUser_Login_register" method="post" onsubmit="return mysubmit();">
				
				<div class="name">
				${erro }
					<span class="username">用户名</span> <input type="text" value=""
						placeholder="请输入用户名" class="input0" name="user.name"/>
				</div>
				<div class="regsiter">
					<span>手机号</span> <input type="text"  name="phone"
						placeholder="请输入你的手机号" class="input1" maxlength="11"
						onkeyup="this.value=this.value.replace(/[^\d]/g,'') "
						onafterpaste="this.value=this.value.replace(/[^\d]/g,'') "
						name="user.telephone" />
					<div class="clearfix"></div>
				</div>
				<div class="regsiter">
					<span>设置密码</span> <input type="password" minlength="3" maxlength="16"  value="" name="user.password"
						placeholder="请输入3~16位新密码" class="input2" name="user.password"/>
					<div class="clearfix"></div>
				</div>
				<div class="regsiter">
					<span>确认密码</span> <input type="password" value="" name="pwdt"
						placeholder="请重新输入3~16位新密码" class="input3" />
					<div class="clearfix"></div>
				</div>
				<br />
				<div class="cityaddr">
					<span>地址</span>
				</div>
				<!--选择省市县-->
				<div class="mycity">
					<input id="pr2" type="text" placeholder="省份" name="user.province"/> <input id="ci2"
						type="text" placeholder="城市" name="user.city"/> <input id="co2" type="text"
						placeholder="县级" name="user.country"/>
				</div>
				<!--选择省市县 end-->
				<br />
				<div class="login_btn">
					<button type="submit">注&nbsp;&nbsp;册</button>
				</div>
			</form>
		</div>
		</div>
	</div>
	<script>
		function indexlogo(){
			location.href="frontShopping_Index_indexData";
		}
	</script>
	<!-- 验证手机号和密码格式是否正确 -->
	<script>
		function mysubmit() {
			var phone = $("input[name='phone']").val();
			if (phone && /^1[3|4|5|7|8]\d{9}$/.test(phone)) {
				//alert($("input[name='phone']").val());
			} else {
				alert("手机号码格式不正确!");
				return false; 
			}
			if ($("input[name='user.password']").val() == $("input[name='pwdt']").val()) {
				//alert("yes");
			} else {
				alert("重复输入的密码不正确!");
				return false;  
			}
		}
	</script>
	<!-- 注册选择城市 -->
	<script type="text/javascript">
		new locationCard({
			ids : [ 'pr1', 'ci1', 'co1' ]
		}).init();
		new locationCard({
			ids : [ 'pr2', 'ci2', 'co2' ]
		}).init();
	</script>

</body>
</html>
