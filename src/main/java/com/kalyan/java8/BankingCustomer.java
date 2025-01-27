package com.kalyan.java8;

import java.util.List;
import java.util.stream.Stream;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data

@RequiredArgsConstructor

public class BankingCustomer {

	int id;
	String name;
	int age;
	String city;
	List<BankingAccount> accounts;

	public BankingCustomer(int id, String name, int age, String city, List<BankingAccount> accounts) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.city = city;
		this.accounts = accounts;
	}
	
	public BankingCustomer(int id, String name, String city, List<BankingAccount> accounts) {
		this.id = id;
		this.name = name;
		this.city = city;
		this.accounts = accounts;
	}


}
