package bank;

import controller.*;
import view.*;

public class Bank extends FinCo{
	
	public static void createPersonalCheckingAccount(AccountParameters param) {
		createCustomerAccount(param, PersonFactory.getInstance(), CheckingAccountFactory.getInstance());
	}
	
	public static void createPersonalSavingAccount(AccountParameters param) {
		createCustomerAccount(param, PersonFactory.getInstance(), SavingAccountFactory.getInstance());
	}
	
	public static void createCompanyCheckingAccount(AccountParameters param) {
		createCustomerAccount(param, CompanyFactory.getInstance(), CheckingAccountFactory.getInstance());
	}
	
	public static void createCompanySavingAccount(AccountParameters param) {
		createCustomerAccount(param, CompanyFactory.getInstance(), SavingAccountFactory.getInstance());
	}
	
}
