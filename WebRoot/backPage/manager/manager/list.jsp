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
	action="backSuperLimit_SuperLimit_list">
	<input type="hidden" name="pageNum" value="1" /> <input type="hidden"
		name="numPerPage" value="50" /> <input type="hidden"
		name="goodsOrderField" value="${queryCondition.goodsOrderField}" /> <input
		type="hidden" name="goodsOrderDirection"
		value="${queryCondition.goodsOrderDirection}" />
</form>

<div class="pageHeader">

	<form rel="pagerForm" onsubmit="return navTabSearch(this);"
		class="pageForm required-validate"
		action="backShopping_Category_comprehensiveQuery" method="post">
		<div class="searchBar">
			<ul class="searchContent">
				<%-- <li><label>栏目名：</label> <input type="text" name="category.name"
					value="${category.name }" /></li>
				<li><label>所属栏目id：</label> <input type="text"
					name="category.superId" value="${category.superId }" class="digits" /></li>

				<li><select class="combox" name="category.level">
						<option value="${category.level }">分类等级(${category.level })</option>

						<option value="1">一级栏目（1）</option>
						<option value="2">二级栏目（2）</option>


				</select> --%>
				</li>

			</ul>

			<div class="subBar">
				<ul>
					<!-- <li><div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">检索</button>
							</div>
						</div></li> -->

				</ul>
			</div>
		</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="backSuperLimit_SuperLimit_addPre"
				target="dialog" rel="addCategroy" width="900" height="400"><span>添加</span></a></li>
			<li><a class="delete"
				href="backSuperLimit_SuperLimit_delete?uid={sid_user} "
				target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit"
				href="backSuperLimit_SuperLimit_modifyPre?uid={sid_user}"
				target="dialog" width="900" height="500"><span>修改</span></a></li>
		</ul>

	</div>
	<table class="table" width="1160" layoutH="138">
		<thead>
			<tr>

				<th width="70" align="center">id</th>
				<th width="70" align="center">用户名</th>
				<th width="70" align="center">角色名</th>
				<th width="70" align="center">真实姓名</th>
				<th width="70" align="center">电话</th>
				


			</tr>
		</thead>
		<tbody>

			<c:forEach items="${managerRoleList}" var="list">
				<tr target="sid_user" rel="${list.manager.id }">
					<td>${list.manager.id }</td>
					<td>${list.manager.name }</td>
					<td>${list.role.name }</td>
					<td>${list.manager.realName }</td>
					<td>${list.manager.telephone }</td>
					
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


