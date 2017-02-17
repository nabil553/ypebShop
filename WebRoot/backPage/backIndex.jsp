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
<html>
<head>
<base href="<%=basePath%>">

<title>沂品电子商务平台后台管理系统</title>

<link href="themes/default/style.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="themes/css/core.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="themes/css/print.css" rel="stylesheet" type="text/css"
	media="print" />
<link href="uploadify/css/uploadify.css" rel="stylesheet"
	type="text/css" media="screen" />
<!--[if IE]>
<link href="themes/css/ieHack.css" rel="stylesheet" type="text/css" media="screen"/>
<![endif]-->

<!--[if lte IE 9]>
<script src="js/speedup.js" type="text/javascript"></script>
<![endif]-->

<script src="js/jquery-1.7.2.js" type="text/javascript"></script>
<script src="js/jquery.cookie.js" type="text/javascript"></script>
<script src="js/jquery.validate.js" type="text/javascript"></script>
<script src="js/jquery.bgiframe.js" type="text/javascript"></script>
<script src="xheditor/xheditor-1.2.1.min.js" type="text/javascript"></script>
<script src="xheditor/xheditor_lang/zh-cn.js" type="text/javascript"></script>
<script src="uploadify/scripts/jquery.uploadify.js"
	type="text/javascript"></script>

<!-- svg图表  supports Firefox 3.0+, Safari 3.0+, Chrome 5.0+, Opera 9.5+ and Internet Explorer 6.0+ -->
<script type="text/javascript" src="chart/raphael.js"></script>
<script type="text/javascript" src="chart/g.raphael.js"></script>
<script type="text/javascript" src="chart/g.bar.js"></script>
<script type="text/javascript" src="chart/g.line.js"></script>
<script type="text/javascript" src="chart/g.pie.js"></script>
<script type="text/javascript" src="chart/g.dot.js"></script>

<script src="js/dwz.core.js" type="text/javascript"></script>
<script src="js/dwz.util.date.js" type="text/javascript"></script>
<script src="js/dwz.validate.method.js" type="text/javascript"></script>
<script src="js/dwz.regional.zh.js" type="text/javascript"></script>
<script src="js/dwz.barDrag.js" type="text/javascript"></script>
<script src="js/dwz.drag.js" type="text/javascript"></script>
<script src="js/dwz.tree.js" type="text/javascript"></script>
<script src="js/dwz.accordion.js" type="text/javascript"></script>
<script src="js/dwz.ui.js" type="text/javascript"></script>
<script src="js/dwz.theme.js" type="text/javascript"></script>
<script src="js/dwz.switchEnv.js" type="text/javascript"></script>
<script src="js/dwz.alertMsg.js" type="text/javascript"></script>
<script src="js/dwz.contextmenu.js" type="text/javascript"></script>
<script src="js/dwz.navTab.js" type="text/javascript"></script>
<script src="js/dwz.tab.js" type="text/javascript"></script>
<script src="js/dwz.resize.js" type="text/javascript"></script>
<script src="js/dwz.dialog.js" type="text/javascript"></script>
<script src="js/dwz.dialogDrag.js" type="text/javascript"></script>
<script src="js/dwz.sortDrag.js" type="text/javascript"></script>
<script src="js/dwz.cssTable.js" type="text/javascript"></script>
<script src="js/dwz.stable.js" type="text/javascript"></script>
<script src="js/dwz.taskBar.js" type="text/javascript"></script>
<script src="js/dwz.ajax.js" type="text/javascript"></script>
<script src="js/dwz.pagination.js" type="text/javascript"></script>
<script src="js/dwz.database.js" type="text/javascript"></script>
<script src="js/dwz.datepicker.js" type="text/javascript"></script>
<script src="js/dwz.effects.js" type="text/javascript"></script>
<script src="js/dwz.panel.js" type="text/javascript"></script>
<script src="js/dwz.checkbox.js" type="text/javascript"></script>
<script src="js/dwz.history.js" type="text/javascript"></script>
<script src="js/dwz.combox.js" type="text/javascript"></script>
<script src="js/dwz.print.js" type="text/javascript"></script>
<!--
<script src="bin/dwz.min.js" type="text/javascript"></script>
-->
<script src="js/dwz.regional.zh.js" type="text/javascript"></script>

