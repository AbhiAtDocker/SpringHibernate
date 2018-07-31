package com.abhi.spring.hibernate.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Tabs are accessed by roles (Roles have tabs)
 * and roles have permissions 
 * which will decide what kind of
 * access can user have.
 * Also tabs are ac
 * @author Abhi
 */

public class Tab implements Serializable {
	
	private long tabId;
	private String name;
	private String comment;
	
	
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public long getTabId() {
		return tabId;
	}
	
	public void setTabId(long id) {
		this.tabId = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
