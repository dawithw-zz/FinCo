package controller;

import model.Account;
import model.Address;
import model.Company;
import model.Customer;
import model.Person;

public class PersonalAccountFactory implements AccountFactory {

	@Override
	public Customer createCustomer(String name, String email, String street, String city, String state, String zip) {
		return new Person(name, email, new Address(street, city, state, zip));
	}

	@Override
	public Account createAccount(Customer owner, long accountNumber) {
		return new Account(owner, accountNumber);
	}

}
