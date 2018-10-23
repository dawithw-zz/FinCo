package controller;

import model.Account;
import model.Address;
import model.Company;
import model.Customer;
import model.Person;

public class PersonFactory implements CustomerFactory {
	private PersonFactory instance = new PersonFactory();
	private PersonFactory() {
		// should not be invoked except by instnace variable
	}
	@Override
	public Customer createCustomer(String name, String email, String street, String city, String state, String zip) {
		return new Person(name, email, new Address(street, city, state, zip));
	}
	public PersonFactory getInstance() {
		return instance;
	}
}
