package com.ypeb.action.front.user;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ypeb.dataClass.front.MD5encryption;
import com.ypeb.dataClass.front.OrderGoodsShow;
import com.ypeb.model.hibernate.HibernateSessionFactory;
import com.ypeb.model.points.points.Points;
import com.ypeb.model.points.points.PointsDAO;
import com.ypeb.model.points.pointsPublish.Pointspublish;
import com.ypeb.model.points.pointsPublish.PointspublishDAO;
import com.ypeb.model.points.setting.Setting;
import com.ypeb.model.points.setting.SettingDAO;
import com.ypeb.model.shopping.goodsOrder.Order;
import com.ypeb.model.shopping.goodsOrder.OrderDAO;
import com.ypeb.model.shopping.orderGoods.Ordergoods;
import com.ypeb.model.shopping.orderGoods.OrdergoodsDAO;
import com.ypeb.model.user.address.Address;
import com.ypeb.model.user.address.AddressDAO;
import com.ypeb.model.user.award.Award;
import com.ypeb.model.user.award.AwardDAO;
import com.ypeb.model.user.bankCard.Bankcard;
import com.ypeb.model.user.bankCard.BankcardDAO;
import com.ypeb.model.user.cash.Cash;
import com.ypeb.model.user.cash.CashDAO;
import com.ypeb.model.user.message.Message;
import com.ypeb.model.user.message.MessageDAO;
import com.ypeb.model.user.user.User;
import com.ypeb.model.user.user.UserDAO;
import com.ypeb.util.Page;

public class PersonalCenterAction extends ActionSupport {

	private String destUrl;
	private User user;
	private List<Order> orderList = new ArrayList<Order>();
	private List<Ordergoods> GoodsOrderList = new ArrayList<Ordergoods>();
	private List<Address> addressList = new ArrayList<Address>();
	private List<User> userList = new ArrayList<User>();
	private List<Award> awardList = new ArrayList<Award>();
	private List<Message> messageList = new ArrayList<Message>();
	private List<OrderGoodsShow> orderGoodsShowList = new ArrayList<OrderGoodsShow>();
	private String imageUrl;
	private String orderToSend;
	private String orderSending;
	private String orderSended;
	private Address address;
	private int addressId;
	private int bankCardId;
	private Pointspublish pointsPublish;
	private String erro;
	private String passwordNew;
	private double price;
	private double num;
	private String webChat;
	private List<Bankcard> bankCardList = new ArrayList<Bankcard>();
	private Bankcard bankCard;
	private Page page;
	private int pageNum = 1;
	private int numPerPage;

	private String statusCode;// 用于返回状态码

	public String modifyPassword() {
		int userID = (Integer) ActionContext.getContext().getSession()
				.get("userID");
		User temp = new UserDAO().findById(userID);
		String password = MD5encryption.GetMD5Code(user.getPassword());
		if (password.equals(temp.getPassword())) {
			temp.setPassword(MD5encryption.GetMD5Code(passwordNew));
			Transaction tx = HibernateSessionFactory.getSession()
					.beginTransaction();
			new UserDAO().merge(temp);
			tx.commit();
			HibernateSessionFactory.getSession().close();
			erro = "修改成功";
			destUrl = "frontPage/user/personalCenter/changePassword.jsp";
			return "diyUrl";
		} else {
			erro = "密码错误";
			destUrl = "frontPage/user/personalCenter/changePassword.jsp";
			return "diyUrl";
		}

	}

	public String infoCenter() {
		int userID = (Integer) ActionContext.getContext().getSession()
				.get("userID");
		user = new UserDAO().findById(userID);
		destUrl = "frontPage/user/personalInformation.jsp";
		return "diyUrl";
	}

	public String myInfo() {
		int userID = (Integer) ActionContext.getContext().getSession()
				.get("userID");
		user = new UserDAO().findById(userID);
		destUrl = "frontPage/user/personalCenter/myInfo.jsp";
		return "diyUrl";
	}

	public String addMyInfoPre() {
		int userID = (Integer) ActionContext.getContext().getSession()
				.get("userID");
		user = new UserDAO().findById(userID);
		destUrl = "frontPage/user/personalCenter/updateMyInfo.jsp";
		return "diyUrl";
	}

