<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="pageContent">
	<form method="post" action="backUser_UserManage_modify" class="pageForm required-validate"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, dialogAjaxDone);">
		
		<input type="hidden" name="user.id" value="${user.id }">
		<div class="pageFormContent nowrap" layoutH="100">
			<dl>
				<dt>密码：</dt>
				<dd>
					<input id="w_validation_pwd" type="password" name="user.password" class="alphanumeric" minlength="6" maxlength="8" alt="字母、数字、下划线 6-20位"/>
					<span class="info">密码为6-8位</span>
				</dd>
			</dl>
			<dl>
				<dt>确认密码：</dt>
				<dd>
					<input type="password" name="repassword"  equalto="#w_validation_pwd"/>
					<span class="info"></span>
				</dd>
			</dl>
			<dl>
				<dt>手机号：</dt>
				<dd>
					<input name="user.telephone" type="text"  
						class="phone" value="${user.telephone }"/>
				</dd>
			</dl>
			<dl>
				<dt>身份证号：</dt>
				<dd>
					<input name="user.idcard" type="text" size="20" 
						 value="${user.idcard }"/>
				</dd>
			</dl>
			
			
			<dl>
				<dt>会员类型</dt>
				<dd>
					<select class="combox" name="user.style">
						
						<c:if test="${user.style==1 }" > <option value="1" selected="selected">普通会员</option>
						<option value="2">商城会员</option>
						</c:if>	
						<c:if test="${user.style==2 }" > <option value="1" >普通会员</option>
						<option value="2" selected="selected">商城会员</option>
						</c:if>				
					</select>
				</dd>
			</dl>
			<dl>
				<dt>会员级别</dt>
				<dd>
					<select class="combox" name="user.level">
						
						<c:if test="${user.style==1 }" > <option value="0" selected="selected">银卡会员</option>
						<option value="2">金卡会员</option>
						<option value="3">铂金会员</option>
						</c:if>	
						<c:if test="${user.style==2 }" > <option value="1" >银卡会员</option>
						<option value="2" selected="selected">金卡会员</option>
						<option value="3">铂金会员</option>
						</c:if>
						<c:if test="${user.style==3 }" > <option value="1" >银卡会员</option>
						<option value="2">金卡会员</option>
						<option value="3" selected="selected">铂金会员</option>
						</c:if>				
					</select>
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
