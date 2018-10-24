package bank;

import controller.AccountFactory;
import model.Customer;
import model.IAccount;
import model.ICustomer;

public class BankAccountFactory extends AccountFactory {

	private static BankAccountFactory instance = new BankAccountFactory();
	
	private BankAccountFactory() {
		
	}
	
	public static BankAccountFactory getBankAccountFactory() {
		return instance;
	}
	
	public IAccount createCheckingAccount(ICustomer owner,  String accountNumber) {
		return new CheckingAccount(owner, accountNumber);
	}
	
	public IAccount createSavingAccount(ICustomer owner, String accountNumber) {
		return new SavingAccount(owner, accountNumber);
	}
}
