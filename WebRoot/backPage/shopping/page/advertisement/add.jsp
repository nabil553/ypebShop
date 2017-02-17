<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="pageContent">
	<form method="post" action="backShopping_Advertisement_add"
		class="pageForm required-validate" class="pageForm required-validate"
		enctype="multipart/form-data"
		onsubmit="return iframeCallback(this, dialogAjaxDone);">
		<div class="pageFormContent nowrap" layoutH="100">
			<dl>
				<dt>广告名：</dt>
				<dd>
					<input name="advertisement.name" type="text" size="100"
						alt="请输入广告名称" class="required" />
				</dd>
			</dl>
			<dl>
				<dt>描述：</dt>
				<dd>
				<dd>
					<input name="advertisement.descripe" type="text" size="300"
						alt="请输入广告描述" class="required" />
				</dd>
			</dl>

			<dl>
				<dt>广告类型</dt>
				<dd>
					<select class="combox" name="advertisement.type">
						<option value="0">首页广告</option>
						<option value="1">其他广告</option>
					</select>
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
