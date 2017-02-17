package com.ypeb.dataClass.front;

import java.util.List;

import com.ypeb.model.shopping.goodsOrder.Order;
import com.ypeb.model.shopping.orderGoods.Ordergoods;

public class OrderGoodsShow {
	//一个订单要显示的内容,包括一个订单记录和相应的所有订单商品的信息;
	private Order order;
	private List<Ordergoods> orderGoodsList;

	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public List<Ordergoods> getOrderGoodsList() {
		return orderGoodsList;
	}
	public void setOrderGoodsList(List<Ordergoods> orderGoodsList) {
		this.orderGoodsList = orderGoodsList;
	}

}
