package bank;

import model.Account;
import model.Customer;
import model.ICustomer;

public class CheckingAccount extends Account  {
	
	
	public CheckingAccount(ICustomer owner, String accountNumber) {
		super(owner, accountNumber);
		setInterest(0.01);
		// TODO Auto-generated constructor stub
	}

}