	public String addMyInfo() {
		Transaction tx = HibernateSessionFactory.getSession()
				.beginTransaction();
		User temp = new UserDAO().findById(user.getId());
		System.out.println(temp.getId());
		if (temp.getIdcard() == null || temp.getIdcard() == "")
			if (user.getIdcard() != null && user.getIdcard() != "") {
				temp.setInforIsFull(true);
				temp.setIdcard(user.getIdcard());
			}
		if (user.getName() != null && user.getName() != "")
			temp.setName(user.getName());
		if (user.getProvince() != null && user.getProvince() != "")
			temp.setProvince(user.getProvince());
		if (user.getCity() != null && user.getCity() != "")
			temp.setCity(user.getCity());
		if (user.getCountry() != null && user.getCountry() != "")
			temp.setCountry(user.getCountry());
		new UserDAO().merge(temp);
		System.out.println(user.getProvince());
		System.out.println(temp.getProvince());
		tx.commit();
		HibernateSessionFactory.getSession().close();
		destUrl = "frontUser_PersonalCenter_myInfo";
		return "nextAction";
	}

	public String withdraw() {
		user = (User) ActionContext.getContext().getSession().get("user");
		if (num > user.getUsingPoints()) {

			erro = "余额不足";
			destUrl = "frontPage/user/personalCenter/error.jsp";
		} else {
			double rate = 1;
			if (new SettingDAO().findAll().size() > 0) {
				Setting setting = (Setting) new SettingDAO().findAll().get(0);
				rate = setting.getWithdrawRate();
			}
			Cash cash = new Cash();
			cash.setNum(num);
			cash.setOperate(false);
			short tem = 1;
			cash.setState(tem);
			
			cash.setRate(rate);
			cash.setWebChat(webChat);
			cash.setTime(new Timestamp(System.currentTimeMillis()));
			cash.setUserId((Integer) ActionContext.getContext().getSession()
					.get("userID"));
			Transaction tx = HibernateSessionFactory.getSession()
					.beginTransaction();
			new CashDAO().save(cash);
			tx.commit();
			HibernateSessionFactory.getSession().close();
			erro = "申请成功";
			destUrl = "frontPage/user/personalCenter/error.jsp";
		}
		return "diyUrl";
	}

	public String recharge() {
		Transaction tx;
		try {
			Cash cash = new Cash();
			cash.setNum(num);
			cash.setOperate(true);
			short tem = 1;
			cash.setState(tem);
			cash.setTime(new Timestamp(System.currentTimeMillis()));
			cash.setUserId((Integer) ActionContext.getContext().getSession()
					.get("userID"));
			tx = HibernateSessionFactory.getSession().beginTransaction();
			new CashDAO().save(cash);
			tx.commit();
			HibernateSessionFactory.getSession().close();
		} catch (Exception e) {
			e.printStackTrace();
			HibernateSessionFactory.getSession().close();
		}
		erro = "申请成功";
		destUrl = "frontPage/user/personalCenter/error.jsp";
		return "diyUrl";
	}

	public String buyPointsPre() {
		pointsPublish = new PointspublishDAO().findOrderByTime().get(0);
		price = 1;
		if (new SettingDAO().findAll().size() > 0) {
			Setting setting = (Setting) new SettingDAO().findAll().get(0);
			price = setting.getPrice();
		}
		destUrl = "frontPage/user/personalCenter/integralBuy.jsp";
		return "diyUrl";
	}

