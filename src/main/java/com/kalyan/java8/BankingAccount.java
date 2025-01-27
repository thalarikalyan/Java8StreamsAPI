package com.kalyan.java8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor

public class BankingAccount {

	int accountId;
	String accountType; // "SAVINGS", "CURRENT", "LOAN"
	double balance;
	public BankingAccount(int accountId, String accountType, double balance) {
		this.accountId = accountId;
		this.accountType = accountType;
		this.balance = balance;
	}
	
	

}
