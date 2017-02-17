package com.ypeb.action.front.shopping;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ypeb.dataClass.front.CategoryByLevel;
import com.ypeb.dataClass.front.GoodsByFloor;
import com.ypeb.model.shopping.advertisement.Advertisement;
import com.ypeb.model.shopping.advertisement.AdvertisementDAO;
import com.ypeb.model.shopping.announcement.Announcement;
import com.ypeb.model.shopping.announcement.AnnouncementDAO;
import com.ypeb.model.shopping.goods.Goods;
import com.ypeb.model.shopping.goods.GoodsDAO;
import com.ypeb.model.shopping.goodsCategory.Goodscategory;
import com.ypeb.model.shopping.goodsCategory.GoodscategoryDAO;
import com.ypeb.model.shopping.roll.Roll;
import com.ypeb.model.shopping.roll.RollDAO;
import com.ypeb.model.shopping.shoppingCar.ShoppingcarDAO;
import com.ypeb.model.user.user.UserDAO;
import com.ypeb.util.Page;

public class IndexAction extends ActionSupport {
	/**
	 * @author jilin
	 * @date : 2017年1月11日 下午2:57:57
	 * @descripe:商城首页使用的action
	 */
	private List<Goodscategory> firstCategoryList = new ArrayList<Goodscategory>();
	private ArrayList<List<Goodscategory>> secondCategoryList = new ArrayList<List<Goodscategory>>();
	private List<Goodscategory> floorCategoryList = new ArrayList<Goodscategory>();
	private List<GoodsByFloor> goodsList = new ArrayList<GoodsByFloor>();
	private List<Roll> rollList;
	private List<Advertisement> advertList;// 封装广告
	private List<Announcement> announList;
	private String announID;
	private Announcement announcement;
	private String goodsID;// 商品ID，用来查询商品详情
	private Goods goods;
	private ArrayList<CategoryByLevel> categoryByLevel = new ArrayList<CategoryByLevel>();
	private String shoppingCarNum = "0";// 购物车数量
	private String userName;

	private String destUrl;

	public String indexData() {
		String userName = (String) ActionContext.getContext().getSession()
				.get("userName");

		if (userName != null && !userName.isEmpty()) {
			int id = (Integer) ActionContext.getContext().getSession()
					.get("userID");
			Integer uid = new Integer(id);
			shoppingCarNum = shoppingCarNum.valueOf((new ShoppingcarDAO()
					.findByUserId(uid.intValue())).size());
		}
		GoodscategoryDAO categoryDao = new GoodscategoryDAO();
		short level = 1;
		Goodscategory temp = new Goodscategory();
		temp.setLevel(level);
		temp.setIsDelete(false);
		firstCategoryList = categoryDao.findByExample(temp);
		for (Goodscategory first : firstCategoryList) {
			Goodscategory category = new Goodscategory();
			CategoryByLevel cate = new CategoryByLevel();
			cate.setId(first.getId());
			cate.setName(first.getName());
			category.setSuperId(first.getId());
			category.setIsDelete(false);
			
			cate.setSecCategoryList(categoryDao.findByExample(category));
			categoryByLevel.add(cate);
		}
		destUrl = "frontPage/index.jsp";
		return "diyUrl";
	}

	public String bodyData() {
		/**
		 * @author jilin
		 * @date : 2017年1月11日 下午3:08:31
		 * @descripe:进入首页使用的方法
		 */

		GoodscategoryDAO categoryDao = new GoodscategoryDAO();
		GoodsDAO goodsDao = new GoodsDAO();
		short level = 1;
		Goodscategory categoryTem = new Goodscategory();
		categoryTem.setLevel(level);
		categoryTem.setIsDelete(false);
		firstCategoryList = categoryDao.findByExample(categoryTem);
		level = 2;

		for (Goodscategory first : firstCategoryList) {
			categoryTem = null;
			categoryTem = new Goodscategory();
			Goodscategory category = new Goodscategory();
			CategoryByLevel cate = new CategoryByLevel();
			cate.setId(first.getId());
			cate.setName(first.getName());
			category.setSuperId(first.getId());
			categoryTem.setSuperId(first.getId());
			categoryTem.setIsDelete(false);
			cate.setSecCategoryList(categoryDao.findByExample(categoryTem));
			categoryByLevel.add(cate);// 1级栏目下面所有的二级栏目
		}
		categoryTem = null;
		categoryTem = new Goodscategory();
		categoryTem.setIsDelete(false);
		categoryTem.setIsFloor(true);
		floorCategoryList = categoryDao.findByExample(categoryTem);

		for (int i = 0; i < floorCategoryList.size(); i++) {
			// 先判断楼层栏目是不是有足够的8个商品，不足8个商品就只查出来有的

			Goods goodsTemp = new Goods();
			goodsTemp.setGoodscategory(floorCategoryList.get(i));
			// goodsTemp.setSecondCateg(floorCategoryList.get(i).getId());
			goodsTemp.setIsShow(true);
			goodsTemp.setIsDelete(false);
			List<Goods> goodsOneFloor = null;
			goodsOneFloor = new ArrayList<Goods>();
			Page page=new Page();
			page.setTotalCount(8);
			page.setEveryPage(8);
			goodsOneFloor=goodsDao.findByCategory1Index(goodsTemp.getGoodscategory(), page);
			//goodsOneFloor = goodsDao.findByExample(goodsTemp);
			int goodsNumInCateg = goodsOneFloor.size();
			GoodsByFloor goodsByFloor = null;
			goodsByFloor = new GoodsByFloor();
			goodsByFloor.setFloorName(floorCategoryList.get(i).getName());
			goodsByFloor.setId(floorCategoryList.get(i).getId());
			goodsByFloor.setUrl(floorCategoryList.get(i).getUrl());
			
			for (int j = 0; j < (goodsNumInCateg >= 8 ? 8 : goodsNumInCateg); j++) {
				// 封装商品到楼层中
				goodsByFloor.getGoodsList().add(goodsOneFloor.get(j));
			}

			goodsList.add(goodsByFloor);

		}
		rollList = new RollDAO().findAll();
		advertList = new AdvertisementDAO().findByType(0);
		announList = new AnnouncementDAO().findIndexAnnoun();

		destUrl = "frontPage/body.jsp";
		return "diyUrl";
	}

