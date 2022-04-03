package com.sb.hazelcast.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sb.hazelcast.helper.UserAccountHelper;
import com.sb.hazelcast.model.UserAccount;
import com.sb.hazelcast.repository.UserAccountRepository;
import com.sb.hazelcast.response.Response;
import com.sb.hazelcast.service.UserBankAccountService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserBankAccountServiceImpl implements UserBankAccountService {

	private final UserAccountRepository repo;
	private final UserAccountHelper helper;

	@Override
	@Cacheable(cacheNames = {"useraccountcache"})
	public ResponseEntity<Response> getAllUserAccounts() {
		List<UserAccount> listObj = repo.findAll();
		return ResponseEntity.ok().body(Response.builder().code(0).message("Data loaded")
				.body(listObj.stream().map(account -> helper.dtoMapper(account)).collect(Collectors.toList())).build());
	}

	@Override
	@Cacheable(value = "useraccountcache", key = "#id", unless = "#result==null")
	public ResponseEntity<Response> getUserAccount(String accountNumber) {
		UserAccount account = repo.findByAccountNumber(accountNumber);
		return ResponseEntity.ok().body(Response.builder().code(0).message("Data loaded")
				.body(helper.dtoMapper(account)).build());
	}

	@Override
	@CacheEvict(value = "useraccountcache")
	public ResponseEntity<Response> deleteUserAccount(String accountNumber) {
		UserAccount account = repo.deleteByAccountNumber(accountNumber);
		return ResponseEntity.ok().body(Response.builder().code(0).message("Data deleted")
				.body(helper.dtoMapper(account)).build());
	}

}
