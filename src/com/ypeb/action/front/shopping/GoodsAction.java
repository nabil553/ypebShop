package com.ypeb.action.front.shopping;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ypeb.dataClass.front.CarGoodsName;
import com.ypeb.model.hibernate.HibernateSessionFactory;
import com.ypeb.model.points.setting.Setting;
import com.ypeb.model.points.setting.SettingDAO;
import com.ypeb.model.shopping.advertisement.Advertisement;
import com.ypeb.model.shopping.advertisement.AdvertisementDAO;
import com.ypeb.model.shopping.goods.Goods;
import com.ypeb.model.shopping.goods.GoodsDAO;
import com.ypeb.model.shopping.goodsCategory.GoodscategoryDAO;
import com.ypeb.model.shopping.goodsOrder.Order;
import com.ypeb.model.shopping.goodsOrder.OrderDAO;
import com.ypeb.model.shopping.orderGoods.Ordergoods;
import com.ypeb.model.shopping.orderGoods.OrdergoodsDAO;
import com.ypeb.model.shopping.shoppingCar.Shoppingcar;
import com.ypeb.model.shopping.shoppingCar.ShoppingcarDAO;
import com.ypeb.model.user.address.Address;
import com.ypeb.model.user.address.AddressDAO;
import com.ypeb.model.user.user.User;
import com.ypeb.model.user.user.UserDAO;

public class GoodsAction extends ActionSupport {
	private int id;
	private Goods goods;
	private List<GoodsAction> goodsList = new ArrayList<GoodsAction>();
	private List<Advertisement> adList = new ArrayList<Advertisement>();
	private String secondName;
	private Order order;
	private List<Address> addressList = new ArrayList<Address>();
	private Address address;
	private String num;
	private double pointsPrice;// 计算的对应的积分价格（总价）
	private List<Shoppingcar> carList = new ArrayList<Shoppingcar>();
	private List<CarGoodsName> shopCarList = new ArrayList<CarGoodsName>();

	private String shopID;
	private String shopCarNum;
	private String statusCode;
	private String destUrl;
	private String erro;
	private List<Integer> check_goods;
	private List<Integer> goodssum;

	public String payPre() {
		goods = new Goods();
		goods = new GoodsDAO().findById(id);
		int userID = (Integer) ActionContext.getContext().getSession()
				.get("userID");

		User user = new User();
		order = new Order();
		user = new UserDAO().findById(userID);
		order.setGoodsId(id);
		short tem = 0;
		order.setState(tem);
		if (user.getStyle() == 2) {
			order.setUnitPrice(goods.getDiscountPrice());
			order.setStyle(true);
		} else {
			order.setUnitPrice(goods.getPrice());
			order.setStyle(false);
		}
		tem = Integer.valueOf(num).shortValue();
		order.setNum(tem);
		order.setTotalprice(order.getUnitPrice() * order.getNum());
		double price = 1;
		if (new SettingDAO().findAll().size() > 0) {
			Setting setting = (Setting) new SettingDAO().findAll().get(0);
			price = setting.getPrice();
		}

		pointsPrice = order.getTotalprice() * price;

		addressList = new AddressDAO().findByUser(user, false);
		/* ActionContext.getContext().getSession().put("order", order); */
		destUrl = "frontPage/shopping/pay.jsp";
		return "diyUrl";
	}

