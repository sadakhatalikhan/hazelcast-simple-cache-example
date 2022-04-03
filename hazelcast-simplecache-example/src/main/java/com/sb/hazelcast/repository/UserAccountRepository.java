package com.sb.hazelcast.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sb.hazelcast.model.UserAccount;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long>{
	
	UserAccount findByAccountNumber(String accountNumber);

	UserAccount deleteByAccountNumber(String accountNumber);
}
