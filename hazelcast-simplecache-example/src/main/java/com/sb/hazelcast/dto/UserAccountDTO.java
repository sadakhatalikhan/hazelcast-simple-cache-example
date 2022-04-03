package com.sb.hazelcast.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder(toBuilder = true)
public class UserAccountDTO {

	private Long id;
	private String accountNumber;
	private String name;
	private String address;
	private Float balance;
	private Date createDate;
	private Date modifyDate;

}