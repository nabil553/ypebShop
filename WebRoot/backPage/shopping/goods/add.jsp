<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%
	String datetime = new SimpleDateFormat("yyyy-MM-dd")
			.format(Calendar.getInstance().getTime());
%>
<base href="<%=basePath%>">
<div class="pageContent">
	<form method="post" action="backShopping_Goods_add"
		class="pageForm required-validate" class="pageForm required-validate"
		enctype="multipart/form-data"
		onsubmit="return iframeCallback(this, navTabAjaxDone);">
		<div class="pageFormContent nowrap" layoutH="100">
			<dl>
				<dt>商品名：</dt>
				<dd>
					<input name="goods.name" type="text" size="100" alt="请输入商品名称"
						class="required" />
				</dd>
			</dl>
			<dl>
				<dt>商品规格：</dt>
				<dd>
					<input name="goods.specification" type="text" size="100"
						alt="请输入商品规格" class="required" />
				</dd>
			</dl>
			<dl>
				<dt>联系人：</dt>
				<dd>
					<input name="goods.linkMan" type="text" size="100"
						alt="请输入商品规格 联系人姓名" class="" />
				</dd>
			</dl>
			<dl>
				<dt>电话：</dt>
				<dd>
					<input name="goods.telephone" type="text" size="100" alt="请输入联系人电话"
						class=" phone" />
				</dd>
			</dl>
			<dl>
				<dt>微信号：</dt>
				<dd>
					<input name="goods.webChat" type="text" size="100" alt="请输入联系人微信号"
						class="" />
				</dd>
			</dl>
			<dl>
				<dt>首页主图片上传：</dt>
				<dd>
					<input type="file" name="images" class="required" />
					
				</dd>
			</dl>
			<dl>
				<dt>详情图片1上传：</dt>
				<dd>
					<input type="file" name="images" class="" />
					
				</dd>
				</dl>
				<dl>
				<dt>详情图片2上传：</dt>
				<dd>
					<input type="file" name="images" class="" />
					
				</dd>
				</dl>
				<dl>
				<dt>详情图片3上传：</dt>
				<dd>
					<input type="file" name="images" class="" />
					
				</dd>
				</dl>
				<dl>
				<dt>详情图片4上传：</dt>
				<dd>
					<input type="file" name="images" class="" />
					
				</dd>
				</dl>
					<span class="info">图片名不要有汉字,大小不超过500k,尺寸为400*400,格式为PNG，JPG，</span>
			</dl>
			<dl>
				<dt>普通会员价格：</dt>
				<dd>
					<input type="text" name="goods.price" class="number required" />
				</dd>
			</dl>

			<dl>
				<dt>商城会员价格：</dt>
				<dd>
					<input type="text" name="goods.discountPrice"
						class="number required" />
				</dd>
			</dl>

			<dl>
				<dt>进货价格：</dt>
				<dd>
					<input type="text" name="goods.purchacePrice"
						class="number required" />
				</dd>
			</dl>

			<dl>
				<dt>赠送积分：</dt>
				<dd>
					<input type="text" name="goods.givePoints" class="number" />
				</dd>
			</dl>


			<dl>
				<dt>商品属性：</dt>
				<dd>
					<input type="text" name="goods.attribute" class="required" />
				</dd>
			</dl>

			<dl>
				<dt>商品编码：</dt>
				<dd>
					<input type="text" name="goods.code" class="digits required" />
				</dd>
			</dl>

			<dl class="nowrap">
				<dt>一级栏目分类：</dt>
				<dd>
					<input class="required" name="district.cate1" type="text" readonly /><input
						name="district.id1" value="" type="hidden" />
				</dd>
			</dl>

			<dl class="nowrap">
				<dt>二级栏目分类：</dt>
				<dd>
					<input name="district.id2" value="" type="hidden" /> <input
						class="required" name="district.cate2" type="text" readonly /> <a
						class="btnLook" href="backShopping_Goods_queryCategory2"
						lookupGroup="district">查找带回</a>
				</dd>
				<span class="info">点击左边放大镜即可选择栏目</span>
			</dl>

			<%-- 	<dl>
				<dt>商品一级分类栏目：</dt>
				<dd>
					<select class="combox required" name="goods.goodscategory.id"
						ref="category2" refUrl="backShopping_Goods_queryCategory2?uid={value}">">
						<c:forEach items="${categoryList}" var="category1">
							<option value="${category1.id}">${category1.name }</option>
						</c:forEach>
					</select>
				</dd>
			</dl>

			<dl>
				<dt>商品二级分类栏目：</dt>
				<dd>
					<select class="combox required" name="goods.category2" id="category2"
						ref="w_combox_area" refUrl="backShopping_Goods_queryCategory2?uid={value}">
						
					</select>
				</dd>
			</dl> --%>

			<dl>
				<dt>是否在首页显示：</dt>
				<dd>
					<input type="radio" name="goods.isShow" value="true" />是 <input
						type="radio" name="goods.isShow" value="false" checked="checked" />否
				</dd>
			</dl>


			<dl class="nowrap">
				<dt>商品介绍：</dt>
				<dd>
					<textarea class="editor" name="goods.description" rows="50"
						style="width:962px;" upImgUrl="backShopping_GoodsUpload_uploadImage"
						upImgExt="jpg,jpeg,gif,bmp,png"><base
							href="<%=basePath%>">如果内容编辑器中上传过图片，但想取消编辑或，请不要直接点击取消，先点击保存，再删除该记录</textarea>
				</dd>
			</dl>

		</div>
		<div class="formBar">
			<ul>
				<!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">保存</button>
						</div>
					</div></li>
				<li>
					<div class="button">
						<div class="buttonContent">
							<button type="button" class="close">取消</button>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</form>
</div>
