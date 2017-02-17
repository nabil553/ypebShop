<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="pageContent">
	<form method="post" action="backSetting_Setting_modify" class="pageForm required-validate"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, dialogAjaxDone);">
		
		
		<div class="pageFormContent nowrap" layoutH="100">
		<input type="hidden" name="setting.id" value="${setting.id}">
			<dl>
				<dt>当前积分价格（积分/RMB）：</dt>
				<dd>
					<input name="setting.price" type="text" size="20" 
						class="required number" value="${setting.price }"/>
				</dd>
			</dl>
			<dl>
				<dt>现金转积分释放月份（商家）：</dt>
				<dd>
					<input name="setting.month " type="text" size="20" 
						class="required number" value="${setting.month }"/>
				</dd>
			</dl>
			<dl>
				<dt>赠送积分冻结天数：</dt>
				<dd>
					<input name="setting.giveDays" type="text" size="20" 
						class="required number" value="${setting.giveDays }"/>
				</dd>
			</dl>
			<dl>
				<dt>消费积分转交易积分冻结天数：</dt>
				<dd>
					<input name="setting.consumeDays" type="text" size="20" 
						class="required number" value="${setting.consumeDays }"/>
				</dd>
			</dl>
			<dl>
				<dt>提现手续费比率：</dt>
				<dd>
					<input name="setting.withdrawRate" type="text" size="20" 
						class="required number" value="${setting.withdrawRate }"/>
				</dd>
			</dl>
			<dl>
				<dt>平台积分购买上上限：</dt>
				<dd>
					<input name="setting.maxPoints" type="text" size="20" 
						class="required number" value="${setting.maxPoints }"/>
				</dd>
			</dl>
			<dl>
				<dt>直返现金：</dt>
				<dd>
					<input name="setting.feedbackAward" type="text" size="20" 
						class="required number" value="${setting.feedbackAward }"/>
				</dd>
			</dl>
			<dl>
				<dt>一级团队奖励：</dt>
				<dd>
					<input name="setting.firstAward" type="text" size="20" 
						class="required number" value="${setting.firstAward }"/>
				</dd>
			</dl>
			<dl>
				<dt>二级团队奖励：</dt>
				<dd>
					<input name="setting.secondAward" type="text" size="20" 
						class="required number" value="${setting.secondAward }"/>
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
