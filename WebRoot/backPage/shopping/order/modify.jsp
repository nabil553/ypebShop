<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="pageContent">
		<div class="pageFormContent nowrap" layoutH="100" style="height:100%">
		<c:forEach items="${orderGoodsList }" var="list" varStatus="var">
	
		<span class="info">商品${var.count }</span>
			<dl>
				<dt>商品ID：</dt>
				<dd>
					<input name="order.goodsId" type="text" size="20" 
						class="required" value="${list.goodsId }" readonly/>				
				</dd>
			</dl>
			<dl>
				<dt>商品名：</dt>
				<dd>
					<input name="order.goodsName" type="text" size="20" 
						class="required" value="${list.goodsName }"  readonly/>
				</dd>
			</dl>
			<dl>
				<dt>单价：</dt>
				<dd>
					<input name="list.unitPrice" type="text" size="20" 
						class="required" value="${list.unitPrice }" readonly/>
				</dd>
			</dl>
			<dl>
				<dt>数量：</dt>
				<dd>
					<input name="order.num" type="text" size="20" alt=""
						class="required digits" value="${list.num }" readonly/>
				</dd>
			</dl>
			<dl>
				<dt>总价：</dt>
				<dd>
					<input name="order.totalprice" type="text" size="20" alt="${list.totalPrice }"
						class="required" value="${list.totalPrice }" readonly/>
				</dd>
			</dl>

		
		</c:forEach>
		</div>
	
</div>
