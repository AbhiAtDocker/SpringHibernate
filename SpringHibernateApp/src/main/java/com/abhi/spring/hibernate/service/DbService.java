package com.abhi.spring.hibernate.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.abhi.spring.hibernate.bean.Permission;
import com.abhi.spring.hibernate.bean.Role;
import com.abhi.spring.hibernate.bean.Tab;
import com.abhi.spring.hibernate.bean.User;


public class DbService {

	private SessionFactory sessionFactory;

	private static Logger log = Logger.getLogger(DbService.class);

	// This method initialized the session_factory object for further processing.
	public DbService(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// This method fetches the user_list from the database.
	@SuppressWarnings("unchecked")
	@Transactional
	public List<User> getUsrList() {
		List<User> user_list = null;
		log.info("Fetching the user list from the database");
		try {
			String sql_query = "from User";
			user_list = sessionFactory.getCurrentSession().createQuery(sql_query).list();		
			
			log.info("Total no. of users fetched from the db are?= " + user_list.size());
		} catch(Exception e) {
			log.error("An error occurred while fetching the user details from the database", e);	
		}

		return user_list;
	}
	
	

	@SuppressWarnings("unchecked")
	@Transactional
	public long addRole(Role role) {
		Long r = null;
		log.info("Adding role: " + role.getName());
		try {

			 r = (Long) sessionFactory.getCurrentSession().save(role);
			
			log.info("Role added: " + role.getName());
		} catch(Exception e) {
			log.error("An error occurred while fetching the user details from the database", e);	
		}

		return r;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public long addUser(User user) {
		Long r = null;
		log.info("Adding user to database");
		try {
			 r = (Long) sessionFactory.getCurrentSession().save(user);
			log.info("User added: " + user.getName());
		} catch(Exception e) {
			log.error("An error occurred while fetching the user details from the database", e);	
		}

		return r;
	}
	
	/***
	 * 
	 * @return
	 */
	@Transactional
	public List<Role> getRoles()
	{
		List<Role> roles =null;
		try {
			String sql_query = "from Role";
	        roles = sessionFactory.getCurrentSession().createQuery(sql_query).list();	
	        for(Role role:roles){
	        	Hibernate.initialize(role.getTabs());
	        }
			
			log.info("Total no. of users fetched from the db are?= " + roles.size());
		} catch(Exception e) {
			log.error("An error occurred while fetching the user details from the database", e);	
		}

		
		return roles;
	}
	
	
    @Transactional
	public User getUserById(Long id){
		User user = null;
		try{
			String sql_query = "from User u where u.id = :id ";
			List users = sessionFactory.getCurrentSession().createQuery(sql_query).setParameter("id", id).list();
			user = (User) users.get(0);
			log.info("User fetched " + user.getName());
		}catch(Exception e){
			log.error("An error occurred while fetching the user details from the database", e);	
		}
	
        return user;
    }
	

    /****
     *     
     * @return
     */
    @Transactional
    public void updateUser(User user){
    	
    	try{
    		sessionFactory.getCurrentSession().update(user);
			log.info("Entities updated: " + user);
		}catch(Exception e){
			log.error("An error occurred while fetching the user details from the database", e);	
		}
    }

    
    @Transactional
    public void deleteUser(Long id){
    
    	try{
    		User user = sessionFactory.getCurrentSession().load(User.class, id);
    		sessionFactory.getCurrentSession().delete(user);
    		log.info("Entities deleted: " + user);
		}catch(Exception e){
			log.error("An error occurred while fetching the user details from the database", e);	
		}
    	
    }
    
    
    @Transactional 
	public Long addPermission(Permission permission) {
		Long r = null;
		log.info("Adding permission to database");
		try {
			 r = (Long) sessionFactory.getCurrentSession().save(permission);
			log.info("User added: " + permission.getId());
		} catch(Exception e) {
			log.error("An error occurred while creating the Permission ", e);	
		}

		return r;
	}

    @Transactional
	public Long addTab(Tab tab) {
		Long r = null;
		log.info("Adding Tab to database");
		try {
			 r = (Long) sessionFactory.getCurrentSession().save(tab);
			log.info("Tab added: " + tab.getName());
		} catch(Exception e) {
			log.error("An error occurred while creating the Tab ", e);	
		}
		
		return r;
	}

    @Transactional
	public List<Tab> getTabs() {
		List<Tab> tabs =null;
		try {
			String sql_query = "from Tab";
	        tabs = sessionFactory.getCurrentSession().createQuery(sql_query).list();		
			
			log.info("Total no. of tabs fetched from the db are?= " + tabs.size());
		} catch(Exception e) {
			log.error("An error occurred while fetching the user details from the database", e);	
		}

		
		return tabs;
	}

    @Transactional
	public List<Permission> getPermissions() {
		List<Permission> permissions =null;
		try {
			String sql_query = "from Permission";
	        permissions = sessionFactory.getCurrentSession().createQuery(sql_query).list();		
			
			log.info("Total no. of permissioms fetched from the db are?= " + permissions.size());
		} catch(Exception e) {
			log.error("An error occurred while fetching the user details from the database", e);	
		}

		
		return permissions;
	}
}