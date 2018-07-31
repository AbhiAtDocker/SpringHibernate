package com.abhi.spring.hibernate.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class Role implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private int code;
	private String name;
	private Permission permission;
	//tab idsS
	private List<Tab> tabs;
	
	
	

	public List<Tab> getTabs() {
		return tabs;
	}


	public void setTabs(List<Tab> tabs) {
		this.tabs = tabs;
	}


	public Role(){
	}
	
	
	public Permission getPermission() {
		return permission;
	}


	public void setPermission(Permission permission) {
		this.permission = permission;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
