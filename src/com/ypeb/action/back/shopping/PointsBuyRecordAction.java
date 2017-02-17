package com.ypeb.action.back.shopping;


import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.ypeb.dataClass.front.PointsUserRecord;
import com.ypeb.model.points.points.Points;
import com.ypeb.model.points.points.PointsDAO;
import com.ypeb.model.user.user.UserDAO;
import com.ypeb.util.Page;




public class PointsBuyRecordAction extends ActionSupport {
	private Points points;

	private String destUrl;
	private List<Points> pointsList=new ArrayList<Points>();
	private List<PointsUserRecord> pointsUserRecord=new ArrayList<PointsUserRecord>();
	private String totalNum;
	private String releaseTime;
	// JUI JSON返回
	private String statusCode;
	private String message;
	private String navTabId;
	private String callbackType;
	private String forwardUrl;
	

	private String uid;
	private String goodsID;
	private String id;
	private Page page;

	private int pageNum = 1;// dwz分页使用
	private int numPerPage;

	public String list() {
		/**
		 * @author jilin
		 * @date : 2017年1月13日 上午11:40:28
		 * @descripe:查询所有发行记录
		 */
		try{
		PointsDAO dao=new PointsDAO();
		UserDAO udao=new UserDAO();
		if (numPerPage == 0)
			numPerPage = 17;	
		page = new Page(pageNum, numPerPage);
		page.setTotalCount((Integer) dao.findCount());
		pointsList = dao.findAllByPage(page);
		for(Points list:pointsList){
			PointsUserRecord temp=new PointsUserRecord();
			temp.setPoints(list);
			temp.setTelephone(udao.findById(list.getUserId()).getTelephone());
			pointsUserRecord.add(temp);
			
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		destUrl = "backPage/points/pointsBuyRecord/list.jsp";
		return "diyUrl";
	}
	
	public String listBuyRecord(){
		
		destUrl="backPage/points/pointsBuyRecord/list.jsp";
		return "diyUrl";
	}

	public Points getPoints() {
		return points;
	}

	public void setPoints(Points points) {
		this.points = points;
	}

	public String getDestUrl() {
		return destUrl;
	}

	public void setDestUrl(String destUrl) {
		this.destUrl = destUrl;
	}

	public List<Points> getPointsList() {
		return pointsList;
	}

	public void setPointsList(List<Points> pointsList) {
		this.pointsList = pointsList;
	}

	public String getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(String totalNum) {
		this.totalNum = totalNum;
	}

	public String getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
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

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getGoodsID() {
		return goodsID;
	}

	public void setGoodsID(String goodsID) {
		this.goodsID = goodsID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}

	public List<PointsUserRecord> getPointsUserRecord() {
		return pointsUserRecord;
	}

	public void setPointsUserRecord(List<PointsUserRecord> pointsUserRecord) {
		this.pointsUserRecord = pointsUserRecord;
	}

	
	
	

	

	
	

	

}
