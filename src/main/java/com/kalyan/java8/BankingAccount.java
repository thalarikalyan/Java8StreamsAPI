package com.kalyan.java8;

public class BankingAccount {

	int accountId;
	String accountType; // "SAVINGS", "CURRENT", "LOAN"
	double balance;

	@Override
	public String toString() {
		return "BankingAccount [accountId=" + accountId + ", accountType=" + accountType + ", balance=" + balance + "]";
	}

	public BankingAccount(int accountId, String accountType, double balance) {
		super();
		this.accountId = accountId;
		this.accountType = accountType;
		this.balance = balance;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
