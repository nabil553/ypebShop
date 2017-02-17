package com.ypeb.action.back.shopping;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;
import com.ypeb.model.hibernate.HibernateSessionFactory;
import com.ypeb.model.shopping.announcement.Announcement;
import com.ypeb.model.shopping.announcement.AnnouncementDAO;
import com.ypeb.util.Page;

import come.ypeb.model.manager.ManagerDAO;



public class AnnouncementAction extends ActionSupport {
	private Announcement announcement;
	private List<Announcement> announcementList = new ArrayList<Announcement>();
	private String destUrl;
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
		 * @descripe:查询所有广告
		 */
		ManagerDAO dao = new ManagerDAO();

		if (numPerPage == 0)
			numPerPage = 17;

		page = new Page(pageNum, numPerPage);

		page.setTotalCount((Integer) dao.findCount());
		announcementList = new AnnouncementDAO().findAllByPage(page);
		destUrl = "backPage/shopping/page/announcement/list.jsp";
		return "diyUrl";
	}

	public String add() {
		/**
		 * @author jilin
		 * @date : 2017年1月13日 上午11:42:04
		 * @descripe:添加一个栏目
		 */
		try {
			Timestamp a=new Timestamp(System.currentTimeMillis());
			announcement.setTime(a);
			new AnnouncementDAO().save(announcement);
			statusCode = "200";
			message = "创建成功";
			navTabId = "announcement";
			callbackType = "closeCurrent";
		} catch (Exception e) {
			e.printStackTrace();
			statusCode = "300";
			message = "创建失败";
			navTabId = "announcement";
			callbackType = "closeCurrent";
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
			AnnouncementDAO dao = new AnnouncementDAO();
			Integer id = new Integer(uid);
			announcement = dao.findById(id.intValue());
			
			dao.delete(announcement);
			statusCode = "200";
			message = "删除成功";
			navTabId = "announcement";
			callbackType = "";
			forwardUrl="";
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			statusCode = "300";
			message = "删除失败";
			navTabId = "announcement";
			callbackType = "closeCurrent";
			forwardUrl="";
		} finally {
			tx.commit();
			HibernateSessionFactory.getSession().close();
		}
		return "ajaxdone";
	}

	public Announcement getAnnouncement() {
		return announcement;
	}

	public void setAnnouncement(Announcement announcement) {
		this.announcement = announcement;
	}

	public List<Announcement> getAnnouncementList() {
		return announcementList;
	}

	public void setAnnouncementList(List<Announcement> announcementList) {
		this.announcementList = announcementList;
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

	

	

	

}
