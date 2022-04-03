package com.sb.hazelcast.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb.hazelcast.response.Response;
import com.sb.hazelcast.service.UserBankAccountService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BankController {

	private final UserBankAccountService userBankAccountService;

	// getAll user accounts
	@GetMapping("/user/accounts")
	public ResponseEntity<Response> getAllUserAccounts() {
		return userBankAccountService.getAllUserAccounts();
	}

	// get user account by Id
	@GetMapping("/user/account/{accountNumber}")
	public ResponseEntity<Response> getUserAccount(@PathVariable String accountNumber) {
		return userBankAccountService.getUserAccount(accountNumber);
	}

	// delete user account by Id
	@DeleteMapping("/user/account/{accountNumber}")
	public ResponseEntity<Response> deleteUserAccount(@PathVariable String accountNumber) {
		return userBankAccountService.deleteUserAccount(accountNumber);
	}
}
