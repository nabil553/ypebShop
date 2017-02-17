package com.ypeb.dataClass.front;

public class QueryCondition {
	private String orderField="time";//查询字段
	private String orderDirection="asc";//降序升序
	private boolean state;
	private String orderField2;
	private short state2;
	
	
	public String getOrderField2() {
		return orderField2;
	}
	public void setOrderField2(String orderField2) {
		this.orderField2 = orderField2;
	}
	

	public short getState2() {
		return state2;
	}
	public void setState2(short state2) {
		this.state2 = state2;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public String getOrderField() {
		return orderField;
	}
	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}
	public String getOrderDirection() {
		return orderDirection;
	}
	public void setOrderDirection(String orderDirection) {
		this.orderDirection = orderDirection;
	}
	
	
	
	
	

}
