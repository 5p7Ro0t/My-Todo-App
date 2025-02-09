package com.udemylearning.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
 
@Controller
@SessionAttributes("name")
public class WelcomeController {

	private AuthenticationService authenticationService;
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	public WelcomeController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}
	
	
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String goToWelcomePage(ModelMap model) {
		model.put("name", getLoggedinUsername());
		return "welcome";
	}
	
	
	private String getLoggedinUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		return authentication.getName();
	}
	
	
//	@RequestMapping(value = "/login",method = RequestMethod.POST)
//	public String welcomePage(@RequestParam String name, @RequestParam String password,ModelMap model) {
//		
//		if(authenticationService.authenticate(name, password)) {
//			
//			model.put("name", name);
//			model.put("password", password);
//			return "welcome";
//		}
//		model.put("errorMessage", "Incorrect Username or Password");
//		return "login";
//		
//	}
}