package com.kalyan.java8;

import java.util.List;

public class BankingCustomer {

	int id;
	String name;
	int age;
	String city;
	List<BankingAccount> accounts;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<BankingAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<BankingAccount> accounts) {
		this.accounts = accounts;
	}

	public BankingCustomer(int id, String name, int age, String city, List<BankingAccount> accounts) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.city = city;
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "BankingCustomer [id=" + id + ", name=" + name + ", age=" + age + ", city=" + city + ", accounts="
				+ accounts + "]";
	}

}
