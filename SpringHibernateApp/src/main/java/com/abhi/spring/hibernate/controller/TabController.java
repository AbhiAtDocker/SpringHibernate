package com.abhi.spring.hibernate.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.abhi.spring.hibernate.bean.Permission;
import com.abhi.spring.hibernate.bean.Role;
import com.abhi.spring.hibernate.bean.Tab;
import com.abhi.spring.hibernate.service.DbService;

@Controller
public class TabController {

	@Autowired
	private DbService dbService;			// This will auto-inject the authentication service into the controller.

	private static Logger log = Logger.getLogger(TabController.class);

/*	// This method redirects the user to the index page of the application.
	@RequestMapping(value="/welcome", method = RequestMethod.GET)
	public String index() {
		log.info("Redirecting the application to the landing page.");
		return "redirect:user_list";
	}*/

	// This method handles the request to get the user_list from the database.
	@RequestMapping(value = "/addTab", method=RequestMethod.POST)
	public String addRole(@ModelAttribute("tab")Tab tab, ModelMap model,BindingResult result ) {
		Long id = dbService.addTab(tab);
		
		if(id != null){
		  log.info("Tab Added " + tab.getName());
		}
		
		model.addAttribute("tabName", tab.getName()); 
		// Returning the result to the target jsp.
		return "tab";			
	}
	
	@RequestMapping(value="/tab", method=RequestMethod.GET)
	public String role(Model model){
		model.addAttribute("tab",new Tab());
	 return "tab";
	}
	
	
	
}