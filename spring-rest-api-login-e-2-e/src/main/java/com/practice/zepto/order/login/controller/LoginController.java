package com.practice.zepto.order.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.zepto.order.login.bean.UserInfo;
import com.practice.zepto.order.login.service.LoginServiceImpl;

@RestController
public class LoginController {
	
	@Autowired
	LoginServiceImpl loginServiceImpl;
	
	@GetMapping("/registerPage")
	public String showRegisterPage() {
		return "registerPage";
	}
	
	@GetMapping("/loginPage")
	public String showLoginPage() {
		return "loginPage";
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody UserInfo userInfo) {
		String username = loginServiceImpl.createUser(userInfo);
		return ResponseEntity.ok(username);
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("username") String username,@RequestParam("password") String password) {
		String msg = loginServiceImpl.credCheck(username, password);
		return msg;
	}
	
}
