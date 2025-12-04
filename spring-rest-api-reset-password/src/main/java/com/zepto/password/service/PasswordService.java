package com.zepto.password.service;

import org.springframework.http.ResponseEntity;

import com.zepto.password.request.PasswordResetRequest;

public interface PasswordService {
	
	public abstract ResponseEntity resetPassword(String userId, PasswordResetRequest passwordResetRequest);
	
}
