package com.ypeb.action.back;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ypeb.dataClass.front.MD5encryption;

import come.ypeb.model.manager.Manager;
import come.ypeb.model.manager.ManagerDAO;
import come.ypeb.model.manager.role.Role;
import come.ypeb.model.manager.role.RoleDAO;

public class LoginAction extends ActionSupport {
	//后台登录类
	private String destUrl;
	private Manager manager;
	private String error;
	
	public String logOff(){
		try{
			ActionContext.getContext().getSession().remove("role");
		}catch(Exception e){
			e.printStackTrace();
		}
		destUrl="backPage/backLogin.jsp";
		return "diyUrl";
	}
	
	public String AdminLogin(){
		destUrl="backPage/backLogin.jsp";
		return "diyUrl";
	}
	
	public String login(){
		Manager t=new Manager();
		t.setName(manager.getName());
		t.setIsDelete(false);
		List<Manager> temp=new ManagerDAO().findByExample(t);
		if(temp.size()>0){
			if(temp.get(0).getPassword().equals(MD5encryption.GetMD5Code(manager.getPassword()))){
				Role role=new RoleDAO().findById(temp.get(0).getRole().getId());
				ActionContext.getContext().getSession().put("role", role);
				destUrl="backPage/backIndex.jsp";
			}else{
				error="密码错误";
				destUrl="backPage/backLogin.jsp";
			}
		}else{
			error="用户名错误";
			destUrl="backPage/backLogin.jsp";
		}
		
		
		return "diyUrl";
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

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	
	
}
