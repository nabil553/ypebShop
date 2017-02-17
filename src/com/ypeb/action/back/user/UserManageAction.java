package com.ypeb.action.back.user;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;
import com.ypeb.dataClass.front.CashUser;
import com.ypeb.dataClass.front.MD5encryption;
import com.ypeb.dataClass.front.QueryCondition;
import com.ypeb.model.hibernate.HibernateSessionFactory;
import com.ypeb.model.points.setting.SettingDAO;
import com.ypeb.model.user.cash.Cash;
import com.ypeb.model.user.cash.CashDAO;
import com.ypeb.model.user.user.User;
import com.ypeb.model.user.user.UserDAO;
import com.ypeb.util.Page;
import come.ypeb.model.manager.ManagerDAO;

public class UserManageAction extends ActionSupport {
	private User user;
	private List<User> userList = new ArrayList<User>();
	private List<Cash> cashList = new ArrayList<Cash>();
	private List<CashUser> cashUserList = new ArrayList<CashUser>();
	private String destUrl;
	private String telephone;

	// JUI JSON返回
	private String statusCode;
	private String message;
	private String navTabId;
	private String callbackType;
	private String forwardUrl;

	private Page page;

	private int pageNum = 1;// dwz分页使用
	private int numPerPage;

	private int uid;
	
	public String delete(){
		
		try {
			Transaction tx = HibernateSessionFactory.getSession()
					.beginTransaction();
			Integer id = new Integer(uid);
			UserDAO dao = new UserDAO();
			user = dao.findById(id);
			user.setIsDelete(true);
			dao.merge(user);
			tx.commit();
			HibernateSessionFactory.getSession().close();

			statusCode = "200";
			message = "删除成功";
			navTabId = "userManage";

			forwardUrl = "";
		} catch (Exception e) {
			HibernateSessionFactory.getSession().close();
			statusCode = "300";
			message = "删除失败";
			navTabId = "userManage";

			forwardUrl = "";
			e.printStackTrace();
		}

		return "ajaxdone";
	}

	public String recharge() {
		Transaction tx = null;
		try {

			tx = HibernateSessionFactory.getSession().beginTransaction();
			Cash cash = new CashDAO().findById(uid);
			User user = new UserDAO().findById(cash.getUserId());
			user.setCash(user.getCash() + cash.getNum());
			short t = 2;
			cash.setState(t);
			new CashDAO().merge(cash);
			new UserDAO().merge(user);
			tx.commit();
			statusCode = "200";
			message = "充值成功";
			navTabId = "recharge";
			callbackType = "";
			forwardUrl = "";

		} catch (Exception e) {
			tx.rollback();
			statusCode = "300";
			message = "充值失败";
			navTabId = "recharge";
			callbackType = "";
			forwardUrl = "";
			HibernateSessionFactory.getSession().close();
			e.printStackTrace();
		}
		return "ajaxdone";
	}

	public String withdraw() {
		Transaction tx = null;
		try {

			tx = HibernateSessionFactory.getSession().beginTransaction();
			Cash cash = new CashDAO().findById(uid);
			User user = new UserDAO().findById(cash.getUserId());
			double num;
			num = cash.getNum() * (1 + cash.getRate());

			if (num > user.getCash()) {
				statusCode = "300";
				message = "账户余额不足，无法提现，请取消该申请";
				navTabId = "withdraw";
				callbackType = "";
				forwardUrl = "";
				HibernateSessionFactory.getSession().close();
				return "ajaxdone";
			}
			user.setCash(user.getCash() - num);
			short t = 2;
			cash.setState(t);
			new CashDAO().merge(cash);
			new UserDAO().merge(user);
			tx.commit();
			statusCode = "200";
			message = "提现成功";
			navTabId = "withdraw";
			callbackType = "";
			forwardUrl = "";

		} catch (Exception e) {
			tx.rollback();
			statusCode = "300";
			message = "提现失败";
			navTabId = "withdraw";
			callbackType = "";
			forwardUrl = "";
			HibernateSessionFactory.getSession().close();
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.getSession().close();
		}
		return "ajaxdone";
	}

