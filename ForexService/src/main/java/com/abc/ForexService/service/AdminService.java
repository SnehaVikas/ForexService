package com.abc.ForexService.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.abc.ForexService.dto.AdminDto;
import com.abc.ForexService.dto.ExchangeRateDto;
import com.abc.ForexService.entity.Admin;
import com.abc.ForexService.entity.ExchangeRate;
import com.abc.ForexService.entity.Users;
import com.abc.ForexService.exception.InvalidInputException;
@Service
public interface AdminService {
	AdminDto saveAdmin(AdminDto adminDto);
	public ExchangeRateDto saveExchangeRate(ExchangeRateDto exchangeRateDto);
	public ExchangeRate updateExchangeRate(ExchangeRate exchangeRate);

	
	String resetPassword(String adminEmail, String adminPassword, String newPassword) throws InvalidInputException;
	
	String resetForgotPassword(String adminEmail, String newPassword, String confirmPassword) throws InvalidInputException;
	public List<Admin> getAllAdmin();

}
