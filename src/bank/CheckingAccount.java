package bank;

import model.Account;
import model.Customer;

public class CheckingAccount extends Account  {
	
	
	public CheckingAccount(Customer owner, String accountNumber) {
		super(owner, accountNumber);
		setInterest(0.01);
		// TODO Auto-generated constructor stub
	}

}
