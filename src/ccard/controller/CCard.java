package ccard.controller;
 
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.Date;

import ccard.view.CCAccountParameters;
import controller.FinCo;
import model.IAccount;
import model.ICustomer;
import model.ITransaction;
import model.Transaction;

public class CCard extends FinCo {

	//private static ICustomer customer;

	public static void createPersonalGoldAccount(CCAccountParameters param) {
		createPerson(param);
		createGoldAccount(CCardAccountFactory.getCCardAccountFactory(),param.getAccountNumber(), param.getExpiryDate());
	}
	
	public static void createPersonalSilverAccount(CCAccountParameters param) {
		createPerson(param);
		createSilverAccount(CCardAccountFactory.getCCardAccountFactory(),param.getAccountNumber(), param.getExpiryDate());
	}
	
	public static void createPersonalBronzeAccount(CCAccountParameters param) {
		createPerson(param);
		createBronzeAccount(CCardAccountFactory.getCCardAccountFactory(),param.getAccountNumber(), param.getExpiryDate());
	}
	
	public static void createCompanyGoldAccount(CCAccountParameters param) {
		createCompany(param);
		createGoldAccount(CCardAccountFactory.getCCardAccountFactory(),param.getAccountNumber(), param.getExpiryDate());
	}
	
	public static void createCompnaySilverAccount(CCAccountParameters param) {
		createCompany(param);
		createSilverAccount(CCardAccountFactory.getCCardAccountFactory(),param.getAccountNumber(), param.getExpiryDate());
	}
	
	public static void createCompanyBronzeAccount(CCAccountParameters param) {
		createCompany(param);
		createBronzeAccount(CCardAccountFactory.getCCardAccountFactory(),param.getAccountNumber(), param.getExpiryDate());
	}
	
	private static void createGoldAccount(CCardAccountFactory bFactory, String accountNumber, Date expiryDate) {
		IAccount account = bFactory.createGoldAccount(customer, accountNumber, expiryDate);
		customer.addAccount(account); 
	}
	
	private static void createSilverAccount(CCardAccountFactory bFactory, String accountNumber, Date expiryDate ) {
		IAccount account = bFactory.createGoldAccount(customer, accountNumber, expiryDate);
		customer.addAccount(account); 
	}
	
	private static void createBronzeAccount(CCardAccountFactory bFactory, String accountNumber, Date expiryDate ) {
		IAccount account = bFactory.createGoldAccount(customer, accountNumber, expiryDate);
		customer.addAccount(account); 
	}
	
	public static void charge(String accountNumber, double chargeAmount) {
		customer = getOwner(accountNumber);
		IAccount account = getAccount(accountNumber, customer);
		account.addTransaction(new Transaction("Charge", chargeAmount, Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()) ));
	}
	
	
	public static String generateReport() {
		String report = "";
		for (ICustomer c : getCustomers()) {
			report = "Name = " + c.getName();
			report += "Address = " + c.getAddress();
			for(IAccount a : c.accounts()) {
			report += "CC Number = " + a.accountNumber();
			report += "CC Type = " + a.getClass().getSimpleName();
			report += "Previous blance = " + a.getBalance();
			report += "Total credits = " + a.getBalance();
			report += "Total Charges = " + totalCharges(a);
			report += "New Balance = " + "";
			report += "Total Amount Due = " + "";
			}
		}
		return report;
	}
	
private static Double getLastMonthBalance(IAccount account) {
	YearMonth thisMonth    = YearMonth.now();
	YearMonth lastMonth    = thisMonth.minusMonths(1);
	
	return	account.getTransactions().stream()
			 .filter(x -> x.date().getMonth()>2 )
			 .mapToDouble(x -> x.amount())
			 .sum();
	}
	
	private static Double totalCharges(IAccount account) {
		return	account.getTransactions().stream()
										 .filter(x -> x.description() == "Charges")
										 .mapToDouble(x -> x.amount())
										 .sum();
	}

}
