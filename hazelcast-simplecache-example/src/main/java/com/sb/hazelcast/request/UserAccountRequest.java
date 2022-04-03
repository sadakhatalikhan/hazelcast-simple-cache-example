package com.sb.hazelcast.request;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder(toBuilder = true)
public class UserAccountRequest implements Serializable{
	
	private static final long serialVersionUID = -2785556362397151673L;
	
	private String accountNumber;
	private String name;
	private String address;
	private Float balance;
}