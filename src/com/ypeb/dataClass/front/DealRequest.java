package com.ypeb.dataClass.front;

public class DealRequest {
	private boolean request;//1为售卖，2为购买
	private int price;//单价
	private double num;//数量
	
	public boolean isRequest() {
		return request;
	}
	public void setRequest(boolean request) {
		this.request = request;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public double getNum() {
		return num;
	}
	public void setNum(double num) {
		this.num = num;
	}
	
	
	
	
}
