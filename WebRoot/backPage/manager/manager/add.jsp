<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="pageContent">
	<form method="post" action="backSuperLimit_SuperLimit_add"
		class="pageForm required-validate" class="pageForm required-validate"
		enctype="multipart/form-data"
		onsubmit="return iframeCallback(this, dialogAjaxDone);">
		<div class="pageFormContent nowrap" layoutH="100">
			<dl>
				<dt>用户名：</dt>
				<dd>
					<input name="manager.name" type="text" size="100" alt="请输入角色名称"
						class="required" />
				</dd>
			</dl>
			<dl>
				<dt>选择角色：</dt>
				<select name="manager.role.id" class="required combox">
					<option value="">请选择</option>
					<c:forEach items="${roleList }" var="list">
						<option value="${list.id }">${list.name }</option>
					</c:forEach>
				</select>
			</dl>
			<dl>
				<dt>真实姓名：</dt>
				<dd>
					<input name="manager.realName" type="text" size="100" alt="请输入真实名称"
						class="required" />
				</dd>
			</dl>
			<dl>
				<dt>电话：</dt>
				<dd>
					<input type="text" name="manager.telephone" class="phone"
						alt="请输入您的电话" /> <span class="info"></span>
				</dd>
			</dl>
			<dl>
				<dt>密码：</dt>
				<dd>
					<input id="w_validation_pwd" type="password"
						name="manager.password" class="required alphanumeric"
						minlength="6" maxlength="20" alt="字母、数字、下划线 6-20位" /> <span
						class="info">6~10位密码</span>
				</dd>
			</dl>
			<dl>
				<dt>确认密码：</dt>
				<dd>
					<input type="password" name="repassword" class="required"
						equalto="#w_validation_pwd" /> <span class="info">确认密码</span>
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
