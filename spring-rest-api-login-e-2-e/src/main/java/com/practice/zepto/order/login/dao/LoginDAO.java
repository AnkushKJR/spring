package com.practice.zepto.order.login.dao;

import com.practice.zepto.order.login.entity.User;

public interface LoginDAO {
	public abstract void saveUser(User user);
	public abstract User getUserByUsername(String username);
}
