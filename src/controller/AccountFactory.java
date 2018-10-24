package controller;

import model.Account;
import model.Customer;
import model.ICustomer;

public class AccountFactory {
	private static AccountFactory instance = new AccountFactory();
	
	protected AccountFactory() {
		// should not be invoked except by instance
	}
	
	public Account createAccount(ICustomer owner,  String accountNumber) {
		return new Account(owner, accountNumber);
	}
	
	public static AccountFactory getAccountFactory() {
		return instance;
	}
}
