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

<title>会员管理</title>

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
	action="backUser_UserManage_listRecord">
	<input type="hidden" name="pageNum" value="${page.currentPage }" /> <input
		type="hidden" name="numPerPage" value="${page.everyPage}" />
	<%-- <input type="hidden"
		name="orderField" value="${queryCondition.orderField}" /> <input
		type="hidden" name="orderDirection"
		value="${queryCondition.orderDirection}" /> --%>
</form>

<div class="pageHeader">

	<form rel="pagerForm" onsubmit="return navTabSearch(this);"
		class="pageForm required-validate"
		action="backUser_UserManage_queryUser" method="post">
		<div class="searchBar">
			<ul class="searchContent">
				<%-- <li><label>用户手机号：</label> <input type="text" name="telephone"
					value="${telephone }" class="phone" /></li> --%>

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
			<%-- <li><a class="edit"
				href="backUser_UserManage_recharge?uid={sid_user} "
				target="ajaxTodo" title="确定已经提现成功吗?"><span>确认提现</span></a></li>  --%>
			<%-- <li><a class="edit"
				href="backUser_UserManage_modifyPre?uid={sid_user}" target="dialog"
				width="900" height="400"><span>修改</span></a></li> --%>
		</ul>

	</div>
	<table class="table" width="1160" layoutH="138">
		<thead>
			<tr>
				<th width="70" align="center">id</th>
				<th width="70" align="center">用户名</th>
				<th width="100" align="center">微信号</th>
				<th width="70" align="center">类型</th>
				<th width="70" align="center">数量</th>
				<th width="70" align="center">时间</th>
				<th width="70" align="center">手续费率</th>
				<th width="70" align="center">状态</th>




			</tr>
		</thead>
		<tbody>

			<c:forEach items="${cashUserList}" var="list">
				<tr target="sid_user" rel="${list.cash.id }">
					<td>${list.cash.id}</td>
					<td>${list.userName}</td>
					<td>${list.cash.webChat }</td>
					<td><c:if test="${list.cash.operate==true }">充值操作</c:if> <c:if
							test="${list.cash.operate==false }">提现操作</c:if></td>
					<td>${list.cash.num }</td>
					<td>${list.cash.time }</td>
					<td>${list.cash.rate }</td>
					<td><c:if test="${list.cash.state==2 }">操作完成</c:if> <c:if
							test="${list.cash.state==1 }">未处理</c:if> <c:if
							test="${list.cash.state==3 }">取消操作</c:if></td>

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


