<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link rel="stylesheet" type="text/css" href="frontCss/shopping/query.css">
  </head>
  
  <body>
<div class="query_all">
	<div class="path">
        <a href="frontShopping_Index_bodyData" target="index"><span>首页&gt;</span></a>
        <a href="frontShopping_IndexOther_queryByTwoMenu" target="index"><span>${category1Name}&gt;</span></a>
        <span>${category.name}</span>
        <div class="clearfix"></div>
        <div class="path_line"></div>
    </div>

<!--筛选-->
    <div class="filter">

        <div class="filter_line"></div>
    </div>
    <div class="relative_a_detail">
        <c:forEach items="${adList }" var="list">
				<img src="upload/image/advertisement/${list.url }" width="220px" height="300px">
		</c:forEach>
    </div>

<!-- 搜索结果 -->
<!--floor-->
<div class="floor">
	<c:forEach items="${goodsList}" var="goods">
		<div class="foot">
			<div class="img_box">
				<a href="frontShopping_Goods_queryGoods?id=${goods.id }" target="index">
					<img class="foot_img" src="upload/image/goods/${goods.imageUrl1 }">
				</a>
			</div>
			<h1 class="name">${goods.name}</h1>
			<div class="price">
					<c:if test="${user.style==2}" ><h1 class="vip_price">商城会员价:${goods.discountPrice}<h2>普通会员价:${goods.price}</h2></h1></c:if>
					<c:if test="${user.style==1 || user==null}" ><h2>普通会员价:${goods.price}</h2></c:if>
			</div>
			<input type="hidden" value="${goods.id }"> <img
							class="foot_shopping_cart"
							src="image/index/foot_shopping_cart.png"
							shopID="${goods.id}">
		</div>
	</c:forEach>

		<div class="item">
		<ul class="pageUl">
			<c:if test="${(page.currentPage-1)>0}">
				<li><a class="firstpage" href="frontShopping_IndexOther_queryLike?pageNum=${page.currentPage-1}">&laquo;</a></li>
			</c:if>
			<c:forEach begin="1" end="${page.totalPage}" var="i">
					<li><a href="frontShopping_IndexOther_queryLike?pageNum=${i}"
					   style="${(page.currentPage == i) ? 'background-color:lightgrey; width:10px;'  :''}"><span>${i}</span></a></li>
			</c:forEach>
			<c:if test="${page.currentPage<page.totalPage}">
				<li><a class="endpage" href="frontShopping_IndexOther_queryLike?pageNum=${page.currentPage+1}">&raquo;</a></li>
			</c:if>
		</ul>
	</div>	
	<div class="clearfix"></div>
</div>
</div>
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
