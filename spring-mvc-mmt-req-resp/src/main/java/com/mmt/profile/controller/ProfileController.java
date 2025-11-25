package com.mmt.profile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mmt.profile.bean.UserProfile;

@Controller
public class ProfileController {
	
	@RequestMapping("/createProfilePage") 
	public String createProfilePage() {
		return "createProfilePage";
	}
	
	@PostMapping("/profileCreation")
	public String profileCreation(@ModelAttribute UserProfile userProfile, Model model) {
		String email = userProfile.getEmail();
		String phoneNumber = userProfile.getPhoneNumber();
		
		String userId = generateUserId(email, phoneNumber);
		
		model.addAttribute("userId", userId);
		
		return "login-success";
	}
	
	public static String generateUserId(String email, String phoneNumber) {
		String username = email.split("@")[0];
		String first4 = username.length() >= 4 ? username.substring(0, 4) : username;
		String last4 = phoneNumber.substring(phoneNumber.length() - 4);
		return first4 + last4;
	}

}
