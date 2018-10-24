package controller;

import java.util.List;
import java.util.Optional;
import java.util.function.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import model.Account;
import model.Customer;
import model.Transaction;
import view.AccountParameters;


public class FinCo {
	
	private static List<Customer> customers = new ArrayList<>();

	
	public static void createPersonalAccount(AccountParameters param) {
		createCustomerAccount(param, PersonFactory.getInstance(), AccountFactory.getInstance());
	}
	
	public static void createCompanyAccount(AccountParameters param) {
		createCustomerAccount(param, CompanyFactory.getInstance(), AccountFactory.getInstance());
	}
	
	protected static void createCustomerAccount(AccountParameters param, CustomerFactory cFactory, AccountFactory aFactory) {
		Customer customer;
		Optional<Customer> previousCustomer = findCustomer(param.getCustomerName(), param.getClientEmail());
		if (previousCustomer.isPresent()) {
			customer = previousCustomer.get();
		} else {
			customer = cFactory.createCustomer(param.getCustomerName(), 
					   						   param.getClientEmail(), 
					   						   param.getStreetName(),
					   						   param.getCity(), 
					   						   param.getState(), 
					   						   param.getZip());
			customers.add(customer);
		}
		Account account = aFactory.createAccount(customer, param.getAccountNumber());
		customer.addAccount(account); 
	}

	
	private static Optional<Customer> findCustomer(String customerName, String customerEmail) {
		return customers.stream().filter(customer -> customer.getName().equals(customerName))
								 .filter(customer -> customer.getEmail().equals(customerEmail))
								 .findAny();
								 
	}
	
	private static BiPredicate<Customer, String> hasAccount = 
			(customer,accountNumber) -> customer.accounts().stream()
														.anyMatch(account -> account.accountNumber().equals(accountNumber));
	
	private static Function<String, Customer> getOwner = 
			(accountNumber) -> customers.stream()
										.filter(customer -> hasAccount.test(customer, accountNumber))
										.findFirst()
										.get();
	
	public static void deposit(String accountNumber, double deposit) {
		Customer customer = getOwner.apply(accountNumber);
		for (Account a : customer.accounts()) {
			if (a.accountNumber().equals(accountNumber)) {
				a.addTransaction(new Transaction("Deposit", deposit, Date.valueOf(LocalDate.now())));
			}
		}
		
	}
	
	public static void withdraw(String accountNumber, double deposit) {
		Customer customer = getOwner.apply(accountNumber);
		for (Account a : customer.accounts()) {
			if (a.accountNumber().equals(accountNumber)) {
				a.addTransaction(new Transaction("Withdraw", -deposit, Date.valueOf(LocalDate.now())));
			}
		}
		
	}
	
	public static void addInterest() {
		for(Customer c : customers) {
			for(Account a: c.accounts()) {
				a.addInterest();
			}
		}
	}
	
	public static String generateReport() {
		String report = "";
		for(Customer c : customers) {
			report = "Name = " + c.getName();
			report += "Address = " + c.getAddress();
			report += "Account = " + c.accounts();
			report += "Total Balance = " + c.accounts().stream().mapToDouble(x-> x.getBalance()).sum();
			
		}
		return report;
	}
	
}
