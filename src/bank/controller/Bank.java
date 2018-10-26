package bank.controller;

import javax.swing.UIManager;

import bank.view.BankWindow;
import controller.*;
import model.IAccount;
import model.ICustomer;
import view.*;

public class Bank extends FinCo{

	/*****************************************************
	 * The entry point for this application.
	 * Sets the Look and Feel to the System Look and Feel.
	 * Creates a new MainWindow and makes it visible.
	 *****************************************************/
	public static void main(String args[])
	{
		try {
		    // Add the following code if you want the Look and Feel
		    // to be set to the Look and Feel of the native system.
		    
		    try {
		        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		    } 
		    catch (Exception e) { 
		    }
		    
			// make an instance of application's frame visible.
		    (new BankWindow()).setVisible(true);
		} 
		catch (Throwable t) {
			t.printStackTrace();
			//Ensure the application exits with an error condition.
			System.exit(1);
		}
	}

	public static void createPersonalCheckingAccount(AccountParameters param) {
		//createCustomerAccount(param, PersonFactory.getInstance(), CheckingAccountFactory.getInstance());
		createPerson(param);
		createCheckingAccount(BankAccountFactory.getBankAccountFactory(),param.getAccountNumber());
		
		System.out.println("no of customers:" + getCustomers().size());
		for(model.ICustomer c : getCustomers()) {
			System.out.println("name = " + c.getName());
		}
	}
	
	public static void createPersonalSavingAccount(AccountParameters param) {
		createPerson(param);
		createSavingAccount(BankAccountFactory.getBankAccountFactory(),param.getAccountNumber());
	}
	
	public static void createCompanyCheckingAccount(AccountParameters param) {
		createCompany(param);
		createCheckingAccount(BankAccountFactory.getBankAccountFactory(),param.getAccountNumber());	
		}
	
	public static void createCompanySavingAccount(AccountParameters param) {
		createCompany(param);
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
