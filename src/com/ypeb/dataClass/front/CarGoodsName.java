package com.ypeb.dataClass.front;


import com.ypeb.model.shopping.shoppingCar.Shoppingcar;

public class CarGoodsName {
	private String name;//商品名
	private Shoppingcar car;//订单
	private String image;
	private Double price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Shoppingcar getCar() {
		return car;
	}
	public void setCar(Shoppingcar car) {
		this.car = car;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	

}
