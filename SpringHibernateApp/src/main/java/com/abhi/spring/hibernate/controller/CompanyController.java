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

import com.abhi.spring.hibernate.bean.Company;
import com.abhi.spring.hibernate.bean.Role;
import com.abhi.spring.hibernate.bean.User;
import com.abhi.spring.hibernate.service.DbService;

@Controller
public class CompanyController {

	@Autowired
	private DbService dbService;			// This will auto-inject the authentication service into the controller.

	private static Logger log = Logger.getLogger(CompanyController.class);

	
	// This method handles the request to get the user_list from the database.
	@RequestMapping(value = "/company_list", method = RequestMethod.GET)
	public ModelAndView fetchCompanyList() {
		List<Company> companyList = dbService.getCompanyList();
		log.info("Total no. of company_records fetched from db are?= " + companyList.size());

		// Returning the result to the target jsp.
		return new ModelAndView("companyList", "companyList", companyList);			
	}
	
	
	// This method handles the request to get the user_list from the database.
		@RequestMapping(value = "/addCompany", method=RequestMethod.POST)
		public String addCompany(@ModelAttribute("company")Company company, ModelMap model,BindingResult result ) {
			Long id = dbService.addCompany(company);
			
			if(id != null){
			  log.info("Company Added " + company.getCompanyName());
			}
			List<Role> roleList = dbService.getRoles();
			model.addAttribute("roles",roleList);
			
			model.addAttribute("name", company.getCompanyName()); 
			// Returning the result to the target jsp.
			return "company";			
		}
	
		
		/***
		 * Returns the edit form
		 * @param model
		 * @return
		 */
	
	@RequestMapping(value="/company", method=RequestMethod.GET)
	public String company(Model model){
		/*List<Role> roleList = dbService.getRoles(); 
		model.addAttribute("roles",roleList); */
		model.addAttribute("company",new Company());
	 return "company";
	} 
	
	/***
	 * gets user with give id and 
	 * redirects it to edit form
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/editCompany/{id}")  
    public String edit(@PathVariable Long id,Model model){  
        Company company=dbService.getCompanyById(id); 
      /*  List<Role> roleList = dbService.getRoles();
		model.addAttribute("roles",roleList);*/
        model.addAttribute("company", company);
        return "company";  
    }  
	
	/*This method handles the request to get the user_list from the database.*/
	@RequestMapping(value = "/updateCompany", method=RequestMethod.POST)
	public String updateCompany(@ModelAttribute("company")Company company, ModelMap model,BindingResult result ) {
		 dbService.updateCompany(company);
		/* List<Role> roleList = dbService.getRoles();
	     model.addAttribute("roles",roleList);*/
		 model.addAttribute("name", company.getCompanyName()); 
		 // Returning the result to the target jsp.
		 return "company";			
	}
	
	
	/*This method handles the request to get the user_list from the database.*/
	@RequestMapping(value = "/deleteCompany/{id}", method=RequestMethod.GET)
	public ModelAndView deleteCompany(@PathVariable Long id ) {
		 dbService.deleteCompany(id);
		 List<Company> clist = dbService.getCompanyList();
			log.info("Total no. of company_records fetched from db are?= " + clist.size());

			// Returning the result to the target jsp.
			return new ModelAndView("companyList", "companyList", clist);		
				
	}
}