package controller;

import java.util.List;
import java.util.Optional;
import java.util.function.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import model.Account;
import model.Customer;
import model.IAccount;
import model.ICustomer;
import model.ITransaction;
import model.Transaction;
import view.AccountParameters;


public class FinCo {
	
	private static List<ICustomer> customers = new ArrayList<>();
	private static ICustomer customer;
	
	public static void createPersonalAccount(AccountParameters param) {
		//createCustomerAccount(param, CustomerFactory.getCustomerFactory(), AccountFactory.getInstance());
		
		createPerson(param);
		createCustomerAccount(AccountFactory.getAccountFactory(),param.getAccountNumber());
		
	}
	
	protected static void createPerson(AccountParameters param) {
		//Is Customer already exist
				customer = findCustomer(param.getCustomerName(), param.getCustomerEmail()).get(); 
				if(customer == null) {		
				customer = CustomerFactory.getCustomerFactory().createPerson(param.getCustomerName(),
													   param.getbirthDate(),
							   						   param.getCustomerEmail(), 
							   						   param.getStreetName(),
							   						   param.getCity(), 
							   						   param.getState(), 
							   						   param.getZip());
				customers.add(customer);
			}
	}
	
	public static void createCompanyAccount(AccountParameters param) {
		//createCustomerAccount(param, CustomerFactory.getCustomerFactory(), AccountFactory.getInstance());
		
		createCompany(param);
				createCustomerAccount(AccountFactory.getAccountFactory(),param.getAccountNumber());
	}
	
	protected static void createCompany(AccountParameters param) {
		//Is Customer already exist
				customer = findCustomer(param.getCustomerName(), param.getCustomerEmail()).get(); 
				if(customer == null) {		
				customer = CustomerFactory.getCustomerFactory().createCompany(param.getCustomerName(),
							   						   param.getCustomerEmail(), 
							   						   param.getStreetName(),
							   						   param.getCity(), 
							   						   param.getState(), 
							   						   param.getZip());
				customers.add(customer);
			}
	}
	
	private static void createCustomerAccount(AccountFactory aFactory, String accountNumber ) {
		IAccount account = aFactory.createAccount(customer, accountNumber);
		customer.addAccount(account); 
	}
	
	protected static ICustomer getCustomer() {
		return customer;
	}
//	
//	protected static void createCustomerAccount(AccountParameters param, CustomerFactory cFactory, AccountFactory aFactory) {
//		Customer customer;
//		Optional<Customer> previousCustomer = findCustomer(param.getCustomerName(), param.getClientEmail());
//		if (previousCustomer.isPresent()) {
//			customer = previousCustomer.get();
//		} else {
//			customer = cFactory.createCustomer(param.getCustomerName(), 
//					   						   param.getClientEmail(), 
//					   						   param.getStreetName(),
//					   						   param.getCity(), 
//					   						   param.getState(), 
//					   						   param.getZip());
//			customers.add(customer);
//		}
//		Account account = aFactory.createAccount(customer, param.getAccountNumber());
//		customer.addAccount(account); 
//	}

	
	private static Optional<ICustomer> findCustomer(String customerName, String customerEmail) {
		return customers.stream().filter(customer -> customer.getName().equals(customerName))
								 .filter(customer -> customer.getEmail().equals(customerEmail))
								 .findFirst();							 
	}
	
	private static BiPredicate<ICustomer, String> hasAccount = 
			(customer,accountNumber) -> customer.accounts().stream()
														.anyMatch(account -> account.accountNumber().equals(accountNumber));
	
	private static Function<String, ICustomer> getOwner = 
			(accountNumber) -> customers.stream()
										.filter(customer -> hasAccount.test(customer, accountNumber))
										.findFirst()
										.get();
	
	public static void deposit(String accountNumber, double deposit) {
		customer = getOwner.apply(accountNumber);
		for (IAccount a : customer.accounts()) {
			if (a.accountNumber().equals(accountNumber)) {
				a.addTransaction(new Transaction("Deposit", deposit, Date.valueOf(LocalDate.now())));
			}
		}
		
	}
	
	public static void withdraw(String accountNumber, double deposit) {
		 customer = getOwner.apply(accountNumber);
		for (IAccount a : customer.accounts()) {
			if (a.accountNumber().equals(accountNumber)) {
				a.addTransaction(new Transaction("Withdraw", -deposit, Date.valueOf(LocalDate.now())));
			}
		}
		
	}
	
	public static void addInterest() {
		for(ICustomer c : customers) {
			for(IAccount a: c.accounts()) {
				a.addInterest();
			}
		}
	}
	
	public static String generateReport() {
		String report = "";
		for(ICustomer c : customers) {
			report = "Name = " + c.getName();
			report += "Address = " + c.getAddress();
			report += "Account = " + c.accounts();
			report += "Total Balance = " + c.accounts().stream().mapToDouble(x-> x.getBalance()).sum();
			
		}
		return report;
	}
	
}
