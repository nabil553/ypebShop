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
	action="backShopping_Goods_queryByPage">
	<input type="hidden" name="pageNum" value="${page.currentPage }" /> <input
		type="hidden" name="numPerPage" value="${page.everyPage}" /> <input
		type="hidden" name="orderField" value="${queryCondition.orderField}" />
	<input type="hidden" name="orderDirection"
		value="${queryCondition.orderDirection}" />
</form>

<div class="pageHeader">

	<form rel="pagerForm" onsubmit="return navTabSearch(this);"
		class="pageForm required-validate"
		action="backShopping_Goods_comprehensiveQuery" method="post">
		<div class="searchBar">
			<ul class="searchContent">
				<li><label>商品名：</label> <input type="text" name="goods.name"
					value="${goods.name }" /></li>
				<li><label>商品编码：</label> <input type="text" name="goods.code"
					value="${goods.code }" class="digits" /></li>
				<li><label>栏目分类：</label> <input type="text"
					name="goods.category2" value="${goods.category2 }" class="digits" /><span>二级id</span>
			</ul>
			<ul>
				<li><label>首页显示：</label><select class="combox"
					name="goods.isShow">

						<option value="true">显示（true）</option>
						<option value="false">不显示（false）</option>
				</select></li>
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
			<li><a class="add" href="backShopping_Goods_addPre"
				target="navTab" rel="addGoods" ><span>添加</span></a></li>
			<li><a class="delete"
				href="backShopping_Goods_delete?uid={sid_user} " target="ajaxTodo"
				title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit"
				href="backShopping_Goods_modifyPre?uid={sid_user}"
				target="navTab" width="900" height="600"><span>修改</span></a></li>

		</ul>

	</div>
	<table class="table" width="1160" layoutH="138">
		<thead>
			<tr>

				<th width="70" align="center">id</th>
				<th width="70" align="center">商品名</th>
				<th width="70" align="center">商品编码</th>
				<th width="70" align="center">销售价格</th>
				<th width="70" align="center">商城会员价格</th>
				<th width="70" align="center">赠送积分</th>
				<th width="70" align="center">进货价格</th>
				<th width="70" align="center">首页显示</th>
				<th width="70" align="center">一级栏目</th>
				<th width="70" align="center">二级栏目</th>
				<th width="70" align="center">联系人</th>
				<th width="70" align="center">电话</th>
				<th width="70" align="center">微信</th>


			</tr>
		</thead>
		<tbody>

			<c:forEach items="${goodsList}" var="list">
				<tr target="sid_user" rel="${list.id }">
					<td>${list.id }</td>
					<td>${list.name }</td>
					<td>${list.code }</td>
					<td>${list.price }</td>
					<td>${list.discountPrice }</td>
					<td>${list.givePoints }</td>
					<td>${list.purchacePrice }</td>
					<td><c:if test="${list.isShow==false }"> 不显示</c:if> <c:if
							test="${list.isShow==true }">显示</c:if></td>
					<td>${list.goodscategory.name }</td>
					<td>${list.category2name }</td>
					<td>${list.linkMan }</td>
					<td>${list.telephone }</td>
					<td>${list.webChat }</td>

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


