package com.ypeb.action.back.shopping;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ypeb.model.hibernate.HibernateSessionFactory;
import com.ypeb.model.points.points.Points;
import com.ypeb.model.points.pointsPublish.Pointspublish;
import com.ypeb.model.points.pointsPublish.PointspublishDAO;

import come.ypeb.model.manager.Manager;
import come.ypeb.model.manager.ManagerDAO;




public class PointsPublishAction extends ActionSupport {
	private Pointspublish pointspublish;
	private List<Pointspublish> pointspublishList = new ArrayList<Pointspublish>();
	private String destUrl;
	private List<Points> pointsList=new ArrayList<Points>();
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

	public String list() {
		/**
		 * @author jilin
		 * @date : 2017年1月13日 上午11:40:28
		 * @descripe:查询所有发行记录
		 */

		pointspublishList = new PointspublishDAO().findAll();
		destUrl = "backPage/points/points/list.jsp";
		return "diyUrl";
	}
	
	public String listBuyRecord(){
		
		destUrl="backPage/points/pointsBuyRecord/list.jsp";
		return "diyUrl";
	}

	public String add() {
		/**
		 * @author jilin
		 * @date : 2017年1月13日 上午11:42:04
		 * @descripe:添加一个积分发行
		 */
		try {
			ActionContext.getContext().getSession().put("managerID", "1");
			String mid=(String)ActionContext.getContext().getSession().get("managerID");
			if(mid!=null && !mid.isEmpty()){
				Integer managerID=new Integer(mid);
			
			Timestamp a=new Timestamp(System.currentTimeMillis());
			Double num=new Double("10000");

			pointspublish=new Pointspublish();
			pointspublish.setTotalNum(num);
			pointspublish.setReleaseTime(num.valueOf(releaseTime).intValue());
			pointspublish.setTime(a);
			pointspublish.setOperator(managerID.intValue());
			pointspublish.setResidue(pointspublish.getTotalNum());
			pointspublish.setState(false);
			new PointspublishDAO().save(pointspublish);
			statusCode = "200";
			message = "创建成功";
			navTabId = "pointsPublish";
			callbackType = "closeCurrent";}
			else{
				statusCode = "300";
				message = "请登录";
				navTabId = "pointsPublish";
				callbackType = "closeCurrent";
			}
		} catch (Exception e) {
			e.printStackTrace();
			statusCode = "300";
			message = "创建失败";
			navTabId = "pointspublish";
			callbackType = "closeCurrent";
		}
		return "ajaxdone";

	}
	
	public String changeType(){
		Transaction tx = null;
		try {
			tx = HibernateSessionFactory.getSession().beginTransaction();
			PointspublishDAO dao = new PointspublishDAO();
			Integer id = new Integer(uid);
			pointspublish = dao.findById(id.intValue());
			
			dao.delete(pointspublish);
			tx.commit();
			statusCode = "200";
			message = "修改成功";
			navTabId = "Pointspublish";
			callbackType = "";
			forwardUrl="";
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			statusCode = "300";
			message = "修改失败";
			navTabId = "pointspublish";
			callbackType = "";
			forwardUrl="";
		} finally {
			
			HibernateSessionFactory.getSession().close();
		}
		return "ajaxdone";
	}

	public String delete() {
		/**
		 * @author jilin
		 * @date : 2017年1月13日 上午11:42:09
		 * @descripe:删除一个栏目
		 */
		Transaction tx = null;
		try {
			tx = HibernateSessionFactory.getSession().beginTransaction();
			PointspublishDAO dao = new PointspublishDAO();
			Integer id = new Integer(uid);
			pointspublish = dao.findById(id.intValue());
			
			dao.delete(pointspublish);
			tx.commit();
			statusCode = "200";
			message = "删除成功";
			navTabId = "pointsPublish";
			callbackType = "";
			forwardUrl="";
			
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			statusCode = "300";
			message = "删除失败";
			navTabId = "pointsPublish";
			callbackType = "";
			forwardUrl="";
		} finally {
			
			HibernateSessionFactory.getSession().close();
		}
		return "ajaxdone";
	}

	public Pointspublish getPointspublish() {
		return pointspublish;
	}

	public void setPointspublish(Pointspublish pointspublish) {
		this.pointspublish = pointspublish;
	}

	public List<Pointspublish> getPointspublishList() {
		return pointspublishList;
	}

	public void setPointspublishList(List<Pointspublish> pointspublishList) {
		this.pointspublishList = pointspublishList;
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

	
	

	

}
