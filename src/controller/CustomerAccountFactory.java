package controller;

import model.Account;
import model.Customer;
import model.ICustomer;

/*
 * Simple factory to instantiate customer factory and account factory.
 */
public class CustomerAccountFactory {

	CustomerFactory customerFactory;
	AccountFactory accountFactory;
	Customer customer;
	Account account;
	
	public void CreatePersonAccount(String name, String email, String street, String city, String state, String zip, long accountNumber) {
		customerFactory = new PersonFactory();
		accountFactory = new AccountFactory();
		create(name, email, street, city, state, zip, accountNumber);
	}
	
	public void CreateCompanyAccount(String name, String email, String street, String city, String state, String zip, long accountNumber) {
		customerFactory = new CompanyFactory();
		accountFactory = new AccountFactory();
		create(name, email, street, city, state, zip, accountNumber);
	}
	
	private void create(String name, String email, String street, String city, String state, String zip, long accountNumber) {
		customer = customerFactory.createCustomer(name, email, street, city, state, zip);
		account = accountFactory.createAccount(customer, accountNumber);
		customer.addAccount(account);
	}

	public Customer getCustomer() {
		return customer;
	}

	public Account getAccount() {
		return account;
	}
	
	
}
