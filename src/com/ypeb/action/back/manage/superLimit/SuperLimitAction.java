package com.ypeb.action.back.manage.superLimit;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;
import com.ypeb.dataClass.front.MD5encryption;
import com.ypeb.dataClass.front.ManagerRole;
import com.ypeb.model.hibernate.HibernateSessionFactory;
import com.ypeb.model.shopping.goods.GoodsDAO;
import com.ypeb.util.Page;

import come.ypeb.model.manager.Manager;
import come.ypeb.model.manager.ManagerDAO;
import come.ypeb.model.manager.role.Role;
import come.ypeb.model.manager.role.RoleDAO;

public class SuperLimitAction extends ActionSupport {

	private String destUrl;
	private Manager manager;
	private List<Manager> managerList = new ArrayList<Manager>();
	private List<ManagerRole> managerRoleList = new ArrayList<ManagerRole>();
	private Role role;
	private List<Role> roleList;
	private Page page;
	private String uid;

	private int pageNum = 1;// dwz分页使用
	private int numPerPage;

	// JUI JSON返回
	private String statusCode;
	private String message;
	private String navTabId;
	private String callbackType;
	private String forwardUrl;

	public String list() {
		try {

			ManagerDAO dao = new ManagerDAO();

			if (numPerPage == 0)
				numPerPage = 17;

			page = new Page(pageNum, numPerPage);

			page.setTotalCount((Integer) dao.findCount());
			managerList = dao.findAllByPage(page);
			for (Manager list : managerList) {
				ManagerRole temp = new ManagerRole();
				temp.setManager(list);
				temp.setRole(new RoleDAO().findById(list.getRole().getId()));
				managerRoleList.add(temp);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		destUrl = "backPage/manager/manager/list.jsp";
		return "diyUrl";
	}

	public String addPre() {
		/**
		 * @author jilin
		 * @date : 2017年1月13日 上午11:43:05
		 * @descripe:修改一个栏目信息的前置处理
		 */

		RoleDAO dao = new RoleDAO();

		roleList = dao.findByIsDelete(false);
		destUrl = "backPage/manager/manager/add.jsp";
		return "diyUrl";
	}

	public String add() {
		try {
			ManagerDAO dao = new ManagerDAO();
			Manager temp = new Manager();
			temp.setIsDelete(false);
			temp.setName(manager.getName());
			if (dao.findByExample(temp).size() > 0) {
				statusCode = "300";
				message = "添加失败,用户名重复";
				navTabId = "manager";
				forwardUrl = "";
				return "ajaxdone";
			}
			Transaction tx = HibernateSessionFactory.getSession()
					.beginTransaction();
			manager.setPassword(MD5encryption.GetMD5Code(manager.getPassword()));
			manager.setIsDelete(false);
			dao.save(manager);
			tx.commit();
			HibernateSessionFactory.getSession().close();

			statusCode = "200";
			message = "添加成功";
			navTabId = "manager";
			callbackType = "closeCurrent";
			forwardUrl = "";
		} catch (Exception e) {
			HibernateSessionFactory.getSession().close();
			statusCode = "300";
			message = "添加失败";
			navTabId = "manager";
			callbackType = "closeCurrent";
			forwardUrl = "";
			e.printStackTrace();
		}

		return "ajaxdone";
	}

	public String modifyPre() {
		/**
		 * @author jilin
		 * @date : 2017年1月13日 上午11:43:05
		 * @descripe:修改一个栏目信息的前置处理
		 */

		ManagerDAO dao = new ManagerDAO();
		Integer id = new Integer(uid);
		manager = dao.findById(id.intValue());
		RoleDAO dao1 = new RoleDAO();

		roleList = dao1.findByIsDelete(false);
		destUrl = "backPage/manager/manager/modify.jsp";
		return "diyUrl";
	}

	public String modify() {
		try {
			ManagerDAO dao = new ManagerDAO();
			Manager temp = new Manager();
			temp.setIsDelete(false);
			temp.setName(manager.getName());
			if (!dao.findById(manager.getId()).getName().equals(manager.getName())) {
				if (dao.findByExample(temp).size() > 0) {
					statusCode = "300";
					message = "修改失败，用户名重复";
					navTabId = "manager";
					forwardUrl = "";
					return "ajaxdone";
				}
			}
			Transaction tx = HibernateSessionFactory.getSession()
					.beginTransaction();

			manager.setIsDelete(false);
			manager.setPassword(MD5encryption.GetMD5Code(manager.getPassword()));
			dao.merge(manager);
			tx.commit();
			HibernateSessionFactory.getSession().close();
			
			statusCode = "200";
			message = "修改成功";
			navTabId = "manager";
			callbackType = "closeCurrent";
			forwardUrl = "";
		} catch (Exception e) {
			HibernateSessionFactory.getSession().close();
			statusCode = "300";
			message = "修改失败";
			navTabId = "manager";
			callbackType = "closeCurrent";
			forwardUrl = "";
			e.printStackTrace();
		}

		return "ajaxdone";
	}

	public String delete() {
		try {
			Transaction tx = HibernateSessionFactory.getSession()
					.beginTransaction();
			Integer id = new Integer(uid);
			ManagerDAO dao = new ManagerDAO();
			manager = dao.findById(id);
			manager.setIsDelete(true);
			dao.merge(manager);
			tx.commit();
			HibernateSessionFactory.getSession().close();

			statusCode = "200";
			message = "删除成功";
			navTabId = "manager";

			forwardUrl = "";
		} catch (Exception e) {
			HibernateSessionFactory.getSession().close();
			statusCode = "300";
			message = "删除失败";
			navTabId = "manager";

			forwardUrl = "";
			e.printStackTrace();
		}

		return "ajaxdone";
	}

	public String roleList() {

		try {

			RoleDAO dao = new RoleDAO();

			if (numPerPage == 0)
				numPerPage = 17;

			page = new Page(pageNum, numPerPage);

			page.setTotalCount((Integer) dao.findCount());
			roleList = dao.findAllByPage(page);

		} catch (Exception e) {
			e.printStackTrace();
		}

		destUrl = "backPage/manager/role/list.jsp";
		return "diyUrl";
	}

	public String addRole() {
		try {
			RoleDAO dao = new RoleDAO();
			Role temp = new Role();
			temp.setIsDelete(false);
			temp.setName(role.getName());
			if (dao.findByExample(temp).size() > 0) {
				statusCode = "300";
				message = "添加失败,角色名重复";
				navTabId = "role";
				forwardUrl = "";
				return "ajaxdone";
			}
			Transaction tx = HibernateSessionFactory.getSession()
					.beginTransaction();

			role.setIsDelete(false);
			dao.save(role);
			tx.commit();
			HibernateSessionFactory.getSession().close();

			statusCode = "200";
			message = "添加成功";
			navTabId = "role";
			callbackType = "closeCurrent";
			forwardUrl = "";
		} catch (Exception e) {
			HibernateSessionFactory.getSession().close();
			statusCode = "300";
			message = "添加失败";
			navTabId = "role";
			callbackType = "closeCurrent";
			forwardUrl = "";
			e.printStackTrace();
		}

		return "ajaxdone";
	}

	public String modifyRolePre() {
		/**
		 * @author jilin
		 * @date : 2017年1月13日 上午11:43:05
		 * @descripe:修改一个栏目信息的前置处理
		 */

		RoleDAO dao = new RoleDAO();
		Integer id = new Integer(uid);
		role = dao.findById(id.intValue());

		destUrl = "backPage/manager/role/modify.jsp";
		return "diyUrl";
	}

	public String modifyRole() {
		try {
			RoleDAO dao = new RoleDAO();
			Role temp = new Role();
			temp.setIsDelete(false);
			temp.setName(role.getName());
			if (!dao.findById(role.getId()).getName().equals(role.getName())) {
				if (dao.findByExample(temp).size() > 0) {
					statusCode = "300";
					message = "修改失败,角色名重复";
					navTabId = "role";

					forwardUrl = "";
					return "ajaxdone";
				}
			}
			Transaction tx = HibernateSessionFactory.getSession()
					.beginTransaction();

			role.setIsDelete(false);
			dao.merge(role);
			tx.commit();
			HibernateSessionFactory.getSession().close();

			statusCode = "200";
			message = "修改成功";
			navTabId = "role";
			callbackType = "closeCurrent";
			forwardUrl = "";
		} catch (Exception e) {
			HibernateSessionFactory.getSession().close();
			statusCode = "300";
			message = "修改失败";
			navTabId = "role";
			callbackType = "closeCurrent";
			forwardUrl = "";
			e.printStackTrace();
		}

		return "ajaxdone";
	}

	public String deleteRole() {
		try {
			Transaction tx = HibernateSessionFactory.getSession()
					.beginTransaction();
			Integer id = new Integer(uid);
			RoleDAO dao = new RoleDAO();
			role = dao.findById(id);
			role.setIsDelete(true);
			dao.merge(role);
			tx.commit();
			HibernateSessionFactory.getSession().close();

			statusCode = "200";
			message = "删除成功";
			navTabId = "role";

			forwardUrl = "";
		} catch (Exception e) {
			HibernateSessionFactory.getSession().close();
			statusCode = "300";
			message = "删除失败";
			navTabId = "role";

			forwardUrl = "";
			e.printStackTrace();
		}

		return "ajaxdone";
	}

	public String getDestUrl() {
		return destUrl;
	}

	public void setDestUrl(String destUrl) {
		this.destUrl = destUrl;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public List<Manager> getManagerList() {
		return managerList;
	}

	public void setManagerList(List<Manager> managerList) {
		this.managerList = managerList;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
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

	public List<ManagerRole> getManagerRoleList() {
		return managerRoleList;
	}

	public void setManagerRoleList(List<ManagerRole> managerRoleList) {
		this.managerRoleList = managerRoleList;
	}

}
