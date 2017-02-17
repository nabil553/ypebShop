<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<head>
<base href="<%=basePath%>">

<title>售卖</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<form id="pagerForm" method="post" action="backTrade_PointsSale_comprehensiveQuery">
	<input type="hidden" name="pageNum" value="1" /> <input
		type="hidden" name="numPerPage" value="50" /> <input type="hidden"
		name="orderField" value="${queryCondition.orderField}" /> <input
		type="hidden" name="orderDirection"
		value="${queryCondition.orderDirection}" />
</form>

<div class="pageHeader">

	<form rel="pagerForm" onsubmit="return navTabSearch(this);"
		action="backTrade_PointsSale_comprehensiveQuery" method="post">
		<div class="searchBar">
			<ul class="searchContent">
				<li><label>挂卖人ID：</label> <input type="text" name="pointsSale.saleId"
					value="${pointsSale.saleId }" /></li>

				<li><select class="combox" name="pointsSale.state">
						<option value="${state }">订单状态(${pointsSale.state })</option>
						<option value="0">未售完（0）</option>
						<option value="1">售卖完毕（1）</option>
						<option value="2">取消售卖（2）</option>
						<option value="3">零售出（3）</option>
						
				</select></li>
				<input type="hidden" name="pageNum" value="1" /> <input
		type="hidden" name="numPerPage" value="50" /> <input type="hidden"
		name="orderField" value="${orderField}" /> <input
		type="hidden" name="orderDirection"
		value="${orderDirection}" />
			</ul>

			<div class="subBar">
				<ul>
					<li><div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">检索</button>
							</div>
						</div></li>

				</ul>
			</div>
		</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<ul>共有${totalSale }积分正在挂卖
			</ul>
		</ul>
	</div>
	<table class="table" width="1160" layoutH="138">
		<thead>
			<tr>

				<th width="70" align="center">挂卖单号</th>
				<th width="70" align="center" orderField="time" class="asc">挂卖时间</th>
				<th width="70" align="center" >挂卖人ID</th>
				<th width="70" align="center" orderField="price" class="asc">单价</th>
				<th width="70" align="center" orderField="num" class="asc">数量</th>
				<th width="70" align="center" orderField="allPrice" class="asc">总量</th>
				<th width="70">状态</th>
				<th width="70" align="center" orderField="residue" class="asc">剩余</th>

			</tr>
		</thead>
		<tbody>
		
			<c:forEach items="${pointsSaleList}" var="list">
				<tr >
					<td>${list.id }</td>
					<td>${list.time }</td>
					<td>${list.saleId }</td>
					<td>${list.price }</td>
					<td>${list.num }</td>
					<td>${list.allPrice }</td>
					<td>${list.state }</td>
					<td>${list.residue }</td>
				
				</tr>
				</c:forEach>
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>每页显示 50条，共${totalCount}条</span>
		</div>

		<div class="pagination" targetType="navTab"
			totalCount="${page.totalCount }" numPerPage="${page.everyPage }"
			pageNumShown="10" currentPage="${page.currentPage }"></div>

	</div>
</div>


