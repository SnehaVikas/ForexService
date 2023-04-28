package com.abc.ForexService.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.abc.ForexService.dto.UserBankDetailsDto;
import com.abc.ForexService.entity.UserBankDetails;

@Service
public interface IUserBankDetailsService {
public UserBankDetailsDto saveBankDetails(UserBankDetailsDto bankDto) ;
	
	public List<UserBankDetails> getAllBankDetails();
	
}
