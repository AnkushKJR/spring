package com.practice.zepto.order.login.service;

import com.practice.zepto.order.login.bean.UserInfo;

public interface LoginService {
	
	public abstract String createUser(UserInfo userInfo);
	
	public abstract String credCheck(String username, String password);
	
}
