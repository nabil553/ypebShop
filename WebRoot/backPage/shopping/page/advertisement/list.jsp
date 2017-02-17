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

<title>栏目分类管理</title>

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
		name="orderField" value="${queryCondition.orderField}" /> <input
		type="hidden" name="orderDirection"
		value="${queryCondition.orderDirection}" />
</form>

<div class="pageHeader">
<div class="searchBar">
			<ul class="searchContent">
			
			</ul>

			<div class="subBar">
				<ul>
					
				</ul>
			</div>
		</div>
	
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="backPage/shopping/page/advertisement/add.jsp"
				target="dialog" rel="addCategroy" width="900" height="400"><span>添加</span></a></li>
			<li><a class="delete"
				href="backShopping_Advertisement_delete?uid={sid_user} "
				target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit"
				href="backShopping_Advertisement_modifyPre?uid={sid_user}"
				target="dialog" width="900" height="300"><span>修改</span></a></li>
		</ul>

	</div>
	<table class="table" width="1160" layoutH="138">
		<thead>
			<tr>

				<!-- <th width="70" align="center">id</th> -->
				<th width="70" align="center">名称</th>
				<th width="200" align="center">描述</th>
				<th width="170" align="center">图片</th>
				<th width="70" align="center">类型</th>



			</tr>
		</thead>
		<tbody>

			<c:forEach items="${advertisementList}" var="list">
				<tr target="sid_user" rel="${list.id }">
					<%-- <td>${list.id }</td> --%>
					<td>${list.name }</td>
					<td>${list.descripe }</td>
					<td>${list.url }</td>
					<c:if test="${list.type==0 }"><td>首页广告</td>
					</c:if>
					<c:if test="${list.type==1 }"><td>其他页面广告</td>
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


