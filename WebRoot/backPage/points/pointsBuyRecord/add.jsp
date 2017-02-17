<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="pageContent">
	<form method="post" action="backShopping_Announcement_add" class="pageForm required-validate"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent nowrap" layoutH="100">
			<dl>
				<dt>标题：</dt>
				<dd>
					<input name="announcement.title" type="text" size="20" alt="请输入公告标题"
						class="required" />
				</dd>
			</dl>
			<div class="unit">
							<textarea class="editor" name="announcement.content" rows="30" cols="100" tools="mini">mini(迷你)</textarea>
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
