package com.mmt.profile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mmt.profile.Bean.UserProfile;

@Controller
public class ProfileController {
	
	@RequestMapping("/createProfilePage")
	public String createProfilePage() {
		return "createProfilePage";
	}
	
	@PostMapping("/createProfile")
	public String createProfile(@ModelAttribute UserProfile userProfile, Model model) {
		String fName = userProfile.getfName();
		String lName = userProfile.getlName();
		String email = userProfile.getEmail();
		String phoneNumber = userProfile.getPhoneNumber();
		
		System.out.println(fName);
		System.out.println(lName);
		System.out.println(email);
		System.out.println(phoneNumber);
		
		String userId = generateUserId(email, phoneNumber);
		
		model.addAttribute("userId", userId);
		
		return "profileResponsePage";
		
	}
	
	public static String generateUserId(String email, String mobile) {
		String username = email.split("@")[0];
		String first4 = username.length() >= 4 ? username.substring(0, 4) : username;
		String last4 = mobile.substring(mobile.length() - 4);
		return first4 + last4;
	}

}


