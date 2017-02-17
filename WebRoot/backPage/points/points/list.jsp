<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<head>
<base href="<%=basePath%>">

<title>商城订单管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<form id="pagerForm" method="post"
	action="backTrade_PointsSale_comprehensiveQuery">
	<input type="hidden" name="pageNum" value="1" /> <input type="hidden"
		name="numPerPage" value="50" /> <input type="hidden"
		name="pointspublishField" value="${queryCondition.pointspublishField}" /> <input
		type="hidden" name="pointspublishDirection"
		value="${queryCondition.pointspublishDirection}" />
</form>

<div class="pageHeader">

	<form rel="pagerForm" onsubmit="return navTabSearch(this);"
		class="pageForm required-validate"
		action="backShopping_Pointspublish_comprehensiveQuery" method="post">
		<div class="searchBar">
			<ul class="searchContent">
			
			</ul>

			<div class="subBar">
				<ul>
					
				</ul>
			</div>
		</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="backPage/points/points/add.jsp"
				target="dialog" rel="addCategroy" width="900" height="400"><span>添加</span></a></li>
			

		</ul>

	</div>
	<table class="table" width="1160" layoutH="138">
		<thead>
			<tr>

				<th width="70" align="center">id</th>
				<th width="70" align="center">操作人员ID</th>
				
				<th width="70" align="center">发行时间</th>
				<th width="70" align="center">总量</th>
				<th width="70" align="center">剩余</th>
				<th width="70" align="center">释放月数</th>
				<th width="70" align="center">是否卖完</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${pointspublishList}" var="list">
				<tr target="sid_user" rel="${list.id }">
					<td>${list.id }</td>
					<td>${list.operator }</td>
					<td>${list.time }</td>
					<td>${list.totalNum }</td>
					<td>${list.residue }</td>
					<td>${list.releaseTime }</td>
					<c:if test="${list.state==true }"><td>是</td>
					</c:if>
					<c:if test="${list.state==false }"><td>否</td>
					</c:if>
					
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


