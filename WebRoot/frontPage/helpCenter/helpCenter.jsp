<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>帮助中心</title>
	<link rel="stylesheet" type="text/css" href="<%=path %>/frontCss/helpCenter/help_center.css">
		<link rel="stylesheet" type="text/css" href="<%=path %>/frontCss/helpCenter/universal.css">
	<script type="text/javascript" src="<%=path %>/bootstrap/js/jquery-2.1.4.min.js"></script>
  </head>

 <body>
	<div class="nav_box">
		<div class="nav">
			<h1><a href="" onClick="indexa">首页</a> &gt;</h1>
			<h1>帮助中心</h1>
			<div class="clearfix"></div>
		</div>
	</div>

	<div class="box">
		<div class="help_nav_box">
			<dvi class="help_nav">
				<ul>
					<li class="headline">新手上路</li>
					<li><a href="frontPage/helpCenter/signInManner.jsp" target="content" class="color">注册方式</a></li>
					<li><a href="frontPage/user/login/simpleRegister.jsp">注册新会员</a></li>
					<li class="headline">购物指南</li>
					<li><a href="#">购物流程</a></li>
					<li><a href="frontPage/helpCenter/logistics.jsp" target="content">物流配送</a></li>
					<li class="headline">关于我们</li>
					<li><a href="#">投诉与建议</a></li>
					<li><a href="frontPage/helpCenter/firmIndroduce.jsp" target="content">公司介绍</a></li>
					<li class="headline">服务与支持</li>
					<li>客服电话：0539-8888777</li>
					<li>客服QQ：123456789</li>
					<li class="bottom">服务时间：8:00-17:00</li>
				</ul>
			</dvi>
		</div>
		<div class="content_box">
			<iframe name="content" id="index" frameborder="no" scrolling="no" width="906px" marginheight="0" marginwidth="0" onload="this.height=1000" src="frontPage/helpCenter/signInManner.jsp"></iframe>
		</div>
	</div>
	<script>
	function indexa(){
		location.href="frontShopping_Index_indexData";
	}
	</script>
	<!-- iframe高度自适应问题 -->
	<script type="text/javascript">
		function reinitIframe(){
		    var iframe = document.getElementById("index");
		    try{
		        var bHeight = iframe.contentWindow.document.body.scrollHeight,
		            dHeight = iframe.contentWindow.document.documentElement.scrollHeight,
		            height = Math.max(bHeight, dHeight);
		        iframe.height =  height;
		    }catch (ex){}
		}
		window.setInterval("reinitIframe()", 200);
		
		$(".help_nav ul li a").click(
			function(){
				$(".help_nav ul li a").removeClass("color")
				$(this).addClass("color")
			}
		)
	</script>
 </body>
</html>
