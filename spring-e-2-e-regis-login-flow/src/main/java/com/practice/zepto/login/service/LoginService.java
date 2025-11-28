package com.practice.zepto.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.zepto.login.bean.UserInfo;
import com.practice.zepto.login.dao.LoginDAO;
import com.practice.zepto.login.entity.User;

@Service
public class LoginService {
	
	@Autowired
	LoginDAO loginDAO;
	
	public String createUser(UserInfo userInfo) {
		
		System.out.println("LoginService:::createUser");
		
		User user = new User();
		String username = generateUsername(userInfo.getfName(), userInfo.getPhoneNumber());
		
		user.setUsername(username);
		user.setfName(userInfo.getfName());
		user.setlName(userInfo.getlName());
		user.setPhoneNumber(userInfo.getPhoneNumber());
		user.setAddress(userInfo.getAddress());
		
		loginDAO.saveUser(user);
		
		return username;
	}
	
	private String generateUsername(String fName, String phoneNumber) {
        // clean name
        String cleanName = fName.trim().toLowerCase();

        // get last 4 or 5 digits safely
        String lastDigits = phoneNumber.length() >= 4
                ? phoneNumber.substring(phoneNumber.length() - 4)
                : phoneNumber; 

        return cleanName + lastDigits;
    }
	
	public User credCheck(String username) {
		User user = loginDAO.getUserByUsername(username);
		return user;
	}

}
