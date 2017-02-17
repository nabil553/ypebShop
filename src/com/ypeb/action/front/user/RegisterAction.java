package com.ypeb.action.front.user;

import com.opensymphony.xwork2.ActionSupport;
import com.ypeb.model.user.user.User;

public class RegisterAction extends ActionSupport {

	private String destUrl;
	private User user;
	private String message;
	private User name;
	private User password;
	private User province;
	private User city;
	private User country;
	
	public String simpleRegister(){
		
		destUrl = "frontShopping_Index_indexData";
		return "nextAction";
	}
	
	public String getDestUrl() {
		return destUrl;
	}
	public void setDestUrl(String destUrl) {
		this.destUrl = destUrl;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public User getName() {
		return name;
	}

	public void setName(User name) {
		this.name = name;
	}

	public User getPassword() {
		return password;
	}

	public void setPassword(User password) {
		this.password = password;
	}

	public User getProvince() {
		return province;
	}

	public void setProvince(User province) {
		this.province = province;
	}

	public User getCity() {
		return city;
	}

	public void setCity(User city) {
		this.city = city;
	}

	public User getCountry() {
		return country;
	}

	public void setCountry(User country) {
		this.country = country;
	}
	
}
