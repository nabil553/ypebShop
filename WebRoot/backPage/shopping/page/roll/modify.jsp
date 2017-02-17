<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="pageContent">
	<form method="post" action="backShopping_Roll_modify"
		class="pageForm required-validate" class="pageForm required-validate"
		enctype="multipart/form-data"
		onsubmit="return iframeCallback(this, dialogAjaxDone);">
		<input type="hidden" name="roll.id" value="${roll.id }">
		<div class="pageFormContent nowrap" layoutH="100">
			<dl>
				<dt>轮播名：</dt>
				<dd>
					<input name="roll.name" type="text" size="100"
						alt="请输入轮播名称" class="required" value="${roll.name }"/>
				</dd>
			</dl>
			<dl>
				<dt>商品ID：</dt>
				<dd>
				<dd>
					<input name="roll.goodsId" type="text" size="80"
						alt="请输入商品ID" class="required" value="${roll.goodsId }"/>
				</dd>
			</dl>

			
			<dl>
				<dt>栏目图片上传：</dt>
				<dd>
					<input type="file" name="image" />
				</dd>
				<span class="info">图片名不要有汉字</span>
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
