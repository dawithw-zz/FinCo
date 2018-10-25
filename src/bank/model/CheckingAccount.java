package bank.model;

import model.Account;
import model.ICustomer;

public class CheckingAccount extends Account  {
	
	
	public CheckingAccount(ICustomer owner, String accountNumber) {
		super(owner, accountNumber);
		setInterest(0.01);
	}

}
