package com.sb.hazelcast.service;

import org.springframework.http.ResponseEntity;

import com.sb.hazelcast.response.Response;

public interface UserBankAccountService {
	
	ResponseEntity<Response> getAllUserAccounts();
	
	ResponseEntity<Response> getUserAccount(String accountNumber);
	
	ResponseEntity<Response> deleteUserAccount(String accountNumber);
}
