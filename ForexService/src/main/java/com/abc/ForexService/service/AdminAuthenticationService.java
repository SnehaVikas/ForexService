package com.abc.ForexService.service;

import com.abc.ForexService.entity.Admin;

public interface AdminAuthenticationService {
	Admin doLogin(String adminUsername, String adminPassword);
	
	public String sendEmail(String toEmail);
	public String verifyOtp(String adminEmail,String otp);
	public String verifyEmail(String adminEmail);

}
