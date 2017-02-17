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
<link type="text/css" rel="stylesheet" href="frontCss/user/integralBuy.css">
<style>
</style>
</head>

<body>
	
	<!--积分交易-->
	<div class="integral_deal_box">
		<div class="integral_deal">
			<div class="category">
				<h1>发行编号</h1>
				<h5>发行时间</h5>
				<h2>发行量</h2>
				<h3>剩余量</h3>
				<h4>单价</h4>
				<div class="clearfix"></div>
			</div>
			<div class="item">
				<h1>${pointsPublish.id+pointsPublish.totalNum }</h1>
				<h5>${pointsPublish.time }</h5>
				<h2>${pointsPublish.totalNum }</h2>
				<h3>${pointsPublish.residue }</h3>
				<h4>${price }积分/元</h4>
				<div class="clearfix"></div>
			</div>
	<form action="frontUser_PersonalCenter_buyPoints" onsubmit="return mysubmit();">
			<div class="purchase_quantity">
				<p>请输入你要购买的积分数量：</p>
				<input type="text" class="num" name="num" value="" onkeyup="this.value=this.value.replace(/[^\d]/g,'') " onafterpaste="this.value=this.value.replace(/[^\d]/g,'') "/>
				<div class="clearfix"></div>
			</div>
			<input type="hidden" name="pointsPublish.id" value="${pointsPublish.id }">
			<!-- <div class="pay_cash">
				<p>需支付现金：</p>
				<p class="pay_cash_number">20元</p>
				<div class="clearfix"></div>
			</div> -->
			<button class="buy"  type="submit" >购买</button>
	</form>
		</div>
	</div>
	
		<script>
		function mysubmit(){
			if ($("input[name='num']").val()=='') {
				alert("请输入购买数量!");
				return false; 
			} else {
			}
		}
	</script>
	<script type="text/javascript">
/* $(document).ready(function(){
  $(".buy").click(function(){
	var num = $("input[name='num']").val();
	$.post("frontUser_PersonalCenter_buyPoints",{"num":num},function(data,status){
     	//var v2 = $('#shopping_cart_text', window.parent.document);
		if(data.statusCode=='200'){
		alert("购买成功");
		//v2.html("购物车("+data.shopCarNum+")");//要刷新的div,(dates=shopNum+1)购物车中的数量
		}else{if(data.statusCode=='300')
			alert("超出购买限额!");
			else
			alert("账户余额不足!");
		}
    });
  });
}); */
</script>
</body>
</html>
