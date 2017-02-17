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
<link type="text/css" rel="stylesheet"
	href="frontCss/header_and_footer.css">
<link type="text/css" rel="stylesheet" href="frontCss/user/myInfo.css">
</head>

<body>
	<div class="my_mes_box">
		<span>我的信息</span>
		<div class="clearfix"></div>
		<ul>
			<li>会员编号：</li>
			<li>会员名:</li>		
			<li>绑定手机：</li>
			<li>身份证：</li>
			<li>银行卡：</li>
			<li>省：</li>
			<li>市：</li>
			<li>县（区）：</li>
		</ul>
		<ol style="margin:0;">
			<li>${user.id }</li>
			<li>${user.name }</li>			
			<li>${user.telephone }</li>
			<li><c:choose>
					<c:when test="${user.inforIsFull }">已绑定</c:when>
					<c:otherwise>未绑定</c:otherwise>
				</c:choose></li>
			<li><c:choose>
					<c:when test="${user.inforIsFull }">已绑定</c:when>
					<c:otherwise>未绑定</c:otherwise>
				</c:choose></li>
			<li>${user.province}</li>
			<li>${user.city}</li>
			<li>${user.country}</li>
		</ol>
		<div class="my">
			<img src="img/personal_information/touxiang2.png">
			<div class="compile"><a href="frontUser_PersonalCenter_addMyInfoPre" target="mytrade">编辑</a></div>
		</div>
		<div class="clearfix"></div>
	</div>
<div class="addHei"></div>
		<!-- 解决iframe跳转页面时位置如何返回顶部问题 -->
<script type="text/javascript">
	function parentGoTop(){
	parent.scrollTo(0,0);
	}
	function addClick(){
	var aList=document.getElementsByTagName("a");
	for(var i=0;i<aList.length;i++){
	    aList[i].onclick=function(){parentGoTop();}
	    }
	}
	window.onload=function(){addClick();}
</script>
</body>
</html>
