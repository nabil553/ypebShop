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

<link rel="stylesheet" type="text/css" href="frontCss/index.css">

<head>
<base href="<%=basePath%>">
<link rel="stylesheet" type="text/css"
	href="<%=path%>/frontCss/index.css">
<link rel="stylesheet" type="text/css"
	href="<%=path%>/frontCss/header.css">
<link rel="stylesheet" type="text/css"
	href="<%=path%>/frontCss/bottom.css">
<script type="text/javascript"
	src="bootstrap/js/jquery-2.1.4.min.js"></script>
</head>
<body>
	<div class="">
		<div class="header_bottom">
			<div class="pros">
				<ul class="classification_box prosul" id="proinfo"
					style="margin-top:0px;">
					<c:forEach var="first" items="${categoryByLevel }">
						<li class="liback"><a class="libacka"
							href="frontShopping_IndexOther_queryByOneMenu?categoryID=${first.id }">${first.name }</a>
							<div class="prosmore hide">
								<c:forEach var="second" items="${first.secCategoryList}">
									<span><a
										href="frontShopping_IndexOther_queryByTwoMenu?categoryID=${second.id }"
										class="libackb">${second.name }</a></span>
								</c:forEach>
							</div></li>
					</c:forEach>
				</ul>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<div class="banner_box">
		<div class="banner">
			<c:forEach items="${rollList }" var="roll">
				<a href="frontShopping_Goods_queryGoods?id=${roll.goodsId }"><img
					class="banner1" src="upload/image/roll/${roll.url }"></a>
			</c:forEach>
			<div class="clearfix"></div>
		</div>
		<div class="arrow">
			<span class="arrow_left"><img
				src="<%=path%>/img/common/header/left.png"></span> <span
				class="arrow_right"><img
				src="<%=path%>/img/common/header/right.png"></span>
		</div>
		<div class="ctrl_span">
			<span class="current"></span> <span></span> <span></span> <span></span>
		</div>
	</div>
	<div class="AD_box">
		<c:forEach items="${advertList }" var="ad">
			<img src="upload/image/advertisement/${ad.url }" width="435px"
				height="200px">
		</c:forEach>
		<div class="notice">
			<div>
				<h1 class="headline">商城公告</h1>
				<h1 class="more">
					<a href="frontShopping_IndexOther_queryListAnnoun">更多></a>
				</h1>
				<div class="clearfix"></div>
			</div>
			<c:forEach items="${announList }" var="announcement">
				<h3>
					<a
						href="frontShopping_IndexOther_queryAnnoun?id=${announcement.id }">${announcement.title }</a>
				</h3>
			</c:forEach>

		</div>
		<div class="clearfix"></div>
	</div>

	<!--floor-->
	<c:forEach items="${goodsList}" var="floor" varStatus="status">
		<div class="floor">
			<div>
				<img class="floor_number" src="image/floor/${status.index+1 }f.png">
				<h1 class="floor_name">${floor.floorName }</h1>
				<div class="clearfix"></div>
			</div>
			<div class="boundary"></div>
			<img class="floor_ad" src="upload/image/category/${floor.url }">
			<c:forEach items="${floor.goodsList}" var="floorGoods">
				<div class="foot">
					<div class="img_box">
						<a href="frontShopping_Goods_queryGoods?id=${floorGoods.id }"
							target="index"><img class="foot_img"
							src="upload/image/goods/${floorGoods.imageUrl1 }"> </a>
					</div>
					<h1 class="name">${floorGoods.name}</h1>
					<div class="price">
						<h1 class="vip_price">
							<c:if test="${user.style==2}" >商城会员价:${floorGoods.discountPrice}<h2>普通会员价${floorGoods.price}</h2></c:if>
							<c:if test="${user.style==1 || user==null}" >普通会员价:${floorGoods.price}	</c:if>
						</h1>
					</div>
					<c:if test="${user!=null }">
						<input type="hidden" value="${floorGoods.id }"> <img
							class="foot_shopping_cart"
							src="image/index/foot_shopping_cart.png"
							shopID="${floorGoods.id }" />
					</c:if>
					<c:if test="${user==null }">
						<input type="hidden" value="${floorGoods.id }"> <img
							class="foot_shopping_cart"
							src="image/index/foot_shopping_cart.png"
							shopID="${floorGoods.id }" onClick="nouser();" />
					</c:if>
				</div>
			</c:forEach>
			<div class="clearfix"></div>
		</div>
	</c:forEach>
	<script>
		function nouser(){
			alert("请先登录");
		}
	</script>
	<script type="text/javascript">
		$(document).ready(function() {
			$(".foot_shopping_cart").click(function() {
				var shopID = $(this).attr("shopID");
				
				$.post("frontShopping_Goods_addShoppingCar", {
					"shopID" : shopID
				}, function(data, status) {
					var v2 = $('#shopping_cart_text', window.parent.document);
					if (data.statusCode == '200') {
						alert("添加成功");
						v2.html("购物车(" + data.shopCarNum + ")");//要刷新的div,(dates=shopNum+1)购物车中的数量
					} else {
						alert("请先登录");
					}
				});
				
			});
		});
	</script>
	
	<script type="text/javascript" language="javascript">
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
		$(".banner img").hide()
		$(".banner img").eq(0).show(100)
		var n = 0
		function toFade() {
			if (n < 3) {
				n = n + 1
			} else {
				n = 0
			}
			$(".banner img").fadeOut(700)
			$(".banner img").eq(n).fadeIn(700)

			$(".ctrl_span span").removeClass("current")
			$(".ctrl_span span").eq(n).addClass("current")
		}
		var t1 = setInterval(toFade, 3000)
		$(".arrow_left").click(function() {
			if (n > 0) {
				n = n - 1
			} else {
				n = 3
			}
			$(".banner img").fadeOut(700)
			$(".banner img").eq(n).fadeIn(700)
			$(".ctrl_span span").removeClass("current")
			$(".ctrl_span span").eq(n).addClass("current")
		})
		$(".arrow_right").click(function() {
			if (n < 3) {
				n = n + 1
			} else {
				n = 0
			}
			$(".banner img").fadeOut(700)
			$(".banner img").eq(n).fadeIn(700)
			$(".ctrl_span span").removeClass("current")
			$(".ctrl_span span").eq(n).addClass("current")
		})
		$(".ctrl_span span").click(function() {
			n = $(this).index()
			$(".banner img").fadeOut(700)
			$(".banner img").eq(n).fadeIn(700)
			$(".ctrl_span span").removeClass("current")
			$(".ctrl_span span").eq(n).addClass("current")
		})

		$(".banner_box").mouseenter(function() {
			clearInterval(t1)
		}).mouseleave(function() {
			t1 = setInterval(toFade, 3000)
		})
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
