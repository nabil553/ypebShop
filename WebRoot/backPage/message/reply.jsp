<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="pageContent">
	<form method="post" action="backMessage_Message_reply"
		class="pageForm required-validate" class="pageForm required-validate"
		onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent nowrap" layoutH="100">
			<input type="hidden" name="messag.id" value="${messag.id }">
			<div class="unit">
			<p>留言内容</p>
				<textarea  name="messag.content" rows="10" cols="100"
					readonly >${messag.content }</textarea>
			</div>
			<div class="unit">
			<p>回复</p>
				<textarea  name="messag.reply" rows="10" cols="100"
					class="required" ></textarea>
					
			</div>

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
