package com.ypeb.action.back.superLimit;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import come.ypeb.model.manager.Manager;
import come.ypeb.model.manager.role.Role;

public class ManagerAction extends ActionSupport {
	private List<Role> roleList=new ArrayList<Role>();
	private List<Manager> managerList=new ArrayList<Manager>();
	private Role role;
	private Manager manager;
	private String destUrl;
	private int id;
	
	
	
	public List<Role> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
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
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	public String getDestUrl() {
		return destUrl;
	}
	public void setDestUrl(String destUrl) {
		this.destUrl = destUrl;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	
	

}
