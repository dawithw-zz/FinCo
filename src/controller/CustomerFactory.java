package controller;

import java.util.Date;

import model.Address;
import model.Company;
import model.Customer;
import model.Person;

public class CustomerFactory {

	private static CustomerFactory instance = new CustomerFactory();
	
	private CustomerFactory() {
		//Shold not be invoked except instance.
	}
	public Customer createCompany(String name, String email, String street, String city, String state, String zip) {
		return new Company(name, email, new Address(street, city, state, zip));
	}
	
	public Customer createPerson(String name, Date birthDate, String email, String street, String city, String state, String zip) {
		return new Person(name, birthDate, email, new Address(street, city, state, zip));
	}
	
	public static CustomerFactory getCustomerFactory() {
		return instance;
	}
}
