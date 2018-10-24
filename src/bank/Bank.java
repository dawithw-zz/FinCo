package bank;

import controller.*;
import model.IAccount;
import model.ICustomer;
import view.*;

public class Bank extends FinCo{
	
	private static ICustomer customer;

	public static void createPersonalCheckingAccount(AccountParameters param) {
		//createCustomerAccount(param, PersonFactory.getInstance(), CheckingAccountFactory.getInstance());
		createPerson(param);
		customer = getCustomer();
		createCheckingAccount(BankAccountFactory.getBankAccountFactory(),param.getAccountNumber());
	}
	
	public static void createPersonalSavingAccount(AccountParameters param) {
		createPerson(param);
		customer = getCustomer();
		createSavingAccount(BankAccountFactory.getBankAccountFactory(),param.getAccountNumber());
	}
	
	public static void createCompanyCheckingAccount(AccountParameters param) {
		createCompany(param);
		customer = getCustomer();
		createCheckingAccount(BankAccountFactory.getBankAccountFactory(),param.getAccountNumber());	
		}
	
	public static void createCompanySavingAccount(AccountParameters param) {
		createCompany(param);
		customer = getCustomer();
		createSavingAccount(BankAccountFactory.getBankAccountFactory(),param.getAccountNumber());	
	}
	
	private static void createCheckingAccount(BankAccountFactory bFactory, String accountNumber ) {
		IAccount account = bFactory.createCheckingAccount(customer, accountNumber);
		customer.addAccount(account); 
	}
	
	private static void createSavingAccount(BankAccountFactory bFactory, String accountNumber ) {
		IAccount account = bFactory.createSavingAccount(customer, accountNumber);
		customer.addAccount(account); 
	}
	
}
