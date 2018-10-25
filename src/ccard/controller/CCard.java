package ccard.controller;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.Date;

import javax.swing.UIManager;

import bank.view.BankWindow;
import ccard.model.CreditCard;
import ccard.view.CCAccountParameters;
import ccard.view.CCWindow;
import controller.FinCo;
import model.IAccount;
import model.ICustomer;
import model.ITransaction;
import model.Transaction;

public class CCard extends FinCo {

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
		    (new CCWindow()).setVisible(true);
		} 
		catch (Throwable t) {
			t.printStackTrace();
			//Ensure the application exits with an error condition.
			System.exit(1);
		}
	}
	
	public static void createPersonalGoldAccount(CCAccountParameters param) {
		createPerson(param);
		createGoldAccount(CCardAccountFactory.getCCardAccountFactory(), param.getAccountNumber(),
				param.getExpiryDate());
	}

	public static void createPersonalSilverAccount(CCAccountParameters param) {
		createPerson(param);
		createSilverAccount(CCardAccountFactory.getCCardAccountFactory(), param.getAccountNumber(),
				param.getExpiryDate());
	}

	public static void createPersonalBronzeAccount(CCAccountParameters param) {
		createPerson(param);
		createBronzeAccount(CCardAccountFactory.getCCardAccountFactory(), param.getAccountNumber(),
				param.getExpiryDate());
	}

	public static void createCompanyGoldAccount(CCAccountParameters param) {
		createCompany(param);
		createGoldAccount(CCardAccountFactory.getCCardAccountFactory(), param.getAccountNumber(),
				param.getExpiryDate());
	}

	public static void createCompnaySilverAccount(CCAccountParameters param) {
		createCompany(param);
		createSilverAccount(CCardAccountFactory.getCCardAccountFactory(), param.getAccountNumber(),
				param.getExpiryDate());
	}

	public static void createCompanyBronzeAccount(CCAccountParameters param) {
		createCompany(param);
		createBronzeAccount(CCardAccountFactory.getCCardAccountFactory(), param.getAccountNumber(),
				param.getExpiryDate());
	}

	private static void createGoldAccount(CCardAccountFactory bFactory, String accountNumber, LocalDate expiryDate) {
		IAccount account = bFactory.createGoldAccount(customer, accountNumber, expiryDate);
		customer.addAccount(account);
	}

	private static void createSilverAccount(CCardAccountFactory bFactory, String accountNumber, LocalDate expiryDate) {
		IAccount account = bFactory.createGoldAccount(customer, accountNumber, expiryDate);
		customer.addAccount(account);
	}

	private static void createBronzeAccount(CCardAccountFactory bFactory, String accountNumber, LocalDate expiryDate) {
		IAccount account = bFactory.createGoldAccount(customer, accountNumber, expiryDate);
		customer.addAccount(account);
	}

	public static void charge(String accountNumber, double chargeAmount) {
		customer = getOwner(accountNumber);
		IAccount account = getAccount(accountNumber, customer);
		account.addTransaction(new Transaction("Charge", chargeAmount, LocalDate.now()));
	}

	public static String generateReport() {
		String report = "";
		for (ICustomer c : getCustomers()) {
			report = "Name = " + c.getName();
			report += "\nAddress = " + c.getAddress();
			for (IAccount a : c.accounts()) {
				report += "\nCC Number = " + a.accountNumber();
				report += "\nCC Type = " + a.getClass().getSimpleName();
				report += "\nPrevious blance = " + getLastMonthBalance(a);
				report += "\nTotal credits = " + getTotalCredits(a);
				report += "\nTotal Charges = " + getTotalCharges(a);
				report += "\nNew Balance = " + getNewBalance(a);
				report += "\nTotal Amount Due = " + getTotalDue(a);
			}
		}
		return report;
	}

	private static Double previousBalance;
	private static Double totalCharges;
	private static Double totalCredits;
	private static Double newBalance;

	private static Double getNewBalance(IAccount account) {
		return newBalance = previousBalance - totalCredits + totalCharges
				+ ((CreditCard) account).getMonthlyInterest() * (previousBalance - totalCredits);
	}

	private static Double getTotalDue(IAccount account) {
		return ((CreditCard) account).getMinPayment() * newBalance;
	}

	private static Double getLastMonthBalance(IAccount account) {
		int currentMonth = LocalDate.now().getMonth().getValue();
		return previousBalance = account.getTransactions().stream()
				.filter(x -> x.date().getMonth().getValue() < currentMonth).mapToDouble(x -> x.amount()).sum();
	}

	private static Double getTotalCharges(IAccount account) {
		return totalCharges = account.getTransactions().stream().filter(x -> x.description() == "Charges")
				.mapToDouble(x -> x.amount()).sum();
	}

	private static Double getTotalCredits(IAccount account) {
		return totalCredits = account.getTransactions().stream().filter(x -> x.description() == "Deposit")
				.mapToDouble(x -> x.amount()).sum();
	}

}
