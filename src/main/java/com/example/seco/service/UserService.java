package com.example.seco.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.seco.model.User;
import com.example.seco.web.dto.UserRegistrationDTO;

public interface UserService extends UserDetailsService{ // UserDetailsService of spirng.security
	User save(UserRegistrationDTO regDTO);
}
