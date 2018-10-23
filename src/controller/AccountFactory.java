package controller;

import model.Account;
import model.Customer;

public class AccountFactory {
	public Account createAccount(Customer owner,  long accountNumber) {
		return new Account(owner, accountNumber);
	}
}
