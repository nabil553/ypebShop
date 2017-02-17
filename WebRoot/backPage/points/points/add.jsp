<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="pageContent">
	<form method="post" action="backShopping_PointsPublish_add" class="pageForm required-validate"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent nowrap" layoutH="100">
			<dl>
				<dt>发行总量：</dt>
				<dd>
					<input name="totalNum" type="text" size="20" alt="请输入发行总量"
						class="required number" />
				</dd>
			</dl>
				<dl>
				<dt>商家会员释放次数：</dt>
				<dd>
					<input name="releaseTime" type="text" size="20" alt="请输入释放次数"
						class="required digits" />
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
