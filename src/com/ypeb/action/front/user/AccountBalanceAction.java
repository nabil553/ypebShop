package com.ypeb.action.front.user;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ypeb.model.shopping.goodsOrder.Order;
import com.ypeb.model.shopping.goodsOrder.OrderDAO;
import com.ypeb.model.user.cash.Cash;
import com.ypeb.model.user.cash.CashDAO;
import com.ypeb.model.user.user.User;
import com.ypeb.model.user.user.UserDAO;
import com.ypeb.util.Page;

public class AccountBalanceAction extends ActionSupport {
	private String destUrl;
	private User user;
	private List<Cash> cashList = new ArrayList<Cash>();
	private List<Order> givePointsList = new ArrayList<Order>();
	private Page page;

	private int pageNum = 1;// dwz分页使用
	private int numPerPage;

	public String myCash() {
		/**
		 * @author jilin
		 * @date : 2017年1月18日 上午2:38:29
		 * @descripe:查询账户剩余现金余额和充值记录
		 */
		int userID = (Integer) ActionContext.getContext().getSession()
				.get("userID");

		if (numPerPage == 0)
			numPerPage = 7;

		page = new Page(pageNum, numPerPage);
		CashDAO dao = new CashDAO();
		page.setTotalCount(Integer.valueOf(dao.findCount()));

		user = new UserDAO().findById(userID);
		cashList = new CashDAO().findByUserId(userID, page);
		destUrl = "frontPage/user/cash.jsp";
		return "diyUrl";
	}

	public String myIcePoints() {
		/**
		 * @author jilin
		 * @date : 2017年1月18日 上午2:38:29
		 * @descripe:查询账户剩余冻结积分余额和记录
		 */
		user = (User) ActionContext.getContext().getSession().get("user");

		
		givePointsList = new OrderDAO().findByUserId(user.getId());
		destUrl = "frontPage/user/cash.jsp";
		return "diyUrl";
	}

	public String myShoppingPoints() {
		/**
		 * @author jilin
		 * @date : 2017年1月18日 上午2:38:29
		 * @descripe:查询账户购物积分余额
		 */
		String userID = (String) ActionContext.getContext().getSession()
				.get("userID");
		Integer uid = new Integer(userID);
		user = new UserDAO().findById(uid.intValue());
		cashList = new CashDAO().findByUserId(uid.intValue());
		destUrl = "frontPage/user/cash.jsp";
		return "diyUrl";
	}

	public String myTradePoints() {
		/**
		 * @author jilin
		 * @date : 2017年1月18日 上午2:38:29
		 * @descripe:查询账户交易积分余额
		 */
		String userID = (String) ActionContext.getContext().getSession()
				.get("userID");
		Integer uid = new Integer(userID);
		user = new UserDAO().findById(uid.intValue());
		cashList = new CashDAO().findByUserId(uid.intValue());
		destUrl = "frontPage/user/cash.jsp";
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

	public List<Cash> getCashList() {
		return cashList;
	}

	public void setCashList(List<Cash> cashList) {
		this.cashList = cashList;
	}

	public List<Order> getGivePointsList() {
		return givePointsList;
	}

	public void setGivePointsList(List<Order> givePointsList) {
		this.givePointsList = givePointsList;
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