	public String moreAnnouncement() {
		/**
		 * @author jilin
		 * @date : 2017年1月12日 下午2:28:55
		 * @descripe:公告信息，点击“更多按钮处理方法”
		 */
		announList = new AnnouncementDAO().findAll();
		destUrl = "";
		return "diyUrl";
	}

	public String findAnnouncement() {
		/**
		 * @author jilin
		 * @date : 2017年1月12日 下午2:29:21
		 * @descripe:查询公告详细内容
		 */
		Integer id = new Integer(announID);
		announcement = new AnnouncementDAO().findById(id.intValue());
		destUrl = "";
		return "diyUrl";
	}

	public String queryGoods() {
		/**
		 * @author jilin
		 * @date : 2017年1月12日 下午2:33:03
		 * @descripe:根据传来的goodsID跳转到商品的详情页面
		 */
		Integer id = new Integer(goodsID);
		goods = new GoodsDAO().findById(id.intValue());
		destUrl = "";
		return "diyUrl";
	}

	public List<Goodscategory> getFloorCategoryList() {
		return floorCategoryList;
	}

	public void setFloorCategoryList(List<Goodscategory> floorCategoryList) {
		this.floorCategoryList = floorCategoryList;
	}

	public String getDestUrl() {
		return destUrl;
	}

	public void setDestUrl(String destUrl) {
		this.destUrl = destUrl;
	}

	public List<Roll> getRollList() {
		return rollList;
	}

	public void setRollList(List<Roll> rollList) {
		this.rollList = rollList;
	}

	public List<Advertisement> getAdvertList() {
		return advertList;
	}

	public void setAdvertList(List<Advertisement> advertList) {
		this.advertList = advertList;
	}

	public List<Announcement> getAnnounList() {
		return announList;
	}

	public Announcement getAnnouncement() {
		return announcement;
	}

	public void setAnnouncement(Announcement announcement) {
		this.announcement = announcement;
	}

	public void setAnnounList(List<Announcement> announList) {
		this.announList = announList;
	}

	public String getAnnounID() {
		return announID;
	}

	public void setAnnounID(String announID) {
		this.announID = announID;
	}

	public String getGoodsID() {
		return goodsID;
	}

	public void setGoodsID(String goodsID) {
		this.goodsID = goodsID;
	}

	public List<Goodscategory> getFirstCategoryList() {
		return firstCategoryList;
	}

	public void setFirstCategoryList(List<Goodscategory> firstCategoryList) {
		this.firstCategoryList = firstCategoryList;
	}

	public ArrayList<List<Goodscategory>> getSecondCategoryList() {
		return secondCategoryList;
	}

	public void setSecondCategoryList(
			ArrayList<List<Goodscategory>> secondCategoryList) {
		this.secondCategoryList = secondCategoryList;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public ArrayList<CategoryByLevel> getCategoryByLevel() {
		return categoryByLevel;
	}

	public void setCategoryByLevel(ArrayList<CategoryByLevel> categoryByLevel) {
		this.categoryByLevel = categoryByLevel;
	}

	public String getShoppingCarNum() {
		return shoppingCarNum;
	}

	public void setShoppingCarNum(String shoppingCarNum) {
		this.shoppingCarNum = shoppingCarNum;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<GoodsByFloor> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<GoodsByFloor> goodsList) {
		this.goodsList = goodsList;
	}

}
