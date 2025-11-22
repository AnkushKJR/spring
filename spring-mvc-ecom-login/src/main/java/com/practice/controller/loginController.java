package com.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class loginController {
	
	@RequestMapping("login")
	public String showLoginPage() {
		return "login";
	}
	
	@RequestMapping("loginValidation")
	public String loginValidation(@RequestParam("username") String username, @RequestParam("password") String password) {
		if(username.equals("ankushkjr") && password.equals("test@123")) {
			return "login-success";
		}else {
			return "login-failed";
		}
	}
	
}
