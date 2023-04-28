package com.abc.ForexService.repository;

import java.util.Optional;

import org.springframework.boot.autoconfigure.security.saml2.Saml2RelyingPartyProperties.AssertingParty.Verification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.ForexService.entity.AdminVerification;

@Repository
public interface AdminVerificationRepository extends JpaRepository<AdminVerification,Integer> {

	public Optional<AdminVerification> findByAdminEmail(String adminEmail);
//	public void deleteByUserName(String userName);
	

}
