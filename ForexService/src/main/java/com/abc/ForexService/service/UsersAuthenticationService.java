package com.abc.ForexService.service;

import org.springframework.stereotype.Service;

import com.abc.ForexService.entity.Users;

@Service
public interface UsersAuthenticationService {
	public Users login(String email, String password);
	
	
	public String sendEmail(String toEmail);
	public String verifyOtp(String email,String otp);
	public String verifyEmail(String email);


}
