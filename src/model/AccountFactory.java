package model;

public interface AccountFactory {
	public Customer createCustomer(String name, String email, String street, String city, String state, String zip);
	public Account createAccount(Customer owner);
}
