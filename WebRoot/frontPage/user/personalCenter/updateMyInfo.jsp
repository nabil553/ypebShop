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
<link rel="stylesheet" href="frontCss/user/updateMyInfo.css">
<script src="bootstrap/js/jquery-2.1.4.min.js"></script>
<!--引用城市插件-->
<link href="frontJs/user/areaselect.css" type="text/css"
	rel="stylesheet" />
<script type="text/javascript" src="frontJs/user/data.js"></script>
<script type="text/javascript" src="frontJs/user/areaselect.js"></script>
</head>

<body>
	<div class="top_nav">编辑修改个人信息</div>
	<form action="frontUser_PersonalCenter_addMyInfo" method="post">
		<div class="notUpdate">会员编号:${user.id }</div>
		<span class="userName">会员名:</span> <input type="text"
			class="updateName" value="${user.name }" name="user.name" /> <input
			type="hidden" name="user.id" value="${user.id }">
		<div class="IDCard">
			身份证号:
			<c:if test="${user.inforIsFull==true }">已绑定</c:if>
			<c:if test="${user.inforIsFull==false }">
				<input type="text" class="updateName" name="user.idcard" />
			</c:if>
		</div>
		<div class="updateaddr">地&nbsp;&nbsp;址:</div>
		<!--选择省市县-->
		<div class="updateMycity">
			<input id="pr2" type="text" placeholder="省份" name="user.province" />
			<input id="ci2" type="text" placeholder="城市" name="user.city" /> <input
				id="co2" type="text" placeholder="县级" name="user.country" />
		</div>
		<!--选择省市县 end-->
		<button type="submit" class="yesUpdate" >确认提交</button>
	</form>
	</div>
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