	public String pay() {
		// 先检查余额是否够了
		int userID = (Integer) ActionContext.getContext().getSession()
				.get("userID");

		User user = new User();
		user = new UserDAO().findById(userID);

		if (pointsPrice <= user.getUsingPoints()) {

			Transaction tx = null;
			try {

				order.setOrderCode(String.valueOf(System.currentTimeMillis()));
				order.setTime(new Timestamp(System.currentTimeMillis()));
				order.setUserId(userID);
				short temp = 1;
				order.setState(temp);
				goods = new GoodsDAO().findById(order.getGoodsId());

				double price = 1;
				if (new SettingDAO().findAll().size() > 0) {
					Setting setting = (Setting) new SettingDAO().findAll().get(
							0);
					price = setting.getPrice();
				}
				if (user.getStyle() == 2) {
					order.setUnitPrice(goods.getDiscountPrice());
					order.setStyle(true);
				} else {
					order.setUnitPrice(goods.getPrice());
					order.setStyle(false);
				}
				tx = HibernateSessionFactory.getSession().beginTransaction();
				order.setTotalprice(pointsPrice);
				order.setReleaseState(false);

				new OrderDAO().save(order);
				Ordergoods ordergoods = new Ordergoods();
				ordergoods.setGoodsId(goods.getId());
				ordergoods.setGoodsImage(goods.getImageUrl1());
				ordergoods.setGoodsName(goods.getName());
				ordergoods.setNum(order.getNum().intValue());
				ordergoods.setOrderId(order.getId());
				ordergoods.setUnitPrice(order.getUnitPrice());
				ordergoods.setTotalPrice(order.getTotalprice());
				new OrdergoodsDAO().merge(ordergoods);
				user.setUsingPoints(user.getUsingPoints()
						- order.getTotalprice());
				new UserDAO().merge(user);

				tx.commit();

				HibernateSessionFactory.getSession().close();
				destUrl = "frontPage/shopping/payComplete.jsp";
			} catch (Exception e) {

				e.printStackTrace();
				erro = "支付失败";
				destUrl = "frontPage/shopping/payFail.jsp";
			}
		} else {
			destUrl = "frontPage/shopping/payFail.jsp";
			erro = "余额不足";
		}

		return "diyUrl";
	}

	public String payShopCar() {

	int userID = (Integer) ActionContext.getContext().getSession()
				.get("userID");

		User user = new User();
		user = new UserDAO().findById(userID);
		double price = 1;
		int size=new SettingDAO().findAll().size();
		if ( size> 0) {
			Setting setting = (Setting) new SettingDAO().findAll().get(
					0);
			price = setting.getPrice();
		}
		if (pointsPrice <= user.getUsingPoints()*price) {
			
			order.setTime(new Timestamp(System.currentTimeMillis()));
			order.setOrderCode(String.valueOf(System.currentTimeMillis()));
			order.setUserId(userID);
			short temp = 1;
			order.setState(temp);
			if(user.getStyle()==1)
				order.setStyle(false);
			else
				order.setStyle(true);
			order.setReleaseState(false);
			order.setTotalprice(pointsPrice*price);
			Transaction tx=HibernateSessionFactory.getSession().beginTransaction();
			user.setUsingPoints(user.getUsingPoints()-order.getTotalprice());
			new UserDAO().merge(user);
			new OrderDAO().save(order);
		
			tx.commit();
			HibernateSessionFactory.getSession().flush();
			HibernateSessionFactory.getSession().close();
			carList = new ShoppingcarDAO().findByUserId(userID);
			for (Integer list : check_goods) {				
				for (int i = 0; i < goodssum.size(); i++) {
					if (list.intValue() == i) {
						tx=HibernateSessionFactory.getSession().beginTransaction();
						Ordergoods t=new Ordergoods();
						t.setGoodsId(carList.get(i).getGoodsId());
						Goods goodsTemp=new GoodsDAO().findById(t.getGoodsId());
						t.setGoodsName(goodsTemp.getName());
						t.setGoodsImage(goodsTemp.getImageUrl1());
						t.setNum(goodssum.get(i));
					
						t.setOrderId(order.getId());
						t.setUnitPrice(goodsTemp.getPrice());
						t.setTotalPrice(t.getUnitPrice()*t.getNum());
						new OrdergoodsDAO().save(t);
						
						ShoppingcarDAO dao = new ShoppingcarDAO();
						Shoppingcar te = dao.findById(carList.get(i).getId());
						dao.delete(te);
						tx.commit();
						
						HibernateSessionFactory.getSession().flush();
						HibernateSessionFactory.getSession().close();
					}
					

				}

			}
		}
		destUrl = "frontPage/shopping/payComplete.jsp";
		return "diyUrl";
	}

	public String deleteShopCar() {

		Transaction tx = null;
		try {
			tx = HibernateSessionFactory.getSession().beginTransaction();
			ShoppingcarDAO dao = new ShoppingcarDAO();
			Shoppingcar temp = dao.findById(id);
			dao.delete(temp);
			tx.commit();
		} catch (Exception e) {
			HibernateSessionFactory.getSession().close();
			e.printStackTrace();
		}
		destUrl = "frontShopping_Goods_listCar";
		return "nextAction";
	}

