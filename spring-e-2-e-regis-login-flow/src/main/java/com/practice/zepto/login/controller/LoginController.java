package com.practice.zepto.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.practice.zepto.login.bean.UserInfo;
import com.practice.zepto.login.entity.User;
import com.practice.zepto.login.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@GetMapping("/register")
	public String showRegisterPage() {
		return "register";
	}
	
	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}
	
	@PostMapping("/registerUserDetails")
	public String registerUserDetails(@ModelAttribute UserInfo userInfo, Model model) {
		System.out.println(userInfo.getPhoneNumber());
		String username = loginService.createUser(userInfo);
		model.addAttribute("username", username);
		return "register-success";
	}
	
	@PostMapping("/loginUser")
	public String loginUser(@RequestParam("username") String username, Model model) {
		User user = loginService.credCheck(username);
		model.addAttribute("fName", user.getfName());
		return "login-success";
	}
	
}
