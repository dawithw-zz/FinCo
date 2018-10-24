package bank;

import controller.AccountFactory;
import model.Account;
import model.Customer;

public class SavingAccountFactory extends AccountFactory {
	private static SavingAccountFactory instance = new SavingAccountFactory();
	
	protected SavingAccountFactory() {
	}
	
	public Account createAccount(Customer owner,  String accountNumber) {
		return new SavingAccount(owner, accountNumber);
	}
	
	public static AccountFactory getInstance() {
		return instance;
	}

}
