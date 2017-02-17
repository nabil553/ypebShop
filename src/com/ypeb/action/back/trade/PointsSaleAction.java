package com.ypeb.action.back.trade;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.ypeb.dataClass.front.QueryCondition;
import com.ypeb.model.trade.pointsSale.Pointssale;
import com.ypeb.model.trade.pointsSale.PointssaleDAO;
import com.ypeb.util.Page;

public class PointsSaleAction extends ActionSupport {
	private String destUrl;
	private int totalSale;// 现在平台挂卖的积分总量
	private List<Pointssale> pointsSaleList;
	private String telephone;

	// JUI JSON返回
	private String statusCode;
	private String message;
	private String navTabId;
	private String callbackType;
	private String forwardUrl;

	// 隐藏表单

	private String orderDirection="asc";
	private String orderField="time";
	private Page page;
	
	//综合查询条件
	
	Pointssale pointsSale;

	public String comprehensiveQuery() {
		/**
		 * @author jilin
		 * @date : 2017年1月10日 下午12:28:26
		 * @descripe: 综合查询
		 */
		QueryCondition queryCondition=new QueryCondition();// 排序条件
		if (orderField != null && orderDirection != "") {
			queryCondition.setOrderField(orderField);
		}
		if (orderDirection != null && orderDirection != "") {
			queryCondition.setOrderDirection(orderDirection);
		}
		
		pointsSale.setSelectAll(true);

		pointsSaleList = new PointssaleDAO().comprehensiveQuery(pointsSale,
				queryCondition);
		
		totalSale = new PointssaleDAO().totalSalePoints();
		destUrl = "backPage/trade/saleInfo.jsp";
		return "diyUrl";
	}

	public String saleInfo() {
		/**
		 * @author jilin
		 * @date : 2017年1月9日 下午6:57:47
		 * @descripe: 1.挂卖积分剩余总量
		 * 
		 */

		totalSale = new PointssaleDAO().totalSalePoints();
		destUrl = "backPage/trade/saleInfo.jsp";

		return "diyUrl";
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getOrderDirection() {
		return orderDirection;
	}

	public void setOrderDirection(String orderDirection) {
		this.orderDirection = orderDirection;
	}

	public String getOrderField() {
		return orderField;
	}

	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<Pointssale> getPointsSaleList() {
		return pointsSaleList;
	}

	public void setPointsSaleList(List<Pointssale> pointsSaleList) {
		this.pointsSaleList = pointsSaleList;
	}

	

	public String getDestUrl() {
		return destUrl;
	}

	public void setDestUrl(String destUrl) {
		this.destUrl = destUrl;
	}

	public int getTotalSale() {
		return totalSale;
	}

	public void setTotalSale(int totalSale) {
		this.totalSale = totalSale;
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



	public Pointssale getPointsSale() {
		return pointsSale;
	}

	public void setPointsSale(Pointssale pointsSale) {
		this.pointsSale = pointsSale;
	}
	

}
