<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="pageContent">
	<form method="post" action="backShopping_GoodsOrder_add" class="pageForm required-validate"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent nowrap" layoutH="100">
			<dl>
				<dt>购买人ID：</dt>
				<dd>
					<input name="order.userId" type="text" size="20" alt="请输入购买人ID"
						class="required" />
				</dd>
			</dl>
			<dl>
				<dt>商品ID：</dt>
				<dd>
					<input name="order.goodsId" type="text" size="20" alt="请输入商品ID"
						class="required" />
				</dd>
			</dl>
			<dl>
				<dt>单价：</dt>
				<dd>
					<input name="order.unitPrice" type="text" size="20" alt="请输入商品单价"
						class="required number" />
				</dd>
			</dl>
			<dl>
				<dt>数量：</dt>
				<dd>
					<input name="order.num" type="text" size="20" alt="请输入商品数量"
						class="required digits" />
				</dd>
			</dl>
			<dl>
				<dt>总价：</dt>
				<dd>
					<input name="order.totalprice" type="text" size="20" alt="请输入商品总价"
						class="required" />
				</dd>
			</dl>
			<dl>
				<dt>订单状态</dt>
				<dd>
					<select class="combox" name="order.state">
						<option value="${order.state }">订单状态(${order.state })</option>
						<option value="1" selected="selected">待发货（1）</option>
						<option value="2">发货中（2）</option>
						<option value="3">发货完成（3）</option>
						<option value="4">确认完成（4）</option>
					</select>
				</dd>
			</dl>
			<dl>
				<dt>订单类型</dt>
				<dd>
					<select class="combox" name="order.style">
						<option value="${order.style }">订单状态(${order.style })</option>
						<option value="0" selected="selected">普通会员（0）</option>
						<option value="1">商城会员（1）</option>				
					</select>
				</dd>
			</dl>
			
			<dl>
				<dt>收货地址ID：</dt>
				<dd>
					<input name="order.address" type="text" size="20" alt="请输入收货地址ID"
						class="required" />
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