<script type="text/javascript">
	$(function() {
		DWZ.init("dwz.frag.xml", {
			loginUrl : "login_dialog.html",
			loginTitle : "登录", // 弹出登录对话框
			//		loginUrl:"login.html",	// 跳到登录页面
			statusCode : {
				ok : 200,
				error : 300,
				timeout : 301
			}, //【可选】
			pageInfo : {
				pageNum : "pageNum",
				numPerPage : "numPerPage",
				orderField : "orderField",
				orderDirection : "orderDirection"
			}, //【可选】
			debug : false, // 调试模式 【true|false】
			callback : function() {
				initEnv();
				$("#themeList").theme({
					themeBase : "themes"
				}); // themeBase 相对于index页面的主题base路径
			}
		});
	});
</script>
</head>

<body scroll="no">
	<div id="layout">
		<div id="header">
			<div class="headerNav">
				<a class="logo" href="http://j-ui.com">标志</a>
				<ul class="nav">
					<li><a href="backLogin_Login_logOff">退出</a></li>
				</ul>
				<ul class="themeList" id="themeList">
					<li theme="default"><div class="selected">蓝色</div></li>
					<li theme="green"><div>绿色</div></li>
					<!--<li theme="red"><div>红色</div></li>-->
					<li theme="purple"><div>紫色</div></li>
					<li theme="silver"><div>银色</div></li>
					<li theme="azure"><div>天蓝</div></li>
				</ul>
			</div>

			<!-- navMenu -->

		</div>

		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse">
						<div></div>
					</div>
				</div>
			</div>
			<div id="sidebar">
				<div class="toggleCollapse">
					<h2>平台管理</h2>
					<div>收缩</div>
				</div>

				<div class="accordion" fillSpace="sidebar">

				
						<c:if test="${role.super_==true }">
							<!--*******************************超级管理员系统 *******************************-->
							<div class="accordionHeader">
								<h2>
									<span>Folder</span>超级管理员系统
								</h2>
							</div>
							<div class="accordionContent">
								<ul class="tree treeFolder">
									<li><a href="backSuperLimit_SuperLimit_list"
										target="navTab" rel="manager">账号管理</a></li>
									<li><a href="backSuperLimit_SuperLimit_roleList"
										target="navTab" rel="role">角色管理</a></li>

								</ul>
							</div>
						</c:if>
						<!--   *******************************积分交易系统******************************* -->
						<c:if test="${role.points==true }">
							<div class="accordionHeader">
								<h2>
									<span>Folder</span>积分管理系统
								</h2>
							</div>
							<div class="accordionContent">
								<ul class="tree treeFolder">
									<li><a href="backShopping_PointsPublish_list"
										target="navTab" rel="pointsPublish" fresh="true">积分发行</a></li>
									<li><a href="backShopping_PointsBuyRecord_list"
										target="navTab" rel="points" fresh="true">发行积分售卖记录</a></li>
								</ul>
							</div>
						</c:if>
						<c:if test="${role.shopWeb==true }">
							<!-- *************************商城管理******************************* -->

							<div class="accordionHeader">
								<h2>
									<span>Folder</span>商城管理
								</h2>
							</div>
							<div class="accordionContent">
								<ul class="tree treeFolder">
									<li><a>商城订单管理</a>
										<ul>
											<li><a href="backShopping_GoodsOrder_listToSend"
												target="navTab" rel="order" fresh="true">未发货订单</a></li>
											<li><a href="backShopping_GoodsOrder_comprehensiveQuery"
												target="navTab" rel="orderList" fresh="true">订单查询</a></li>
											<li><a href="backPage/shopping/order/listAddress.jsp"
												target="navTab" rel="address" fresh="true">收货地址查询</a></li>

										</ul></li>
									<li><a>商品管理</a>
										<ul>
											<li><a href="backShopping_Goods_queryByPage"
												target="navTab" rel="goods" fresh="true">商品管理</a></li>

										</ul></li>
									<li><a>栏目分类管理</a>
										<ul>
											<li><a href="backShopping_Category_list" target="navTab"
												rel="category" fresh="true">栏目管理</a></li>
										</ul></li>
									<li><a>页面管理</a>
										<ul>
											<li><a href="backShopping_Advertisement_list"
												target="navTab" rel="advertisement" fresh="true">广告管理</a></li>
											<li><a href="backShopping_Roll_list" target="navTab"
												rel="roll" fresh="true">轮播管理</a></li>
											<li><a href="backShopping_Announcement_list"
												target="navTab" rel="announcement" fresh="true">公告管理</a></li>
										</ul></li>
								</ul>

							</div>
						</c:if>
						<c:if test="${role.member==true }">
							<!--******************************* 会员管理 *******************************-->
							<div class="accordionHeader">
								<h2>
									<span>Folder</span>会员管理
								</h2>
							</div>
							<div class="accordionContent">
								<ul class="tree treeFolder">
									<li><a href="backUser_UserManage_userList" target="navTab"
										rel="userManage" fresh="true">会员管理</a></li>
									<li><a href="backUser_UserManage_listRecharge"
										target="navTab" rel="recharge" fresh="true">会员充值申请</a></li>
									<li><a href="backUser_UserManage_listWithdraw"
										target="navTab" rel="withdraw" fresh="true">会员提现申请</a></li>
									<li><a href="backUser_UserManage_listRecord"
										target="navTab" rel="cashRecord" fresh="true">充值提现记录</a></li>
								</ul>
							</div>
						</c:if>
						<!--******************************* 积分系统 *******************************  -->

						<%-- <div class="accordionHeader">
						<h2>
							<span>Folder</span>交易所管理
						</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">

							<li><a>挂卖和求购信息管理</a>
								<ul>
									<li><a href="backTrade_PointsSale_saleInfo"
										target="navTab" rel="saleInfo" fresh="true">挂卖信息</a></li>
									<li><a href="backTrade_PointsBuy_buyInfo" target="navTab"
										rel="buyInfo" fresh="true">求购信息</a></li>
								</ul></li>
							<li><a>交易记录管理</a>
								<ul>
									<li><a href="frontTrade_PointsTrade_tradeInfo"
										target="navTab" rel="saleInfo" fresh="true">交易记录</a></li>

								</ul></li>

						</ul>
					</div> --%>
						<!--******************************* 留言管理系统 *******************************  -->
						<c:if test="${role.message==true }">
							<div class="accordionHeader">
								<h2>
									<span>Folder</span>留言系统管理
								</h2>
							</div>
							<div class="accordionContent">
								<ul class="tree treeFolder">
									<li><a href="backMessage_Message_listToReply"
										target="navTab" rel="messageToReply" fresh="true">待回复留言</a></li>
									<li><a href="backMessage_Message_list" target="navTab"
										rel="message" fresh="true">留言查询</a></li>
								</ul>
							</div>
						</c:if>
						<!--******************************* 系统设置 *******************************  -->
						<c:if test="${role.setting==true }">
							<div class="accordionHeader">
								<h2>
									<span>Folder</span>系统设置
								</h2>
							</div>
							<div class="accordionContent">
								<ul class="tree treeFolder">
									<li><a href="backSetting_Setting_list" target="navTab"
										rel="setting" fresh="true">系统设置</a></li>
								</ul>
							</div>
						</c:if>
				</div>
			</div>
		</div>
		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent">
						<!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">
							<li tabid="main" class="main"><a href="javascript:;"><span><span
										class="home_icon">我的主页</span></span></a></li>
						</ul>
					</div>
					<div class="tabsLeft">left</div>
					<!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
					<div class="tabsRight">right</div>
					<!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
					<div class="tabsMore">more</div>
				</div>
				<ul class="tabsMoreList">
					<li><a href="javascript:;">我的主页</a></li>
				</ul>
				<div class="navTab-panel tabsPageContent layoutBox">
					<div class="page unitBox">
						<div class="accountInfo">
							<div class="alertInfo"></div>
							<div class="right"></div>
							<p></p>
							<p></p>
						</div>


						<div style="width:230px;position: absolute;top:60px;right:0"
							layoutH="80">
							<iframe width="100%" height="430" class="share_self"
								frameborder="0" scrolling="no"
								src="http://widget.weibo.com/weiboshow/index.php?width=0&height=430&fansRow=2&ptype=1&skin=1&isTitle=0&noborder=1&isWeibo=1&isFans=0&uid=1739071261&verifier=c683dfe7"></iframe>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>

	</div>

	<div id="footer">
		Copyright &copy; 2016 <a href="javascript:void(0);" target="dialog">沂品电子商务平台&赛捷技术</a>
		备案号
	</div>

</body>
</html>
