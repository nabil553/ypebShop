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
<title>无标题文档</title>
<link rel="stylesheet" href="frontCss/header_and_footer.css">
<link rel="stylesheet" href="frontCss/user/My_order.css">

<link href="frontJs/page/css/bootstrap.css" rel="stylesheet" type="text/css">
<script src="frontJs/page/js/jquery-2.1.4.min.js" type="text/javascript"></script>
<script src="frontJs/page/js/bootstrap.js" type="text/javascript"></script>
<script src="frontJs/page/js/jquery.twbsPagination.js" type="text/javascript"></script>
<script src="frontJs/page/js/zzsc.js" type="text/javascript"></script>

<style>
</style>
</head>

<body>
	<div class="list_box">
	
		<!--订单统计-->
		<div class="statistics_box">
			<div class="list_line"></div>
			<div class="statistics">
				<p><!-- 订单编号 -->待发货订单</p>
				<span>${orderToSend }</span>
			</div>
			<%-- <div class="statistics">
				<p><!-- 订单时间 -->发货中</p>
				<span>${orderSending }</span>
			</div> --%>
			<div class="statistics">
				<p><!-- 状态 -->完成订单</p>
				<span>${orderSended }</span>
			</div>
			<div class="clearfix"></div>
		</div>
		<!--订单-->
		<div class="center">
		
		<div class="list">
			<c:forEach items="${orderGoodsShowList}" var="list">
				<p class="list_p1">订单编号:${list.order.orderCode}</p>
				<p class="list_p2">订单时间:<fmt:formatDate value="${list.order.time}"
								pattern="yyyy-MM-dd" /></p>
				<p class="list_p3">共计:￥&nbsp;</p>
				<p class="list_p4">${list.order.totalprice}</p>
				<div class="clearfix"></div>
					<c:forEach items="${list.orderGoodsList}" var="goods">
						<span class="list_sp1"><img src="upload/image/goods/${goods.goodsImage}" width="72px" height="72px" /></span>
						<span class="list_sp2" style="color:#563636"><span>${goods.goodsName}</span></span>	
						<span class="list_sp3">数量:&nbsp;x&nbsp;</span>
						<span class="list_sp4" style="color:red;">${goods.num}</span>
						<span class="list_sp5">合计:&nbsp;￥&nbsp;</span>
						<span class="list_sp6" style="color:red;">${goods.totalPrice}</span>
					</c:forEach>
				<div class="clearfix"></div>
		    </c:forEach>
		</div>

		</div>

		<!--交易明细_翻页按钮-->
			<div class="item">
				<ul class="pageUl pagination-sm" >
					<!-- 
					<c:if test="${(page.currentPage-1)>0}">
						<li><a class="firstpage" href="frontUser_PersonalCenter_myOrder?pageNum=${page.currentPage-1}">&laquo;</a></li>
					</c:if>
					-->
					
						<li><a class="first" href="frontUser_PersonalCenter_myOrder?pageNum=${1}">首页</a></li>
						<li><c:if test="${(page.currentPage-1)>0}"><a class="prev" href="frontUser_PersonalCenter_myOrder?pageNum=${page.currentPage-1}">上一页</a></c:if></li>
					<c:forEach begin="1" end="${page.totalPage}" var="i">
							<li><a href="frontUser_PersonalCenter_myOrder?pageNum=${i}"
							   style="${(page.currentPage == i) ? 'background-color:#3d8bbf; color:#FFFFFF; width:30px;'  :''}">${i}</a></li>
					</c:forEach>
						<li><c:if test="${page.currentPage<page.totalPage}"><a class="next" href="frontUser_PersonalCenter_myOrder?pageNum=${page.currentPage+1}">下一页</a></c:if></li>
						<li><a class="last" href="frontUser_PersonalCenter_myOrder?pageNum=${page.totalPage}">末页</a></li>
					
					<!--  
					<c:if test="${page.currentPage<page.totalPage}">
						<li><a class="endpage" href="frontUser_PersonalCenter_myOrder?pageNum=${page.currentPage+1}">&raquo;</a></li>
					</c:if>
					-->
				</ul>
			<div class="clearfix"></div>
		</div>
		<!--  
		<div class="text-center">
			<ul id="pagination-demo-v1_0" class="pagination-sm"></ul>
		</div>
		-->
	</div>
<script>
	$(document).ready(function () {
	    $('#pagination-demo-v1_0').twbsPagination({
	        totalPages:${page.totalPage},
	        version: '1.0'
	    });
});
</script>
</body>
</html>
