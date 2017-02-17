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
<link type="text/css" rel="stylesheet"
	href="frontCss/user/personal_information.css">
<link rel="stylesheet" type="text/css"
	href="frontCss/header_and_footer.css">
<meta charset="utf-8">
<script src="frontJs/jquery.js"></script>
<title>无标题文档</title>
<style>
.hove .color {
	color: #ec1d23;
}
</style>
</head>

<body>
	<div class="personal_information_box">
		<!--左侧内容-->
		<div class="left_box">
			<!--面包屑路径-->
			<ul class="nav">
				<li>首页</li>
				<img src="img/personal_information/right_jiantou.png">
				<li>我的信息</li>
				<div class="clearfix"></div>
				<div class="nav_line"></div>
			</ul>
			<!--个人资料-->
			<div class="my_message">
				<img src="img/personal_information/touxiang.png">
				<div class="vip_name">
					<p>${user.name }</p>
					<p>
						<c:if test="${user.style==1 }">普通会员</c:if>
						<c:if test="${user.style==2 }">商城会员</c:if>
					</p>

				</div>
				<div class="clearfix"></div>
				<p>
					<c:if test="${user.style==1 }">银卡会员</c:if>
					<c:if test="${user.style==2 }">金卡会员</c:if>
					<c:if test="${user.style==3 }">铂金会员</c:if>
				</p>
				<p class="p1">
					<c:if test="${user.inforIsFull }">信息完整</c:if>
					<c:if test="${!user.inforIsFull }">请完善信息</c:if>
				</p>
				<div class="totality1">
					<div class="totality2"></div>
				</div>
				<div class="my_message_line"></div>
			</div>
			<!--会员中心-->
			<div class="vip_centrality">
				<img src="img/user/vip.png">
				<ul class="hove">
					<span class="click_ul">会员中心</span>
					<li><a href="frontUser_PersonalCenter_myInfo" target="mytrade"
						class="color">我的信息</a></li>
					<li><a href="frontPage/user/personalCenter/changePassword.jsp"
						target="mytrade">修改密码</a></li>
					<li><a href="frontUser_PersonalCenter_buyPointsPre"
						target="mytrade">购买积分</a></li>
					<li><a href="frontUser_PersonalCenter_myOrder"
						target="mytrade">我的订单</a></li>
					<li><a href="frontUser_PersonalCenter_myAddress"
						target="mytrade">收货地址</a></li>
					<li><a href="frontUser_PersonalCenter_myBankCard"
						target="mytrade">银行卡</a></li>
					<!-- 	<li><a href="frontUser_PersonalCenter_rechargePre"
						target="mytrade">充值申请</a></li> -->
					<li><a href="frontPage/user/personalCenter/recharge.jsp"
						target="mytrade">充值申请</a></li>
					<!-- <li><a href="frontUser_PersonalCenter_withdrawPre"
						target="mytrade">提现申请</a></li> -->
					<li><a href="frontPage/user/personalCenter/withdrawCash.jsp"
						target="mytrade">提现申请</a></li>
					<!-- <!-- <li><a href="frontUser_PersonalCenter_myRegister"
						target="mytrade">推荐会员</a></li> -->
					<li><a href="frontUser_PersonalCenter_myRecommend"
						target="mytrade">推荐记录</a></li>
					<!-- <li><a href="frontPage/user/personalCenter/bonusRecord.jsp"
						target="mytrade">奖金记录</a></li>
						
					-->
					<li><a href="frontUser_PersonalCenter_myMessage"
						target="mytrade">我的留言</a></li>
				</ul>
				<div class="clearfix"></div>
			</div>
		</div>
		<!--右侧内容-->
		<div class="right_box">
			<!--资产中心-->
			<div class="asset_Center">
				<div class="property_box">
					<a target="mytrade" href="frontUser_AccountBalance_myCash">
						<div class="property property_bor">
							<h2>账号余额</h2>
							<img src="img/personal_information/remainingSum.png">
							<p>${user.cash }元</p>
						</div>
					</a>
					<!--<a target="mytrade" href="jsp/Shopping_points.html"> -->
					<div class="property">
						<h2>购物积分</h2>
						<img src="img/personal_information/remainingSum2.png">
						<p>${user.usingPoints }</p>
					</div>
					<!-- </a> <a target="mytrade" href="jsp/Freezing_integral.html"> -->
					<div class="property">
						<h2>冻结积分</h2>
						<img src="img/personal_information/remainingSum3.png">
						<p>${user.icePoints }</p>
					</div>
					<!-- </a> -->
					<!-- 
					<div class="property">
						<h2>交易积分</h2>
						<img src="img/personal_information/remainingSum4.png">
						<p>${user.tradePoints }</p>
					</div>
				-->
					<div class="clearfix"></div>
				</div>
			</div>
			<div class="iframe">
				<iframe name=mytrade id=mytrade frameborder=no width=720
					scrolling=no marginheight=0 marginwidth=0 onload="this.height=100"
					src="frontUser_PersonalCenter_myInfo"></iframe>
			</div>
		</div>
		<div class="clearfix"></div>
	</div>
	<script>
		$(".hove a").click(function() {
			$(".hove a").removeClass("color");
			$(this).addClass("color");
		});
		$(".property").click(function() {
			$(".property").removeClass("property_bor");
			$(this).addClass("property_bor");
		});
	</script>
	<!-- iframe高度自适应问题 -->
	<script type="text/javascript">
		function reinitIframe() {
			var iframe = document.getElementById("mytrade");
			try {
				var bHeight = iframe.contentWindow.document.body.scrollHeight, dHeight = iframe.contentWindow.document.documentElement.scrollHeight, height = Math
						.max(bHeight, dHeight);
				iframe.height = height;
			} catch (ex) {
			}
		}
		window.setInterval("reinitIframe()", 100);
	</script>
	<!-- 解决iframe跳转页面时位置如何返回顶部问题 -->
	<script type="text/javascript">
		function parentGoTop() {
			parent.scrollTo(0, 0);
		}
		function addClick() {
			var aList = document.getElementsByTagName("a");
			for (var i = 0; i < aList.length; i++) {
				aList[i].onclick = function() {
					parentGoTop();
				}
			}
		}
		window.onload = function() {
			addClick();
		}
	</script>
</body>
</html>
