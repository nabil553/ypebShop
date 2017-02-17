package com.ypeb.dataClass.front;

import com.opensymphony.xwork2.ActionSupport;
import com.ypeb.model.user.message.Message;

public class MessageShow extends ActionSupport {
	
	private Message message;
	private String userName;
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

}
