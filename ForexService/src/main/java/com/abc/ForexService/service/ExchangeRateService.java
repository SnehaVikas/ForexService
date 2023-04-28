package com.abc.ForexService.service;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.abc.ForexService.dto.ExchangeRateDto;
import com.abc.ForexService.entity.ExchangeRate;

@Service
public interface ExchangeRateService {

	public ExchangeRateDto saveExchangeRate(ExchangeRateDto exchangeRateDto);
	Double convertAmount(Double amount,String fromCurrency, String toCurrency);
	public ExchangeRate updateExchangeRate(ExchangeRate exchangeRate);
	public ExchangeRate getById(int Id);
			
//	To get all the rates by entering date
	List<ExchangeRate> getRatesByDate(String dateString);

//	To get rates by providing from currency and to currency and date
	List<ExchangeRate> getRatesByFromToCurrencyAndDate(String fromCurrency, String toCurrency, LocalDate date);
	
	
//To get all Rates	
	public List<ExchangeRate> findAllRates();

	}
