package controller;

import model.Account;
import model.Customer;

public class AccountFactory {
	private static AccountFactory instance = new AccountFactory();
	public Account createAccount(Customer owner,  String accountNumber) {
		return new Account(owner, accountNumber);
	}
	public static AccountFactory getInstance() {
		return instance;
	}
}
