package com.ypeb.dataClass.front;

import java.util.ArrayList;
import java.util.List;

import com.ypeb.model.shopping.goodsCategory.Goodscategory;

public class CategoryByLevel {
	private int id;//一级栏目的ID
	private String name;//一级栏目名
	private List<Goodscategory> secCategoryList=new ArrayList<Goodscategory>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Goodscategory> getSecCategoryList() {
		return secCategoryList;
	}
	public void setSecCategoryList(List<Goodscategory> secCategoryList) {
		this.secCategoryList = secCategoryList;
	}

	
	
	

}
