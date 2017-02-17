package com.ypeb.dataClass.front;

import java.sql.Timestamp;
import java.util.List;

import com.ypeb.model.shopping.orderGoods.Ordergoods;
import com.ypeb.model.user.address.Address;



public class OrderShow {
	private List<Ordergoods> goodsList;
	private String orderCode;
	private Address address;
	private Timestamp time;
	private Short state;
	
	
	
	public OrderShow() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Short getState() {
		return state;
	}


	public void setState(Short state) {
		this.state = state;
	}


	public List<Ordergoods> getGoodsList() {
		return goodsList;
	}


	public void setGoodsList(List<Ordergoods> goodsList) {
		this.goodsList = goodsList;
	}


	public String getOrderCode() {
		return orderCode;
	}


	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}




	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public Timestamp getTime() {
		return time;
	}


	public void setTime(Timestamp time) {
		this.time = time;
	}
	
	
	
	
	




	
}
