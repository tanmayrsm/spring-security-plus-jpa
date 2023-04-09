package com.example.seco.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/login")
	public String login() {
		// return 'login' thymeleaf template
		return "login";	//login.html from ur template
	}
	
	@GetMapping("/")
	public String home() {
		// return 'index' thymeleaf template
		return "index"; 	//index.html from ur template
	}
	

}
