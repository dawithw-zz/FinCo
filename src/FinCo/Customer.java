package FinCo;

public class Customer implements ICustomer {

	private String name;
	private String email;
	private Address address;
	private List<Account> accounts;
	
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
	
	public void sendEmail() {
		System.out.println("Email sent to: " + this.name + " - " + this.email);
	}
	
	
}
