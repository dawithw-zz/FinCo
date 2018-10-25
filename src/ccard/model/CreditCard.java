package ccard.model;

import model.Account;
import model.ICustomer;

public abstract class CreditCard extends Account{

	public CreditCard(ICustomer owner, String accountNumber) {
		super(owner, accountNumber);
		// TODO Auto-generated constructor stub
	}

}