	public String buyPoints() {
		pointsPublish = new PointspublishDAO().findOrderByTime().get(0);
		user = (User) ActionContext.getContext().getSession().get("user");
		Transaction tx;
		price = 1;
		int month = 1;
		if (new SettingDAO().findAll().size() > 0) {
			Setting setting = (Setting) new SettingDAO().findAll().get(0);
			price = setting.getPrice();
			month = setting.getMonth();
		}
		user = (User) ActionContext.getContext()
				.getSession().get("user");
		
		if (num * price <= user.getCash()) {
			try {
				tx = HibernateSessionFactory.getSession().beginTransaction();
				user.setCash(user.getCash() - price * num);
				
				Points points = new Points();
				points.setPointNum(Double.valueOf(num));
				points.setIsDelete(false);
				
				pointsPublish = new PointspublishDAO().findById(pointsPublish
						.getId());
				pointsPublish.setResidue(pointsPublish.getResidue() - num);
				points.setPointspublish(pointsPublish);
				points.setState(false);
				points.setTime(new Timestamp(System.currentTimeMillis()));
			
				points.setReleasedTime(0);
				points.setUserId(user.getId());
				if (user.getStyle() == 1) {
					// 普通会员直接充值到购物积分
					user.setUsingPoints(num + user.getUsingPoints());
					points.setReleaseTime(1);
					
				} else {//商家会员放入冻结积分
					user.setIcePoints(num + user.getIcePoints());
					points.setReleaseTime(month);
				}
				new PointspublishDAO().merge(pointsPublish);//更新积分发行记录
				new UserDAO().merge(user);
				tx.commit();
				tx=HibernateSessionFactory.getSession().beginTransaction();
				
				new PointsDAO().merge(points);//更新积分售卖记录
				
				tx.commit();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				HibernateSessionFactory.getSession().close();
			}
			erro = "充值成功";
			destUrl = "frontPage/user/personalCenter/error.jsp";
		} else {
			erro = "余额不足";
			destUrl = "frontPage/user/personalCenter/error.jsp";
		}
		return "diyUrl";
	}

	public String myOrder() {
		 OrderDAO orderDao=new OrderDAO();
		 user = (User) ActionContext.getContext().getSession()
					.get("user");
			Order order = new Order();
			order.setUserId(user.getId());

			short state = 1;
			order.setState(state);
			orderToSend = orderToSend.valueOf(orderDao.findByExample(order).size());
			state = 2;
			order.setState(state);
			orderSending = orderSending.valueOf(orderDao.findByExample(order).size());
			state = 3;
			order.setState(state);
			orderSended = orderSended.valueOf(orderDao.findByExample(order).size());
			
			if (numPerPage == 0)
				numPerPage =1;
			page = new Page(pageNum, numPerPage);
			page.setTotalCount((Integer) orderDao.findCount(user.getId()));
			orderList = orderDao.findAllByPage(page,user.getId());
			
			for (Order list : orderList) {
				OrderGoodsShow temp=new OrderGoodsShow();
				temp.setOrder(list);
				temp.setOrderGoodsList( new OrdergoodsDAO().findByOrderId(list.getId()));
				orderGoodsShowList.add(temp);
			}
			destUrl = "frontPage/user/personalCenter/order.jsp";
			return "diyUrl";
		}
	
	public String addAddress() {
		int userID = (Integer) ActionContext.getContext().getSession()
				.get("userID");
		Integer uid = new Integer(userID);
		user = new UserDAO().findById(uid.intValue());
		address.setUser(user);
		address.setIsDelete(false);
		new AddressDAO().save(address);
		destUrl = "frontUser_PersonalCenter_myAddress";
		return "nextAction";
	}

	public String deleteAddress() {
		AddressDAO dao = new AddressDAO();
		address = dao.findById(addressId);
		Transaction tx = HibernateSessionFactory.getSession()
				.beginTransaction();
		address.setIsDelete(true);
		dao.merge(address);
		tx.commit();
		destUrl = "frontUser_PersonalCenter_myAddress";
		return "nextAction";
	}

	public String myAddress() {
		int userID = (Integer) ActionContext.getContext().getSession()
				.get("userID");
		user = new UserDAO().findById(userID);
		addressList = new AddressDAO().findByUser(user, false);
		destUrl = "frontPage/user/personalCenter/address.jsp";
		return "diyUrl";
	}

	/* 添加银行卡 */
	public String myBankCard() {
		int userID = (Integer) ActionContext.getContext().getSession()
				.get("userID");
		user = new UserDAO().findById(userID);
		bankCardList = new BankcardDAO().findByCard(user, false);
		destUrl = "frontPage/user/personalCenter/bankCard.jsp";
		return "diyUrl";
	}

	public String addBankCard() {
		int userID = (Integer) ActionContext.getContext().getSession()
				.get("userID");
		user = new UserDAO().findById(userID);
		bankCard.setUser(user);
		bankCard.setIsDelete(false);
		new BankcardDAO().save(bankCard);
		destUrl = "frontUser_PersonalCenter_myBankCard";
		return "nextAction";
	}

