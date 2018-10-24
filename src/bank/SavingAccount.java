package bank;

import model.Account;
import model.Customer;

public class SavingAccount extends Account {

	public SavingAccount(Customer owner, String accountNumber) {
		super(owner, accountNumber);
		setInterest(0.0325);
		// TODO Auto-generated constructor stub
	}

}
