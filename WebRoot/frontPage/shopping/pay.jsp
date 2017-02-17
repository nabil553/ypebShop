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
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css"
	href="frontCss/header_and_footer.css">
<link rel="stylesheet" type="text/css" href="frontCss/shopping/pay.css">
<script src="bootstrap/js/jquery-2.1.4.min.js"></script>
<script src="frontJs/shopping/layer/layer.js"></script>
</head>

<body>
	<!---->
	<div class="nav_box">
		<div class="nav">
			<h1>
				<a href="frontShopping_Index_bodyData" target="index">首页</a> &gt;
			</h1>
			<h1>
				<a href="frontPage/shopping/shoppingCar.jsp" target="index">购物车</a>&gt;
			</h1>
			<h1>支付</h1>
			<div class="clearfix"></div>
		</div>
		<div class="clearfix"></div>
	</div>
	
	<form action="frontShopping_Goods_pay" onsubmit="return mysubmit();">
		<div class="site_box">
		<div class="myaddress">收货地址</div>
			<c:forEach items="${addressList }" var="addr" varStatus="status">
				<div class="site">
					<p><span>收&nbsp;件&nbsp;人:&nbsp;</span>${addr.name }</p>
					<p><span>收件地址:&nbsp;</span>${addr.address }</p>
					<p><span>联系方式:&nbsp;</span>${addr.telephone }</p>
					<c:choose>
					<c:when test="${status.first }">
					<input type="radio" checked="checked" name="order.address" value="${addr.id }">
					</c:when>
					<c:otherwise>
					<input type="radio"  name="order.address" value="${addr.id }">
					</c:otherwise>
					</c:choose>
				</div>
			</c:forEach>
		<!-- 	<input class="add_site" type="button" id="parentIframe" value="添加新地址">
		 -->	<div class="clearfix"></div>
		</div>


		<!--商品-->
		<div class="shoppingcart_box">
			<div>
				<h1>商品</h1>
				<div class="assist_box">
					<h2>属性</h2>
					<h2>单价</h2>
					<h2>数量</h2>
					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>

		<!--商品-->
		<div class="sc_commodity">
			<div class="boundary"></div>
			<img class="payImg" src="img/shopping_car/commodity.png">
			<h1>${goods.name }</h1>
			<div class="assist_box GoodsCheck">
			<input type="hidden" name="order.goodsId" value="${goods.id }">
				<h2>
					x<span class="num"><input type="hidden" readonly="true" name="order.num" value="${order.num }">${order.num }</span>
				</h2>
				<h2>
					￥<span class="price"><input type="hidden" readonly="true" name="order.unitPrice" value="${order.unitPrice }">${order.unitPrice }</span>
				</h2>
				<h2>${goods.attribute }</h2>
			</div>
			<div class="clearfix"></div>
		</div>

		<!--支付-->
		<div class="check_out_box">
			<div class="assist_box">
				<h1>积分余额</h1>
				<h1>共计￥${order.totalprice }</h1>
				<h1>需支付<input type="hidden" readonly="true" name="pointsPrice" value="${pointsPrice }"> ${pointsPrice }积分</h1>
				<input type="submit" value="去支付">
			</div>
			<div class="clearfix"></div>
		</div>
	</form>
	
	
	<script>
	function mysubmit(){
		var ret = window.confirm("确认要支付吗?");
		if (!ret) {
			return false;
			//do something 点确定
		}
	}
	</script>
	
	<!--添加地址弹出框-->
	<script>
		$("#parentIframe").on("click", function() {
			layer.open({
				type : 2,
				title : "添加地址",
				fix : false,
				shadeClose : true,
				maxmin : true,
				area : [ "700px", "600px" ],
				content : "frontPage/shopping/address.jsp",
			});
		});
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
