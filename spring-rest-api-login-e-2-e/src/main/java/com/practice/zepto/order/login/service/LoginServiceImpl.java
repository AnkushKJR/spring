package com.practice.zepto.order.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.zepto.order.login.bean.UserInfo;
import com.practice.zepto.order.login.dao.LoginDAOImpl;
import com.practice.zepto.order.login.entity.User;


@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	LoginDAOImpl loginDAOImpl;
	
	@Override
	public String createUser(UserInfo userInfo) {
		System.out.println("LoginServiceImpl::::createUser");
		
		String username = generateUsername(userInfo.getfName(), userInfo.getPhoneNumber());
		
		User user = new User();
		
		user.setUsername(username);
		user.setfName(userInfo.getfName());
		user.setlName(userInfo.getlName());
		user.setPhoneNumber(userInfo.getPhoneNumber());
		user.setPassword(userInfo.getPassword());
		
		loginDAOImpl.saveUser(user);
		
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
	
	public String credCheck(String username, String password) {
		User user = loginDAOImpl.getUserByUsername(username);
		if(user.getPassword().equals(password)) {
			return "Login success";
		}else {
			return "login failed";
		}
	}

}
