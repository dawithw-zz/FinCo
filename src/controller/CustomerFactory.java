package controller;

import model.Customer;

public interface CustomerFactory {
	public Customer createCustomer(String name, String email, String street, String city, String state, String zip);
}
