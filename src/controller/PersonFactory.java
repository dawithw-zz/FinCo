package controller;

import model.Account;
import model.Address;
import model.Company;
import model.Customer;
import model.Person;

public class PersonFactory implements CustomerFactory {

	@Override
	public Customer createCustomer(String name, String email, String street, String city, String state, String zip) {
		return new Person(name, email, new Address(street, city, state, zip));
	}
}
