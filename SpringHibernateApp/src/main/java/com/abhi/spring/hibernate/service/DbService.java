package com.abhi.spring.hibernate.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.abhi.spring.hibernate.bean.Role;
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
		List<Role> role =null;
		try {
			String sql_query = "from Role";
	        role = sessionFactory.getCurrentSession().createQuery(sql_query).list();		
			
			log.info("Total no. of users fetched from the db are?= " + role.size());
		} catch(Exception e) {
			log.error("An error occurred while fetching the user details from the database", e);	
		}

		
		return role;
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

}