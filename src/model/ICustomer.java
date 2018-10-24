package model;

import java.util.List;

public interface ICustomer {
	public String getName();
	public void setName(String name);
	public String getEmail();
	public void setEmail(String email);
	public Address getAddress();
	public void setAddress(String street, String city, String state, String zip);
	public void addAccount(IAccount account);
	public void removeAccount(IAccount account);
	public List<IAccount> accounts();
	public void sendEmail();
}
