package com.abc.ForexService.service;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.abc.ForexService.dto.ExchangeRateDto;
import com.abc.ForexService.entity.Admin;
import com.abc.ForexService.entity.ExchangeRate;
import com.abc.ForexService.exception.AdminNotFoundException;
import com.abc.ForexService.exception.ExchangeRateNotFoundException;
import com.abc.ForexService.repository.AdminRepository;
import com.abc.ForexService.repository.ExchangeRateRepository;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {
	@Autowired
	private ExchangeRateRepository exchangeRateRepository;
@Autowired
private AdminRepository adminRepository;
@Autowired
private MessageSource messageSource;
	
@Override
public ExchangeRateDto saveExchangeRate(ExchangeRateDto exchangeRateDto) {
	// TODO Auto-generated method stub
	ExchangeRate exRate =new ExchangeRate();
    exRate.setId(exchangeRateDto.getId());
     exRate.setFromCurrency(exchangeRateDto.getFromCurrency());
     exRate.setToCurrency(exchangeRateDto.getToCurrency());
     exRate.setRate(exchangeRateDto.getRate());
     exRate.setDate(exchangeRateDto.getDate());
    
	Optional<Admin> optionalAdmin = adminRepository.findById(exchangeRateDto.getAdminId());
	if (optionalAdmin.isEmpty()) {

		throw new AdminNotFoundException(" admin is not exists");

		}
	
         Admin admin=optionalAdmin.get();
          exRate.setAdmin(admin);
         ExchangeRate newExchangeRate = exchangeRateRepository.save(exRate);


         //exchangeRateDto.setId(exRate.getId());

	return exchangeRateDto;
}

@Override
public Double convertAmount(Double amount, String fromCurrency, String toCurrency) {
	
	ExchangeRate exchangeRate = exchangeRateRepository.findByFromCurrencyAndToCurrency(fromCurrency, toCurrency);
	if (exchangeRate == null) {

		throw new ExchangeRateNotFoundException("Excahnge Rate Not found " +" "+ fromCurrency + "/" + toCurrency);
	}
	Double rate = exchangeRate.getRate();

	return rate * amount;
}


//To get all the rates by entering date
@Override
public List<ExchangeRate> getRatesByDate(String dateString) throws ExchangeRateNotFoundException {
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	LocalDate date = LocalDate.parse(dateString, formatter);
	List<ExchangeRate> exchangeRates = exchangeRateRepository.findByDate(date);
	if (exchangeRates.isEmpty()) {

		throw new ExchangeRateNotFoundException("exchangeRatenotfound" + date);
	}
	
	
	return exchangeRates;
}

//To get rates by providing from currency and to currency and date
@Override
public List<ExchangeRate> getRatesByFromToCurrencyAndDate(String fromCurrency, String toCurrency, LocalDate date)
		throws ExchangeRateNotFoundException {
	
	List<ExchangeRate> exchangeRates = exchangeRateRepository.findByFromCurrencyAndToCurrencyAndDate(fromCurrency,
			toCurrency, date);
	if (exchangeRates.isEmpty()) {

		throw new ExchangeRateNotFoundException("exchangeRate.not.found" +" "+ fromCurrency + "/" + toCurrency + " "+ date + "");
	}
	return exchangeRates;

}
//To update the rates
@Override
public ExchangeRate updateExchangeRate(ExchangeRate exchangeRate)throws ExchangeRateNotFoundException {
	
	Optional<ExchangeRate> optionalExchangeRate = exchangeRateRepository.findById(exchangeRate.getId());
	if (optionalExchangeRate.isEmpty()) {
		throw new ExchangeRateNotFoundException("Rate not existing with id:" + exchangeRate.getId());
	}
	ExchangeRate updatedExchangeRate = exchangeRateRepository.save(exchangeRate);
	return updatedExchangeRate;
}

@Override
public ExchangeRate getById(int Id)throws ExchangeRateNotFoundException {
	Optional<ExchangeRate> optionalExchangeRate = exchangeRateRepository.findById(Id);
	if (optionalExchangeRate.isEmpty()) {
		throw new ExchangeRateNotFoundException("exchangeRate.not.found"+Id);
	}
	ExchangeRate exchangeRate = optionalExchangeRate.get();

	return exchangeRate;
}

@Override
public List<ExchangeRate> findAllRates() {
	List<ExchangeRate> exchangeRate = exchangeRateRepository.findAll();
	return exchangeRate;
	
}


}