package bank;

import controller.AccountFactory;
import model.Account;
import model.Customer;

public class CheckingAccountFactory extends AccountFactory {
	private static CheckingAccountFactory instance = new CheckingAccountFactory();
	
	protected CheckingAccountFactory() {
	}
	
	public Account createAccount(Customer owner,  String accountNumber) {
		return new CheckingAccount(owner, accountNumber);
	}
	
	public static AccountFactory getInstance() {
		return instance;
	}
}
