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

/*
 * A utility class containing the business logic of the application, and separates the main from the implementation details
 * 
 */
public class CustomerAccountFactory {
	
	private static List<Customer> customers = new ArrayList<>();
	
	private CustomerAccountFactory() {
		// utility class
	}
	
	public static void CreatePersonalAccount(AccountParameters param) {
		createCustomerAccount(param, PersonFactory.getInstance(), AccountFactory.getInstance());
	}
	
	public static void CreateCompanyAccount(AccountParameters param) {
		createCustomerAccount(param, CompanyFactory.getInstance(), AccountFactory.getInstance());
	}
	
	public static void createCustomerAccount(AccountParameters param, CustomerFactory cFactory, AccountFactory aFactory) {
		Customer customer;
		Optional<Customer> previousCustomer = findCustomer(param.getClientName(), param.getClientEmail());
		if (previousCustomer.isPresent()) {
			customer = previousCustomer.get();
		} else {
			customer = cFactory.createCustomer(param.getClientName(), 
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
}
