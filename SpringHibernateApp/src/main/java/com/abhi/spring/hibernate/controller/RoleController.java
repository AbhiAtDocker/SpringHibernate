package com.abhi.spring.hibernate.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.abhi.spring.hibernate.bean.Permission;
import com.abhi.spring.hibernate.bean.Role;
import com.abhi.spring.hibernate.bean.Tab;
import com.abhi.spring.hibernate.bean.TabRole;
import com.abhi.spring.hibernate.service.DbService;

@Controller
public class RoleController {

	@Autowired
	private DbService dbService;			// This will auto-inject the authentication service into the controller.

	private static Logger log = Logger.getLogger(RoleController.class);
	
	private Map<Long,Tab> tabs = new HashMap<Long,Tab>();
	private Map<Long,Role> roles = new HashMap<>();
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) throws Exception {
		binder.registerCustomEditor(List.class, "tabs", new CustomCollectionEditor(List.class) {
			protected Object convertElement(Object element) {
				if (element instanceof TabRole) {
					System.out.println("Converting from Staff to Staff: " + element);
					return element;
				}
				if (element instanceof String) {
					//String[] tabRoles = ((String)element).split(":");
					Tab tab = tabs.get(Long.valueOf((String)element));
					//Role role =roles.get(Long.valueOf(tabRoles[1]));
					/*TabRole tabRole = new TabRole();
					tabRole.setTab(tab);*/
					System.out.println("Looking up staff for id " + element + ": " + tab);
					return tab;
				}
				System.out.println("Don't know what to do with: " + element);
				return null;
			}
		});
	}

/*	// This method redirects the user to the index page of the application.
	@RequestMapping(value="/welcome", method = RequestMethod.GET)
	public String index() {
		log.info("Redirecting the application to the landing page.");
		return "redirect:user_list";
	}*/

	// This method handles the request to get the user_list from the database.
	@RequestMapping(value = "/addRole", method=RequestMethod.POST)
	public String addRole(@ModelAttribute("role")Role role, ModelMap model,BindingResult result ) {
	Long id = dbService.addRole(role);
		roles.put(id, role);
		if(id != null){
		  log.info("Role Added " + role.getName());
		}
		
		model.addAttribute("roleName", role.getName()); 
		// Returning the result to the target jsp.
		return "role";			
	}
	
	@RequestMapping(value="/role", method=RequestMethod.GET)
	public String role(Model model){
		List<Tab> tabs = dbService.getTabs();
		List<Permission> permissions = dbService.getPermissions();
		for(Tab tab: tabs){
		  this.tabs.put(tab.getTabId(), tab);
		}
		model.addAttribute("role",new Role());
		model.addAttribute("tabs", tabs);
		model.addAttribute("permissions",permissions);
		
	 return "role";
	}
	
	
	// This method handles the request to get the user_list from the database.
		@RequestMapping(value = "/addPermission", method=RequestMethod.POST)
		public String addPermission(@ModelAttribute("permission")Permission permission, ModelMap model,BindingResult result ) {
			Long id = dbService.addPermission(permission);
			
			if(id != null){
			  log.info("Role Permission " + permission.getId());
			}
			
			model.addAttribute("permissionId", permission.getId()); 
			// Returning the result to the target jsp.
			return "permission";			
		}
		
		@RequestMapping(value="/permission", method=RequestMethod.GET)
		public String permission(Model model){
			model.addAttribute("permission",new Permission());
		 return "permission";
		}
	
}