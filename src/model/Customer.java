package model;

import java.util.ArrayList;
import java.util.List;

public class Customer implements ICustomer {

	private String name;
	private String email;
	private Address address;
	private List<Account> accounts = new ArrayList<>();
	
	public Customer(String name, String email, Address address) {
		this.name = name;
		this.email = email;
		this.address = address;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(String street, String city, String state, String zip) {
		this.address = new Address(street, city, state, zip);
	}
	
	public void addAccount(Account account) {
		this.accounts.add(account);
	}
	
	public void removeAccount(Account account) {
		this.accounts.remove(account);
	}
	
	public List<Account> accounts() {
		return accounts;
	}
	
	public void sendEmail() {
		System.out.println("Email sent to: " + this.name + " - " + this.email);
	}
	
	//Is Customer name and email is equal to existing customer?
	@Override
	public boolean equals(Object customer) {
        if (customer == null) return false;
        if (!(customer instanceof Customer)) return false;
        Customer c = (Customer)customer;
        if(this.name.equals(c.name) && this.email.equals(c.email)) return true;
        return false;
    }
}
