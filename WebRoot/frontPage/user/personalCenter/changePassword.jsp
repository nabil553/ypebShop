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
<meta charset="utf-8">
<link type="text/css" rel="stylesheet" href="frontCss/user/changePassw.css">
<script type="text/javascript" src="bootstrap/js/jquery-2.1.4.min.js"></script>
</head>

<body>
<div>
	<form action="frontUser_PersonalCenter_modifyPassword">
		<div class="change_sign_up">
			<p class="headline">修改登录密码</p>
			<div class="box">
				<p class="old_password">原登录密码：</p>
				<input type="password" name="user.password">
				<p>${erro }</p>
				<div class="clearfix"></div>
			</div>
			<div class="box">
				<p>请输入新密码：</p>
				<input type="password" name="passwordNew" id="pwdo"/>
				<div class="clearfix"></div>
			</div>
			<div class="box">
				<p>请确认新密码：</p>
				<input type="password" name="pwdt" id="pwdt"/>
				<div class="clearfix" ></div>
			</div>
			<input class="confirm" type="submit" value="确定修改" onClick="pwd();" />
		</div>
		<div class="clearfix"></div>
	</form>
	</div>
	
    <!-- 验证手机号和密码格式是否正确 -->
  <script>
function pwd(){
   	if($("input[id='pwdo']").val()==$("input[name='pwdt']").val()){
		//alert("yes");
    }else{
		alert("重复输入的密码不正确!");		
  }
}
   </script>
</body>
</html>
