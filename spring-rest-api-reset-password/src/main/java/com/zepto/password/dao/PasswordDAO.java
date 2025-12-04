package com.zepto.password.dao;

import java.util.List;

import com.zepto.password.entity.User;

public interface PasswordDAO{
	
	public abstract List<String> getPasswordByUserId(String userId);
	
	public abstract void updateUserPassword(User user);
	
	public abstract String getCurrentUserPassword(String userId);
	
	public abstract void updatePasswordInOneTransaction(String userId, String currentPassword, String newPassword);
	
}
