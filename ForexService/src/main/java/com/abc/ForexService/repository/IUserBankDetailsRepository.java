package com.abc.ForexService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.ForexService.entity.UserBankDetails;

@Repository
	public interface IUserBankDetailsRepository extends JpaRepository<UserBankDetails,Integer> {
		 Optional<UserBankDetails> findByAccountNumber(long accountNumber);
		 
	}
