package com.ypeb.action.back.manage.setting;

import java.util.List;

import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;
import com.ypeb.model.hibernate.HibernateSessionFactory;
import com.ypeb.model.points.setting.Setting;
import com.ypeb.model.points.setting.SettingDAO;

public class SettingAction extends ActionSupport {
	private Setting setting;
	private String destUrl;
	// JUI JSON返回
	private String statusCode;
	private String message;
	private String navTabId;
	private String callbackType;
	private String forwardUrl;

	public String list() {
		List<Setting> temp = new SettingDAO().findAll();
		if (temp.size() > 0)
			setting = temp.get(0);

		destUrl = "backPage/setting/list.jsp";
		return "diyUrl";
	}

	public String modifyPre() {
		List<Setting> temp = new SettingDAO().findAll();
		if (temp.size() > 0)
			setting = temp.get(0);
		destUrl = "backPage/setting/modify.jsp";
		return "diyUrl";

	}

	public String modify() {

		Transaction tx = null;
		try {
			tx = HibernateSessionFactory.getSession().beginTransaction();
			setting.setIsDelete(false);
			setting.setIsUsing(true);
			new SettingDAO().merge(setting);
			tx.commit();
			statusCode = "200";
			message = "修改成功";
			navTabId = "setting";
			callbackType = "closeCurrent";
			forwardUrl = "";

		} catch (Exception e) {
			HibernateSessionFactory.getSession().close();
			e.printStackTrace();
		}
		return "ajaxdone";
	}

	public Setting getSetting() {
		return setting;
	}

	public void setSetting(Setting setting) {
		this.setting = setting;
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

}
