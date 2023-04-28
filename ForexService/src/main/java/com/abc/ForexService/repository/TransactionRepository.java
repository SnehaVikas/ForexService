package com.abc.ForexService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.ForexService.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer>{
    
	Optional<Transaction> findById(int transcationId);
}
