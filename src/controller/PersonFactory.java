package controller;

import model.Address;
import model.Customer;
import model.Person;

public class PersonFactory implements CustomerFactory {
	
	private static PersonFactory instance = new PersonFactory();
	
	private PersonFactory() {
		// should not be invoked except by instnace variable
	}
	
	@Override
	public Customer createCustomer(String name, String email, String street, String city, String state, String zip) {
		return new Person(name, email, new Address(street, city, state, zip));
	}
	
	public static PersonFactory getInstance() {
		return instance;
	}
}
