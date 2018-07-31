package com.abhi.spring.hibernate.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.abhi.spring.hibernate.bean.Role;
import com.abhi.spring.hibernate.bean.User;
import com.abhi.spring.hibernate.service.DbService;

@Controller
public class UserCtrl {

	@Autowired
	private DbService dbService;			// This will auto-inject the authentication service into the controller.

	private static Logger log = Logger.getLogger(UserCtrl.class);

	// This method redirects the user to the index page of the application.
	@RequestMapping(value="/welcome", method = RequestMethod.GET)
	public String welcome() {
		log.info("Redirecting the application to the landing page.");
		return "redirect:user_list";
	}
	
	
	// This method redirects the user to the index page of the application.
		@RequestMapping(value="/index", method = RequestMethod.GET)
		public String index() {
			return "home";
		}

	// This method handles the request to get the user_list from the database.
	@RequestMapping(value = "/user_list", method = RequestMethod.GET)
	public ModelAndView fetchUserList() {
		List<User> ulist = dbService.getUsrList();
		log.info("Total no. of user_records fetched from db are?= " + ulist.size());

		// Returning the result to the target jsp.
		return new ModelAndView("userList", "userList", ulist);			
	}
	
	
	// This method handles the request to get the user_list from the database.
		@RequestMapping(value = "/addUser", method=RequestMethod.POST)
		public String addUser(@ModelAttribute("user")User user, ModelMap model,BindingResult result ) {
			Long id = dbService.addUser(user);
			
			if(id != null){
			  log.info("User Added " + user.getName());
			}
			List<Role> roleList = dbService.getRoles();
			model.addAttribute("roles",roleList);
			
			model.addAttribute("name", user.getName()); 
			// Returning the result to the target jsp.
			return "user";			
		}
	
		
		/***
		 * Returns the edit form
		 * @param model
		 * @return
		 */
	
	@RequestMapping(value="/user", method=RequestMethod.GET)
	public String user(Model model){
		List<Role> roleList = dbService.getRoles(); 
		model.addAttribute("roles",roleList); 
		model.addAttribute("user",new User());
	 return "user";
	} 
	
	/***
	 * gets user with give id and 
	 * redirects it to edit form
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/editUser/{id}")  
    public String edit(@PathVariable Long id,Model model){  
        User user=dbService.getUserById(id); 
        List<Role> roleList = dbService.getRoles();
		model.addAttribute("roles",roleList);
        model.addAttribute("user", user);
        return "userEdit";  
    }  
	
	/*This method handles the request to get the user_list from the database.*/
	@RequestMapping(value = "/updateUser", method=RequestMethod.POST)
	public String updateUser(@ModelAttribute("user")User user, ModelMap model,BindingResult result ) {
		 dbService.updateUser(user);
		 List<Role> roleList = dbService.getRoles();
	     model.addAttribute("roles",roleList);
		 model.addAttribute("name", user.getName()); 
		 // Returning the result to the target jsp.
		 return "user";			
	}
	
	
	/*This method handles the request to get the user_list from the database.*/
	@RequestMapping(value = "/deleteUser/{id}", method=RequestMethod.GET)
	public ModelAndView deleteUser(@PathVariable Long id ) {
		 dbService.deleteUser(id);
		 List<User> ulist = dbService.getUsrList();
			log.info("Total no. of user_records fetched from db are?= " + ulist.size());

			// Returning the result to the target jsp.
			return new ModelAndView("home", "userList", ulist);		
				
	}
}