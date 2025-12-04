package com.zepto.password.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.zepto.password.dao.PasswordDAOImpl;
import com.zepto.password.entity.User;
import com.zepto.password.exception.RecentPasswordUsedException;
import com.zepto.password.request.PasswordResetRequest;
import com.zepto.password.response.SuccessResponse;

@Service
public class PasswordServiceImpl implements PasswordService{
	
	@Autowired
	PasswordDAOImpl passwordDAOImpl;
	
	@Override
	public ResponseEntity resetPassword(String userId, PasswordResetRequest passwordResetRequest) {
		
		List<String> passwords = passwordDAOImpl.getPasswordByUserId(userId);
		
		Boolean isPasswordUsedBefore = passwords.contains(passwordResetRequest.getNew_password());
		
		if(isPasswordUsedBefore == true) {
			throw new RecentPasswordUsedException("New password cannot be one of the last 3 used passwords.");
		}else {
			User user = new User();
			user.setUserId(userId);
			user.setPassword(passwordResetRequest.getNew_password());
			passwordDAOImpl.updateUserPassword(user);
			
			String currentPassword = passwordDAOImpl.getCurrentUserPassword(userId); 

            if (currentPassword == null) {
                return ResponseEntity.internalServerError().body("Error: Could not retrieve current password hash.");
            }

            String newPassword = passwordResetRequest.getNew_password();
            
            passwordDAOImpl.updatePasswordInOneTransaction(userId, currentPassword, newPassword);
			
			SuccessResponse successResponse = new SuccessResponse();
			successResponse.setStatus("SUCCESS");
			successResponse.setMessage("password reset successful");
			return ResponseEntity.ok(successResponse);
		}
		
	}
	

}
