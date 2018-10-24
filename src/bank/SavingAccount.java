package bank;

import model.Account;
import model.Customer;
import model.ICustomer;

public class SavingAccount extends Account {

	public SavingAccount(ICustomer owner, String accountNumber) {
		super(owner, accountNumber);
		setInterest(0.0325);
		// TODO Auto-generated constructor stub
	}

}
