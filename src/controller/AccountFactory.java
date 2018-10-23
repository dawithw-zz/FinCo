package controller;

import model.Account;
import model.Customer;

public class AccountFactory {
	private static AccountFactory instance = new AccountFactory();
	
	private AccountFactory() {
		// should not be invoked except by instance
	}
	
	public Account createAccount(Customer owner,  String accountNumber) {
		return new Account(owner, accountNumber);
	}
	
	public static AccountFactory getInstance() {
		return instance;
	}
}
