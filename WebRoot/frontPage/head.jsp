
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<div class="header">
	<div class="header_top">
		<h1 class="welcome">欢迎进入沂品电子商务积分购物商城!</h1>
		<c:choose>
			<c:when test="${userName!=null}">
				<!-- 登陆用户 -->
				<h1>
					<a class="sign_up" href="javascript:void(0);">用户${userName }</a>
				</h1>
				<h1>
					<a class="sign_in" href="frontPage/user/login/simpleRegister.jsp">免费注册</a>
				</h1>
				<h1>
					<a class="info quit" href="javascript:void(0);" target="index">&nbsp;&nbsp;退出</a>
				</h1>
				<h1>
					<c:if test="${user!=null }">
						<a class="info" href="frontUser_PersonalCenter_infoCenter"
							target="index">我的信息</a>
					</c:if>
				</h1>
			</c:when>
			<c:otherwise>
				<!-- 未登陆用户 -->
				<h1>
					<a class="sign_up" href="frontUser_Login_goLogin">请登录</a>
				</h1>
				<h1>
					<a class="sign_in" href="frontUser_Login_goRegister">免费注册</a>
				</h1>
				<h1>
					<a class="info noMyinfo" href="javascript:noLogin();" id="noMyinfo"
						onClick="noLogin();">我的信息</a>
				</h1>
			</c:otherwise>
		</c:choose>
		<div class="clearfix"></div>
	</div>
	<div class="top_middle"></div>
	<div class="header_middle">
		<img class="logo" src="image/index/logo.png"> <input
			class="search_box" type="text" value="" name="querylike" /> <input
			class="search_button" type="submit" id="keydown" value="搜索"
			onClick="queryLike();" />
		<c:if test="${user!=null }">
			<div class="shopping_cart_box">
				<img class="shopping_cart" src="image/index/shopping_cart.png">
				<a href="frontShopping_Goods_listCar" target="index"><h1
						class="shopping_cart_text" id="shopping_cart_text"
						num="${shoppingCarNum }">购物车(${shoppingCarNum })&nbsp;</h1></a>
				<div class="classfix"></div>
			</div>
		</c:if>
		<c:if test="${user==null }">
			<div class="shopping_cart_box">
				<img class="shopping_cart" src="image/index/shopping_cart.png">
				<a href=""><h1
						class="shopping_cart_text" id="shopping_cart_text"
						num="${shoppingCarNum }" onClick="noLogin();">购物车(${shoppingCarNum })&nbsp;</h1></a>
				<div class="classfix"></div>
			</div>
		</c:if>
		<div class="clearfix"></div>
	</div>
	<div class="header_bottom_bg">
		<div class="header_bottom">
			<div class="pros">
				<h2 class="classification">全部商品分类</h2>
				<ul class="classification_box prosul" id="proinfo">
					<c:forEach var="first" items="${categoryByLevel }">
						<li class="liback"><a class="libacka"
							href="frontShopping_IndexOther_queryByOneMenu?categoryID=${first.id }"
							target="index">${first.name }</a>
							<div class="prosmore hide">
								<c:forEach var="second" items="${first.secCategoryList  }">
									<span><a class="libackb"
										href="frontShopping_IndexOther_queryByTwoMenu?categoryID=${second.id }"
										target="index">${second.name }</a></span>
								</c:forEach>
							</div></li>
					</c:forEach>
				</ul>
			</div>
			<h1>
				<a class="home" href="frontShopping_Index_bodyData" target="index">首页</a>
			</h1>
			<!--  <h1>
				<a class="deal" href="frontPage/trade/tradeCenter.jsp"
					target="index">交易中心</a>
			</h1>
			-->
			<div class="clearfix"></div>
		</div>
	</div>
</div>

<script>
	$(".noMyinfo").click(function() {
			alert("请先登录!");
			return false;
		});
	$(function() {
		$(document).keydown(function(event) {
			if (event.keyCode == 13) {
				$("#keydown").click();
			}
		});
	});
	function queryLike() {
		var val = $("input[name='querylike']").val();
		$('iframe').attr('src',
				'frontShopping_IndexOther_queryLike?name=' + val);
	}
</script>

<script type="text/javascript">
	(function() {
		var $subblock = $(".subpage"), $head = $subblock.find('h2'), $ul = $("#proinfo"), $lis = $ul
				.find("li"), inter = false;
		$lis.hover(function() {
			if (!$(this).hasClass('nochild')) {
				$(this).addClass("prosahover");
				$(this).find(".prosmore").removeClass('hide');
			}
		}, function() {
			if (!$(this).hasClass('nochild')) {
				if ($(this).hasClass("prosahover")) {

					$(this).removeClass("prosahover");
				}
				$(this).find(".prosmore").addClass('hide');
			}
		});
	})();
</script>

<script>
	$(".classification_box").hide();
	$(".classification").mouseover(function() {
		$(".classification_box").show();
	}).mouseout(function() {
		$(".classification_box").hide();
	});
	$(".classification_box").mouseover(function() {
		$(".classification_box").show();
	}).mouseout(function() {
		$(".classification_box").hide();
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
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".quit").click(function() {
			$.post("frontUser_Login_quit", {
			}, function(data, status) {
				if (data.status = "200")
					location.href = "frontShopping_Index_indexData"
				else {
					aler("退出失败");
					$.post("frontShopping_Index_indexData", {
					}, function(data, status) {
					});
				}
			});
		});
	});
</script>

</html>
