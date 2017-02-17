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
	<link rel="stylesheet" href="frontCss/shopping/announcement.css" />
  </head>
  
  <body>
    <!--nav-->
	<div class="nav_box">
		<div class="nav">
			<h1><a href="frontShopping_Index_bodyData" target="index">首页</a> &gt;</h1>
			<h1>公告</h1>
			<h1></h1>
		</div>
		<div class="clearfix"></div>
	</div>
	<div class="box">
		<div class="activity_box_list">
				<c:forEach items="${adList }" var="list">
						<img src="upload/image/advertisement/${list.url }" width="220px" height="300px">
				</c:forEach>
		</div>
		<div class="notice_list_list">
			<div class="category">
				<h1>标题</h1>
				<h2>日期</h2>
				<div class="clearfix"></div>
			</div>
			<div class="item">
			<div class="announ">
				<c:forEach items="${announcementList}" var="announcement">
						<h1 class="title"><a href="frontShopping_IndexOther_queryAnnoun?id=${announcement.id}" title="">${announcement.title}</a></h1>
						<h2><fmt:formatDate value="${announcement.time}"
								pattern="yyyy-MM-dd" /> </h2>
						<div class="clearfix"></div>
				</c:forEach>
			</div>
			<ul class="pageUl">
				<c:if test="${(page.currentPage-1)>0}">
					<li><a class="firstpage" href="frontShopping_IndexOther_queryListAnnoun?pageNum=${page.currentPage-1}">&laquo;</a></li>
				</c:if>
				<c:forEach begin="1" end="${page.totalPage}" var="i">
						<li><a href="frontShopping_IndexOther_queryListAnnoun?pageNum=${i}"
						   style="${(page.currentPage == i) ? 'background-color:lightgrey; width:10px;'  :''}"><span>${i}</span></a></li>
				</c:forEach>
				<c:if test="${page.currentPage<page.totalPage}">
					<li><a class="endpage" href="frontShopping_IndexOther_queryListAnnoun?pageNum=${page.currentPage+1}">&raquo;</a></li>
				</c:if>
			</ul>
			</div>
			<div class="clearfix"></div>
		</div>
		<div class="clearfix"></div>
	</div>
	<div class="addBottomHei"></div>
  </body>
</html>
