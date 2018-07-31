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

public class TabRole implements Serializable {
	
	private long idTabRole;
	private Role role;
	private Tab tab;
	
		
	public long getIdTabRole() {
		return idTabRole;
	}
	public void setIdTabRole(long idTabRole) {
		this.idTabRole = idTabRole;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Tab getTab() {
		return tab;
	}
	public void setTab(Tab tab) {
		this.tab = tab;
	}
}
