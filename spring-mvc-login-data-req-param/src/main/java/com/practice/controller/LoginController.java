package com.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String showLoginPage() {
		return "login";
	}
	
	@RequestMapping("/loginValidation")
	public String loginValidation(@RequestParam("email") String email, @RequestParam("password") String password) {
		if(email.equals("ak@gmail.com") && password.equals("123456789")) {
			return "login-success";
		}else {
			return "login-failed";
		}
	}
	
}