	public String listCar() {
		int userID = (Integer) ActionContext.getContext().getSession()
				.get("userID");
		User user = new UserDAO().findById(userID);
		addressList = new AddressDAO().findByUser(user, false);
		carList = new ShoppingcarDAO().findByUserId(userID);
		/*
		 * for(int i=0;i<carList.size();i++){ CarGoodsName temp=new
		 * CarGoodsName(); Goods tem=null; tem=new
		 * GoodsDAO().findById(carList.get(i).getGoodsId()); String name=new
		 * String(); name=tem.getName(); temp.setName(name); tem=null;
		 * temp.setCar(carList.get(i)); }
		 */

		for (Shoppingcar list : carList) {
			CarGoodsName temp = new CarGoodsName();
			temp.setCar(list);
			GoodsDAO dao = new GoodsDAO();
			int id = list.getGoodsId();
			Goods tem = new Goods();
			tem = dao.findById(id);

			tem = new Goods();

			tem = dao.findById(id);

			String name = tem.getName();
			Double price = tem.getPrice();
			temp.setImage(tem.getImageUrl1());
			temp.setName(name);
			temp.setPrice(price);
			shopCarList.add(temp);
		}
		destUrl = "frontPage/shopping/shoppingCar.jsp";
		return "diyUrl";
	}

	public String queryGoods() {

		goods = new GoodsDAO().findById(id);
		adList = new AdvertisementDAO().findByType(1);
		secondName = new GoodscategoryDAO().findById(goods.getCategory2())
				.getName();
		destUrl = "frontPage/shopping/detail.jsp";
		return "diyUrl";
	}

	public String comprehensiveQuery() {
		destUrl = "frontPage/shopping/list.jsp";
		return "diyUrl";
	}

	public String addShoppingCar() {
		int m = (Integer) ActionContext.getContext().getSession()
				.get("userID");
		Integer userID = new Integer(m);
		if (m != 0 && m!=' ') {
			statusCode = "200";
			Shoppingcar shopCar = new Shoppingcar();
			Integer mn = new Integer(shopID);
			shopCar.setGoodsId(mn.intValue());
			shopCar.setUserId(userID.intValue());
			if ((new ShoppingcarDAO().findByExample(shopCar).size() == 0)) {
				shopCar.setNum(1);
				new ShoppingcarDAO().save(shopCar);
			}
			int num = new ShoppingcarDAO().findByUserId(userID.intValue())
					.size();
			shopCarNum = "" + num;
		} else {
			shopCarNum = "" + 0;
			statusCode = "300";
		}
		return "ajaxdone";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public List<GoodsAction> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<GoodsAction> goodsList) {
		this.goodsList = goodsList;
	}

	public String getShopCarNum() {
		return shopCarNum;
	}

	public void setShopCarNum(String shopCarNum) {
		this.shopCarNum = shopCarNum;
	}

	public String getShopID() {
		return shopID;
	}

	public void setShopID(String shopID) {
		this.shopID = shopID;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getDestUrl() {
		return destUrl;
	}

	public void setDestUrl(String destUrl) {
		this.destUrl = destUrl;
	}

	public List<Advertisement> getAdList() {
		return adList;
	}

	public void setAdList(List<Advertisement> adList) {
		this.adList = adList;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public double getPointsPrice() {
		return pointsPrice;
	}

	public void setPointsPrice(double pointsPrice) {
		this.pointsPrice = pointsPrice;
	}

	public List<Shoppingcar> getCarList() {
		return carList;
	}

	public void setCarList(List<Shoppingcar> carList) {
		this.carList = carList;
	}

	public List<CarGoodsName> getShopCarList() {
		return shopCarList;
	}

	public void setShopCarList(List<CarGoodsName> shopCarList) {
		this.shopCarList = shopCarList;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public List<Integer> getCheck_goods() {
		return check_goods;
	}

	public void setCheck_goods(List<Integer> check_goods) {
		this.check_goods = check_goods;
	}

	public List<Integer> getGoodssum() {
		return goodssum;
	}

	public void setGoodssum(List<Integer> goodssum) {
		this.goodssum = goodssum;
	}

}
