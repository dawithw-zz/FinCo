package model;

import java.util.ArrayList;
import java.util.List;

public class Account extends AbstractAccount {
	
	public Account(ICustomer owner, String accountNumber) {
		addOwner(owner);
		this.accountNumber = accountNumber;
		super.interest = 0.01;
	}
}
