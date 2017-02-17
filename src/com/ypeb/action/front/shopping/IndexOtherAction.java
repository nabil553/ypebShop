package com.ypeb.action.front.shopping;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ypeb.model.shopping.advertisement.Advertisement;
import com.ypeb.model.shopping.advertisement.AdvertisementDAO;
import com.ypeb.model.shopping.announcement.Announcement;
import com.ypeb.model.shopping.announcement.AnnouncementDAO;
import com.ypeb.model.shopping.goods.Goods;
import com.ypeb.model.shopping.goods.GoodsDAO;
import com.ypeb.model.shopping.goodsCategory.Goodscategory;
import com.ypeb.model.shopping.goodsCategory.GoodscategoryDAO;
import com.ypeb.util.Page;


public class IndexOtherAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private Announcement announcement;
	private List<Announcement> announcementList;
	private Page page;
	private int pageNum = 1;
	private int numPerPage;
	private List<Advertisement> adList ;
	private String destUrl;
	private List<Goods> goodsList;
	private String name;
	private Goodscategory category;
	private int categoryID;
	private List<Goodscategory> categoryList;
	private String category1Name;
	
	public String queryAnnoun(){
		Integer uid=new Integer(id);
		announcement=new AnnouncementDAO().findById(uid.intValue());
		adList=new AdvertisementDAO().findByType(1);
		destUrl="frontPage/shopping/dispAnnouncement.jsp";
		return "diyUrl";
	}
	
	public String queryListAnnoun(){
		AnnouncementDAO dao=new AnnouncementDAO();
		if (numPerPage == 0)
			numPerPage = 10;
		page = new Page(pageNum, numPerPage);
		page.setTotalCount((Integer) dao.findCount());
		announcementList = dao.findAllByPage(page);
		adList=new AdvertisementDAO().findByType(1);
		destUrl="frontPage/shopping/listAnnouncement.jsp";
		return "diyUrl";
	}
	
	public String queryLike(){
		if(name==null)
			name=(String)ActionContext.getContext().getSession().get("name");
		ActionContext.getContext().getSession().put("name", name);
		GoodsDAO dao = new GoodsDAO();
		if (numPerPage == 0)
			numPerPage = 16;
		page = new Page(pageNum, numPerPage);
		page.setTotalCount((Integer) dao.findCount(name));
		System.out.println(page.getTotalCount());
		System.out.println(page.getTotalPage());
		goodsList = dao.findByLikeName(page, name);
		adList=new AdvertisementDAO().findByType(1);
		destUrl="frontPage/shopping/query.jsp";
		return "diyUrl";
	}
	
	public String queryByOneMenu(){
		if(categoryID==0)
			 categoryID=(Integer)ActionContext.getContext().getSession().get("categoryID");
		ActionContext.getContext().getSession().put("categoryID", categoryID);
		GoodsDAO dao = new GoodsDAO();
		if (numPerPage == 0)
			numPerPage = 16;
		page = new Page(pageNum, numPerPage);
		page.setTotalCount((Integer) dao.findCount());
		category=new GoodscategoryDAO().findById(categoryID);
		goodsList = dao.findByCategory1(category, page);
		Goodscategory temp=new Goodscategory();
		temp.setSuperId(categoryID);
		temp.setIsDelete(false);
		categoryList =new GoodscategoryDAO().findByExample(temp);
		adList=new AdvertisementDAO().findByType(1);
		destUrl="frontPage/shopping/queryByOneMenu.jsp";
		return "diyUrl";
	}
	
	public String queryByTwoMenu(){
		if(categoryID==0)
			 categoryID=(Integer)ActionContext.getContext().getSession().get("categoryID");
		ActionContext.getContext().getSession().put("categoryID", categoryID);
		GoodsDAO dao = new GoodsDAO();
		if (numPerPage == 0)
			numPerPage = 16;
		
		
	
		
		page = new Page(pageNum, numPerPage);
		page.setTotalCount((Integer) dao.findCount());
		category=new GoodscategoryDAO().findById(categoryID);
		
		Goodscategory temp=new GoodscategoryDAO().findById(category.getSuperId());
		category1Name=temp.getName();
		
		goodsList = dao.findByCategory2Id(categoryID, page);
		
		adList=new AdvertisementDAO().findByType(1);
		destUrl="frontPage/shopping/queryByTwoMenu.jsp";
		return "diyUrl";
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Announcement getAnnouncement() {
		return announcement;
	}

	public void setAnnouncement(Announcement announcement) {
		this.announcement = announcement;
	}

	public String getDestUrl() {
		return destUrl;
	}

	public void setDestUrl(String destUrl) {
		this.destUrl = destUrl;
	}
	
	public List<Announcement> getAnnouncementList() {
		return announcementList;
	}

	public void setAnnouncementList(List<Announcement> announcementList) {
		this.announcementList = announcementList;
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

	public List<Advertisement> getAdList() {
		return adList;
	}

	public void setAdList(List<Advertisement> adList) {
		this.adList = adList;
	}

	public List<Goods> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Goodscategory getCategory() {
		return category;
	}

	public void setCategory(Goodscategory category) {
		this.category = category;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public List<Goodscategory> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Goodscategory> categoryList) {
		this.categoryList = categoryList;
	}

	public String getCategory1Name() {
		return category1Name;
	}

	public void setCategory1Name(String category1Name) {
		this.category1Name = category1Name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
