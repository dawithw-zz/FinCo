package ccard.controller;

import bank.BankAccountFactory;
import controller.FinCo;
import model.IAccount;
import model.ICustomer;
import view.AccountParameters;

public class CCard extends FinCo {

	//private static ICustomer customer;

	public static void createPersonalGoldAccount(AccountParameters param) {
		createPerson(param);
		createGoldAccount(CCardAccountFactory.getCCardAccountFactory(),param.getAccountNumber());
	}
	
	public static void createPersonalSilverAccount(AccountParameters param) {
		createPerson(param);
		createSilverAccount(CCardAccountFactory.getCCardAccountFactory(),param.getAccountNumber());
	}
	
	public static void createPersonalBronzeAccount(AccountParameters param) {
		createPerson(param);
		createBronzeAccount(CCardAccountFactory.getCCardAccountFactory(),param.getAccountNumber());
	}
	
	public static void createCompanyGoldAccount(AccountParameters param) {
		createCompany(param);
		createGoldAccount(CCardAccountFactory.getCCardAccountFactory(),param.getAccountNumber());
	}
	
	public static void createCompnaySilverAccount(AccountParameters param) {
		createCompany(param);
		createSilverAccount(CCardAccountFactory.getCCardAccountFactory(),param.getAccountNumber());
	}
	
	public static void createCompanyBronzeAccount(AccountParameters param) {
		createCompany(param);
		createBronzeAccount(CCardAccountFactory.getCCardAccountFactory(),param.getAccountNumber());
	}
	
	private static void createGoldAccount(CCardAccountFactory bFactory, String accountNumber ) {
		IAccount account = bFactory.createGoldAccount(customer, accountNumber);
		customer.addAccount(account); 
	}
	
	private static void createSilverAccount(CCardAccountFactory bFactory, String accountNumber ) {
		IAccount account = bFactory.createGoldAccount(customer, accountNumber);
		customer.addAccount(account); 
	}
	
	private static void createBronzeAccount(CCardAccountFactory bFactory, String accountNumber ) {
		IAccount account = bFactory.createGoldAccount(customer, accountNumber);
		customer.addAccount(account); 
	}

}
