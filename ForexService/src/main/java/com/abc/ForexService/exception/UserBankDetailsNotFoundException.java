package com.abc.ForexService.exception;

public class UserBankDetailsNotFoundException extends RuntimeException {
	
	public UserBankDetailsNotFoundException (String msg)
	{
		super(msg);
	}
}
