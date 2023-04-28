package com.abc.ForexService.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.abc.ForexService.dto.TransactionDto;
import com.abc.ForexService.entity.Transaction;


@Service
public interface TransactionService {
	   public TransactionDto saveTransaction(TransactionDto transactionDto);
		
		public Transaction getTransactionById(int transactionId);
		
		public TransactionDto findTransactionById(int transactionId);
		
     public List<Transaction> getAllTransactions();
			
}