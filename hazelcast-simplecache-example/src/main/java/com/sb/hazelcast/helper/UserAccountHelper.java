package com.sb.hazelcast.helper;

import org.springframework.stereotype.Component;

import com.sb.hazelcast.dto.UserAccountDTO;
import com.sb.hazelcast.model.UserAccount;
import com.sb.hazelcast.request.UserAccountRequest;

@Component
public class UserAccountHelper {
	
	public UserAccount modelMapper(UserAccountRequest userAccount) {
		return UserAccount.builder()
				.accountNumber(userAccount.getAccountNumber())
				.address(userAccount.getAddress())
				.balance(userAccount.getBalance())
				.name(userAccount.getName())
				.build();
	}
	
	public UserAccountDTO dtoMapper(UserAccount account) {
		return UserAccountDTO.builder()
				.id(account.getId())
				.name(account.getName())
				.accountNumber(account.getAccountNumber())
				.address(account.getAddress())
				.balance(account.getBalance())
				.createDate(account.getCreateDate())
				.modifyDate(account.getModifyDate())
				.build();
	}
	
}
