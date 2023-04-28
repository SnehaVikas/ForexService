package com.abc.ForexService.exception;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(UsersNotFoundException.class)
	public ResponseEntity<String> handleUsersNotFoundException(Exception e){

         ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
         return responseEntity;
       
    }
	@ExceptionHandler(TransactionNotFoundException.class)
	public ResponseEntity<String> handleTransactionNotFoundException(Exception e) {
		ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		return responseEntity;
	}
	@ExceptionHandler(AdminNotFoundException.class)
	public ResponseEntity<String> handleAdminNotFoundException(Exception e) {
		ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		return responseEntity;
	}

	@ExceptionHandler(UserBankDetailsNotFoundException.class)
	public ResponseEntity<String> UserBankDetailsNotFoundException(Exception e) {
		ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		return responseEntity;
	}
	@ExceptionHandler(AdminEmailNotExisting.class)
	public ResponseEntity<String> AdminEmailNotExistingFoundException(Exception e) {
		ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		return responseEntity;
	}

	@ExceptionHandler(InvalidAccountException.class)
	public ResponseEntity<String> InvalidAccountException(Exception e) {
		ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		return responseEntity;
	}

	@ExceptionHandler(ExchangeRateNotFoundException.class)
	public ResponseEntity<String> handleExchangeRateNotFoundException(Exception e) {
		ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		return responseEntity;

	}

	
	@ExceptionHandler(UsersAuthenticationFailureException.class)
	public ResponseEntity<String> handleUsersAuthenticationFailureException(Exception e){

         ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
         return responseEntity;
       
    }
	@ExceptionHandler(UsersEmailNotExistingException.class)
	 public ResponseEntity<String> UsersEmailNotExistingException(Exception e) {
		ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		return responseEntity;
 }
	
	
	@ExceptionHandler(InvalidInputException.class)
	 public ResponseEntity<String> UsersInvalidInputException(Exception e) {
		ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		return responseEntity;
}
	
}


//	@ExceptionHandler(AdminAuthenticationFailureException.class)
//	public ResponseEntity<String> handleAdminAuthenticationException(Exception e)
//	{
//		ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
//		return responseEntity;
//	}
//	@ExceptionHandler(AdminNotFoundException.class)
//	public ResponseEntity<String> handleAdminNotFoundException(Exception e)
//	{
//		ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
//		return responseEntity;
//	}
//	
//	@ExceptionHandler(ExchangeRateNotFoundException.class)
//	public ResponseEntity<String> handleExchangeRateNotFoundException(Exception e)
//	{
//		ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
//		return responseEntity;
//	}
//	
//	@ExceptionHandler(TransactionNotFoundException.class)
//	public ResponseEntity<String> handleTransactionNotFoundException(Exception e)
//	{
//		ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
//		return responseEntity;
//	}
//	@ExceptionHandler(InvalidInputException.class)
//	public ResponseEntity<String> handleInvalidInputException1(Exception e)
//	{
//		ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
//		return responseEntity;
//	}
//	@ExceptionHandler(AdminEmailNotExisting.class)
//	public ResponseEntity<String> handleAdminEmailNotExisting(Exception e)
//	{
//		ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
//		return responseEntity;
//	}
//
//		
//	@Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//            HttpHeaders headers, HttpStatus status, WebRequest request) {
// 
//        Map<String, Object> body = new LinkedHashMap<>();
////        body.put("timestamp", new Date());
//        body.put("status", status.value());
// 
//        // Get all errors
//        List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.toList());
// 
//        body.put("errors", errors);
// 
//        return new ResponseEntity<>(body, headers, status);
//    }
//
//
//}
