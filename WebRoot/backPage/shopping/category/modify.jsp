<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="pageContent">
	<form method="post" action="backShopping_Category_modify"
		class="pageForm required-validate" class="pageForm required-validate"
		enctype="multipart/form-data"
		onsubmit="return iframeCallback(this, dialogAjaxDone);">
		<input type="hidden" name="category.id" value="${category.id }">
		<div class="pageFormContent nowrap" layoutH="100">
			<dl>
				<dt>栏目名：</dt>
				<dd>
					<input name="category.name" type="text" size="100" alt="请输入栏目名称"
						class="required" value="${category.name }" />
				</dd>
			</dl>
			<dl>
				<dt>是否成为单独楼层：</dt>
				<dd>
					<c:if test="${category.isFloor==false }">
						<input type="radio" name="category.isFloor" value="true" />是 <input
							type="radio" name="category.isFloor" value="false"
							checked="checked" />否
						</c:if>
					<c:if test="${category.isFloor==true }">
						<input type="radio" name="category.isFloor" value="true"
							checked="checked" />是 <input type="radio"
							name="category.isFloor" value="false" />否
						</c:if>
				</dd>
			</dl>

			<dl>
				<dt>分类等级</dt>
				<dd>
					<select class="combox" name="category.level">
						<c:if test="${category.level==1 }">
							<option value="1">1</option>
							<option value="2">2</option>
						</c:if>
						<c:if test="${category.level==2 }">
							<option value="1">1</option>
							<option value="2" selected="selected">2</option>
						</c:if>
					</select>
				</dd>
			</dl>

			<dl>
				<dt>上级栏目ID：</dt>
				<dd>
					<input name="category.superId" type="text" size="20"
						alt="分类等级为1不需填写" class="digits" value="${category.superId }" />
				</dd>
			</dl>
			<dl>
				<dt>栏目图片上传：</dt>
				<dd>
					<input type="file" name="image" class="required" />
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
