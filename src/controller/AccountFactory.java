package controller;

import model.Account;
import model.Customer;

public class AccountFactory {
	public Account createAccount(Customer owner,  String accountNumber) {
		return new Account(owner, accountNumber);
	}
}
