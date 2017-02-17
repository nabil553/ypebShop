<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="pageContent">
	<form method="post" action="backSuperLimit_SuperLimit_addRole"
		class="pageForm required-validate" class="pageForm required-validate"
		enctype="multipart/form-data"
		onsubmit="return iframeCallback(this, dialogAjaxDone);">
		<div class="pageFormContent nowrap" layoutH="100">
			<dl>
				<dt>角色名：</dt>
				<dd>
					<input name="role.name" type="text" size="100" alt="请输入角色名称"
						class="required" />
				</dd>
			</dl>
			<dl>
				<dt>超级管理员权限：</dt>
				<dd>
					<input type="radio" name="role.super_" value="true" />是 <input
						type="radio" name="role.super_" value="false"
						checked="checked" />否
				</dd>
			</dl>
			<dl>
				<dt>商城管理权限：</dt>
				<dd>
					<input type="radio" name="role.shopWeb" value="true" />是 <input
						type="radio" name="role.shopWeb" value="false"
						checked="checked" />否
				</dd>
			</dl>
			
			<dl>
				<dt>积分管理权限：</dt>
				<dd>
					<input type="radio" name="role.points" value="true" />是 <input
						type="radio" name="role.points" value="false"
						checked="checked" />否
				</dd>
			</dl>
			
			<dl>
				<dt>会员管理权限：</dt>
				<dd>
					<input type="radio" name="role.member" value="true" />是 <input
						type="radio" name="role.member" value="false"
						checked="checked" />否
				</dd>
			</dl>
			<dl>
				<dt>订单管理权限：</dt>
				<dd>
					<input type="radio" name="role.goodsOrder" value="true" />是 <input
						type="radio" name="role.goodsOrder" value="false"
						checked="checked" />否
				</dd>
			</dl>
			
			<dl>
				<dt>留言管理权限：</dt>
				<dd>
					<input type="radio" name="role.message" value="true" />是 <input
						type="radio" name="role.message" value="false"
						checked="checked" />否
				</dd>
			</dl>
			
			<dl>
				<dt>系统设置权限：</dt>
				<dd>
					<input type="radio" name="role.setting" value="true" />是 <input
						type="radio" name="role.setting" value="false"
						checked="checked" />否
				</dd>
			</dl>
			
			<dl>
				<dt>交易所权限：</dt>
				<dd>
					<input type="radio" name="role.trade" value="true" />是 <input
						type="radio" name="role.trade" value="0"
						checked="checked" />否
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