	public String listRecharge() {
		try {
			CashDAO dao = new CashDAO();
			if (numPerPage == 0)
				numPerPage = 17;
			page = new Page(pageNum, numPerPage);

			QueryCondition condition = new QueryCondition();
			condition.setOrderField("operate");
			condition.setState(true);
			condition.setOrderField2("state");
			short m = 1;
			condition.setState2(m);
			Integer t = new Integer(dao.findCount(condition));
			page.setTotalCount(t.intValue());
			cashList = dao.findByPage2Param(condition, page);
			for (Cash list : cashList) {
				CashUser temp = new CashUser();
				temp.setCash(list);
				User tem = new User();
				tem = new UserDAO().findById(list.getUserId());
				temp.setUserName(tem.getName());
				cashUserList.add(temp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		destUrl = "backPage/user/listRecharge.jsp";
		return "diyUrl";

	}

	public String listWithdraw() {
		try {
			CashDAO dao = new CashDAO();
			if (numPerPage == 0)
				numPerPage = 17;
			page = new Page(pageNum, numPerPage);

			QueryCondition condition = new QueryCondition();
			condition.setOrderField("operate");
			condition.setState(false);
			condition.setOrderField2("state");
			short m = 1;
			condition.setState2(m);
			Integer t = new Integer(dao.findCount(condition));
			page.setTotalCount(t.intValue());
			cashList = dao.findByPage2Param(condition, page);
			for (Cash list : cashList) {
				CashUser temp = new CashUser();
				temp.setCash(list);
				User tem = new User();
				tem = new UserDAO().findById(list.getUserId());
				temp.setUserName(tem.getName());
				cashUserList.add(temp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		destUrl = "backPage/user/listWithdraw.jsp";
		return "diyUrl";
	}

	public String listRecord() {
		try {
			CashDAO dao = new CashDAO();
			if (numPerPage == 0)
				numPerPage = 17;
			page = new Page(pageNum, numPerPage);

			QueryCondition condition = new QueryCondition();
			/*
			 * condition.setOrderField("operate"); condition.setState(false);
			 * condition.setOrderField2("state"); short m = 1;
			 * condition.setState2(m);
			 */
			Integer t = new Integer(dao.findCount());
			page.setTotalCount(t.intValue());
			cashList = dao.findAllByPage(page);
			for (Cash list : cashList) {
				CashUser temp = new CashUser();
				temp.setCash(list);
				User tem = new User();
				tem = new UserDAO().findById(list.getUserId());
				temp.setUserName(tem.getName());
				cashUserList.add(temp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		destUrl = "backPage/user/list.jsp";
		return "diyUrl";
	}

	public String userList() {
		UserDAO dao = new UserDAO();
		if (numPerPage == 0)
			numPerPage = 17;
		page = new Page(pageNum, numPerPage);
		page.setTotalCount((Integer) dao.findCount());
		userList = dao.findAllByPage(page);

		destUrl = "backPage/user/userList.jsp";
		return "diyUrl";
	}

	public String modifyPre() {

		user = new UserDAO().findById(uid);
		destUrl = "backPage/user/modify.jsp";
		return "diyUrl";
	}

	public String modify() {

		Transaction tx = null;
		try {
			tx = HibernateSessionFactory.getSession().beginTransaction();
			UserDAO dao = new UserDAO();
			User temp = dao.findById(user.getId());

			if (user.getPassword() != null && !user.getPassword().isEmpty())
				temp.setPassword(MD5encryption.GetMD5Code(user.getPassword()));
			if (user.getIdcard() != null && !user.getIdcard().isEmpty())
				temp.setIdcard(user.getIdcard());
			if (user.getTelephone() != null && !user.getTelephone().isEmpty()) {
				int size;
				User tem = new User();
				tem.setTelephone(user.getTelephone());
				tem.setIsDelete(false);
				size = dao.findByExample(tem).size();

				if (size <= 0)
					temp.setTelephone(user.getTelephone());
				else {
					if (!temp.getTelephone().equals(user.getTelephone())) {
						statusCode = "300";
						message = "修改失败,手机号重复";
						navTabId = "userManage";
						callbackType = "closeCurrent";
						forwardUrl = "";
						HibernateSessionFactory.getSession().close();
						return "ajaxdone";
					}
				}
			}
			if (user.getStyle() != null && user.getStyle() != 0) {
				temp.setStyle(user.getStyle());
			}
			if (user.getLevel() != null && user.getLevel() != 0) {
				temp.setLevel(user.getLevel());
			}

			dao.merge(temp);
			tx.commit();
			statusCode = "200";
			message = "修改成功";
			navTabId = "userManage";
			callbackType = "closeCurrent";
			forwardUrl = "";

		} catch (Exception e) {
			statusCode = "300";
			message = "修改失败";
			navTabId = "userManage";
			callbackType = "closeCurrent";
			forwardUrl = "";
			HibernateSessionFactory.getSession().close();
			e.printStackTrace();
		}
		return "ajaxdone";
	}

	public String queryUser() {
		/**
		 * @author jilin
		 * @date : 2017年1月18日 上午3:27:28
		 * @descripe:根据用户电话查询
		 */
		user.setTelephone(telephone);
		user.setIsDelete(false);
		userList = new UserDAO().findByExample(user);

		if (userList.size() > 0) {
			telephone = userList.get(0).getTelephone();
		}
		destUrl = "backPage/user/userList.jsp";
		return "diyUrl";
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDestUrl() {
		return destUrl;
	}

	public void setDestUrl(String destUrl) {
		this.destUrl = destUrl;
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

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public List<Cash> getCashList() {
		return cashList;
	}

	public void setCashList(List<Cash> cashList) {
		this.cashList = cashList;
	}

	public List<CashUser> getCashUserList() {
		return cashUserList;
	}

	public void setCashUserList(List<CashUser> cashUserList) {
		this.cashUserList = cashUserList;
	}

}
