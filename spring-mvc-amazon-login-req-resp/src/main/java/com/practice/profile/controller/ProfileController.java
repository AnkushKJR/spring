package com.practice.profile.controller;

import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.practice.profile.bean.UserProfile;

@Controller
public class ProfileController {
	
	@RequestMapping("/login")
	public ModelAndView showLogin() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@PostMapping("/loginValidation")
	public String loginValidation(@ModelAttribute UserProfile userProfile, Model model) {
		if(userProfile.getUsername().equals("ak12345") && userProfile.getPassword().equals("test@123")) {
			String sessionId = UUID.randomUUID().toString();
			model.addAttribute("sessionId", sessionId);
			return "login-success";
		}else {
			return "login-fail";
		}
	}
	
}
