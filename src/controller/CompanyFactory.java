package controller;

import model.Account;
import model.Address;
import model.Company;
import model.Customer;

public class CompanyFactory implements CustomerFactory {

	@Override
	public Customer createCustomer(String name, String email, String street, String city, String state, String zip) {
		
		return new Company(name, email, new Address(street, city, state, zip));
	}


}
