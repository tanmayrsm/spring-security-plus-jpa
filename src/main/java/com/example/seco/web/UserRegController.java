package com.example.seco.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.seco.service.UserService;
import com.example.seco.web.dto.UserRegistrationDTO;

@Controller
@RequestMapping("/registration")
public class UserRegController {
	
	@Autowired
	private UserService userService;
	
	@ModelAttribute("user")	// passed in html file
	public UserRegistrationDTO userRegistrationDTO() {
		return new UserRegistrationDTO();
	}
	
	@GetMapping
	public String showRegForm() {
		return "registration";
	}
	
	@PostMapping
	public String registerAccount(@ModelAttribute("user") UserRegistrationDTO userReg) {
		userService.save(userReg);
		return "redirect:/registration?success";
	}
}
