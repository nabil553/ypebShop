package com.ypeb.dataClass.front;

import java.util.ArrayList;
import java.util.List;

import com.ypeb.model.shopping.goods.Goods;

public class GoodsByFloor {
	private String floorName;
	private int id;//
	private List<Goods> goodsList=new ArrayList<>();
	private String url;
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getFloorName() {
		return floorName;
	}
	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Goods> getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}
	
	
	
}
