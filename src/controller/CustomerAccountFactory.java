package controller;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import model.Account;
import model.Customer;

/*
 * Simple factory to instantiate customer factory and account factory.
 */
public class CustomerAccountFactory {

	List<Customer> customers = new ArrayList<>();
	
	public void CreatePersonalAccount(AccountParameters param) {
		createCustomerAccount(param, PersonFactory.getInstance(), AccountFactory.getInstance());
	}
	
	public void CreateCompanyAccount(AccountParameters param) {
		createCustomerAccount(param, CompanyFactory.getInstance(), AccountFactory.getInstance());
	}
	
	public void createCustomerAccount(AccountParameters param, CustomerFactory cFactory, AccountFactory aFactory) {
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

	
	private Optional<Customer> findCustomer(String customerName, String customerEmail) {
		return customers.stream().filter(customer -> customer.getName().equals(customerName))
								 .filter(customer -> customer.getEmail().equals(customerEmail))
								 .findAny();
								 
	}
	
	
}