	public String deleteBankCard() {
		BankcardDAO dao = new BankcardDAO();
		bankCard = dao.findById(bankCardId);
		Transaction tx = HibernateSessionFactory.getSession()
				.beginTransaction();
		bankCard.setIsDelete(true);
		dao.merge(bankCard);
		tx.commit();
		destUrl = "frontUser_PersonalCenter_myBankCard";
		return "nextAction";
	}

	public String myAward() {
		String userID = (String) ActionContext.getContext().getSession()
				.get("userID");
		Integer uid = new Integer(userID);
		awardList = new AwardDAO().findByGetAwardId(uid.intValue());
		destUrl = "frontPage/user/personalCenter/order.jsp";
		return "diyUrl";
	}

	public String myMessage() {
		int userID = (Integer) ActionContext.getContext().getSession()
				.get("userID");
		user = new UserDAO().findById(userID);
		messageList = new MessageDAO().findByUserId(userID);
		destUrl = "frontPage/user/personalCenter/message.jsp";
		return "diyUrl";
	}

	public String myRegister() {
		/**
		 * @author jilin
		 * @date : 2017年1月17日 下午1:04:05
		 * @descripe:会员推荐注册
		 */
		int userID = (Integer) ActionContext.getContext().getSession()
				.get("userID");

		user = new UserDAO().findById(userID);

		destUrl = "frontPage/user/personalCenter/myRegister.jsp";
		return "diyUrl";
	}

	public String myRecommend() {
		/**
		 * @author jilin
		 * @date : 2017年1月17日 下午1:04:32
		 * @descripe:我的推荐注册成功记录
		 */
		int userID = (Integer) ActionContext.getContext().getSession()
				.get("userID");

		user = new UserDAO().findById(userID);
		userList = new UserDAO().findByUser(user);
		destUrl = "frontPage/user/personalCenter/myRecommend.jsp";
		return "diyUrl";
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

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public List<Award> getAwardList() {
		return awardList;
	}

	public void setAwardList(List<Award> awardList) {
		this.awardList = awardList;
	}

	public List<Message> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<Message> messageList) {
		this.messageList = messageList;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	public String getOrderToSend() {
		return orderToSend;
	}

	public void setOrderToSend(String orderToSend) {
		this.orderToSend = orderToSend;
	}

	public String getOrderSending() {
		return orderSending;
	}

	public void setOrderSending(String orderSending) {
		this.orderSending = orderSending;
	}

	public String getOrderSended() {
		return orderSended;
	}

	public void setOrderSended(String orderSended) {
		this.orderSended = orderSended;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public Pointspublish getPointsPublish() {
		return pointsPublish;
	}

	public void setPointsPublish(Pointspublish pointsPublish) {
		this.pointsPublish = pointsPublish;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public String getPasswordNew() {
		return passwordNew;
	}

	public void setPasswordNew(String passwordNew) {
		this.passwordNew = passwordNew;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getNum() {
		return num;
	}

	public void setNum(double num) {
		this.num = num;
	}

	public String getWebChat() {
		return webChat;
	}

	public void setWebChat(String webChat) {
		this.webChat = webChat;
	}

	public List<Bankcard> getBankCardList() {
		return bankCardList;
	}

	public void setBankCardList(List<Bankcard> bankCardList) {
		this.bankCardList = bankCardList;
	}

	public Bankcard getBankCard() {
		return bankCard;
	}

	public void setBankCard(Bankcard bankCard) {
		this.bankCard = bankCard;
	}

	public int getBankCardId() {
		return bankCardId;
	}

	public void setBankCardId(int bankCardId) {
		this.bankCardId = bankCardId;
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

	public List<Ordergoods> getGoodsOrderList() {
		return GoodsOrderList;
	}

	public void setGoodsOrderList(List<Ordergoods> goodsOrderList) {
		GoodsOrderList = goodsOrderList;
	}

	public List<OrderGoodsShow> getOrderGoodsShowList() {
		return orderGoodsShowList;
	}

	public void setOrderGoodsShowList(List<OrderGoodsShow> orderGoodsShowList) {
		this.orderGoodsShowList = orderGoodsShowList;
	}

	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}

}
