package com.zepto.password.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zepto.password.request.PasswordResetRequest;
import com.zepto.password.service.PasswordServiceImpl;

@RestController
public class PasswordController {
	
	@Autowired
	PasswordServiceImpl passwordServiceImpl;
	
	@PostMapping("/resetPassword/{userId}")
	public ResponseEntity resetPassword(@PathVariable("userId") String userId, @RequestBody PasswordResetRequest passwordResetRequest) {
		
		ResponseEntity responseEntity = passwordServiceImpl.resetPassword(userId, passwordResetRequest);
		return ResponseEntity.ok(responseEntity.getBody());		
	}

}
