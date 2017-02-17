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

<title>积分发行记录管理</title>

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
	action="backShopping_PointsBuyRecord_list">
		<input type="hidden" name="pageNum" value="${page.currentPage }" /> <input
		type="hidden" name="numPerPage" value="${page.everyPage}" />
	<%-- <input type="hidden"
		name="announcementField" value="${queryCondition.announcementField}" /> <input
		type="hidden" name="announcementDirection"
		value="${queryCondition.announcementDirection}" /> --%>
</form>

<div class="pageHeader">

	<form rel="pagerForm" onsubmit="return navTabSearch(this);"
		class="pageForm required-validate"
		action="backShopping_announcement_comprehensiveQuery" method="post">
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
		

		</ul>

	</div>
	<table class="table" width="1160" layoutH="138">
		<thead>
			<tr>

				<th width="90" align="center">id</th>
				<th width="90" align="center">购买人ID</th>
				<th width="90" align="center">购买人手机号</th>
				<th width="90" align="center">数量</th>
				<th width="90" align="center">时间</th>
				<th width="90" align="center">发行编次ID</th>
				<th width="90" align="center">是否释放完毕</th>

			</tr>
		</thead>
		<tbody>

			<c:forEach items="${pointsUserRecord}" var="record">
				<tr target="sid_user" rel="${points.id }">
					<td>${record.points.id }</td>
					<td>${record.points.userId }</td>
					<td>${record.telephone }</td>
					<td>${record.points.pointNum }</td>
					<td>${record.points.time }</td>
					<td>${record.points.pointspublish.id }</td>
					<c:if test="${record.points.state==true }"><td>是</td>
					</c:if>
					<c:if test="${record.points.state==false }"><td>否</td>
					</c:if>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>每页显示 17条，共${page.totalCount}条</span>
		</div>

		<div class="pagination" targetType="navTab"
			totalCount="${page.totalCount }" numPerPage="${page.everyPage }"
			pageNumShown="10" currentPage="${page.currentPage }"></div>

	</div>
</div>


