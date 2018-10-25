package bank.model;

import model.Account;
import model.ICustomer;

public class SavingAccount extends Account {

	public SavingAccount(ICustomer owner, String accountNumber) {
		super(owner, accountNumber);
		setInterest(0.0325);
	}

}
