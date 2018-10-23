package controller;

import model.Address;
import model.Company;
import model.Customer;

public class CompanyFactory implements CustomerFactory {
	private CompanyFactory instance = new CompanyFactory();
	
	private CompanyFactory() {
		// should not be invoked except by instance
	}
	@Override
	public Customer createCustomer(String name, String email, String street, String city, String state, String zip) {
		
		return new Company(name, email, new Address(street, city, state, zip));
	}
	
	public CompanyFactory getInstance() {
		return instance;
	}

}
