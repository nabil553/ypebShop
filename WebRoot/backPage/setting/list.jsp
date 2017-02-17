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
		name="announcementField" value="${queryCondition.announcementField}" />
	<input type="hidden" name="announcementDirection"
		value="${queryCondition.announcementDirection}" />
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
		
			<li><a class="edit"
				href="backSetting_Setting_modifyPre" target="dialog"
				rel="addCategroy" width="900" height="520"><span>修改</span></a></li>

		</ul>

	</div>
	<table class="table" width="1160" layoutH="138">
		<thead>
			<tr>

				<th width="70" align="center">积分价格</th>
				<th width="100" align="center">现金转积分释放月份（商家）</th>
				<th width="70" align="center">赠送积分冻结天数</th>
				<th width="100" align="center">消费积分转交易积分冻结天数</th>
				<th width="70" align="center">提现手续费比率</th>
				<th width="70" align="center">平台积分购买上上限</th>
				<th width="70" align="center">直返现金</th>
				<th width="70" align="center">一级团队奖励</th>
				<th width="70" align="center">二级团队奖励</th>
			</tr>
		</thead>
		<tbody>
			<tr target="sid_user" rel="${setting.id }">
					<td>${setting.price }</td>
					<td>${setting.month }</td>
					<td>${setting.giveDays }</td>
					<td>${setting.consumeDays }</td>
					<td>${setting.withdrawRate }</td>
					<td>${setting.maxPoints }</td>
					<td>${setting.feedbackAward }</td>
					<td>${setting.firstAward }</td>
					<td>${setting.secondAward }</td>
					
					

				</tr>
			
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


