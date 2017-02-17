package com.ypeb.action.back.shopping;



import com.opensymphony.xwork2.ActionSupport;

import com.ypeb.model.user.address.Address;
import com.ypeb.model.user.address.AddressDAO;

public class AddressAction extends ActionSupport {
	private String id;
	private Address address = new Address();
	private String destUrl;
	// JUI JSON返回
	private String statusCode;
	private String message;
	private String navTabId;
	private String callbackType;
	private String forwardUrl;

	public String query() {
		try {
			Integer orderid = new Integer(id);
			address = new AddressDAO().findById(orderid.intValue());
		} catch (Exception e) {
			e.printStackTrace();
		}
		destUrl = "backPage/shopping/order/listAddress.jsp";
		return "diyUrl";
	
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getDestUrl() {
		return destUrl;
	}

	public void setDestUrl(String destUrl) {
		this.destUrl = destUrl;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getNavTabId() {
		return navTabId;
	}

	public void setNavTabId(String navTabId) {
		this.navTabId = navTabId;
	}

	public String getCallbackType() {
		return callbackType;
	}

	public void setCallbackType(String callbackType) {
		this.callbackType = callbackType;
	}

	public String getForwardUrl() {
		return forwardUrl;
	}

	public void setForwardUrl(String forwardUrl) {
		this.forwardUrl = forwardUrl;
	}

}
