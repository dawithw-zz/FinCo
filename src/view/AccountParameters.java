package view;

import java.util.Date;

public class AccountParameters {
	private String accountNumber;
	private String customerName;
	private String streetName;
	private String city;
	private String state;
	private String zip;
	private String customerEmail;
	private Date birthDate;
	
	public AccountParameters() {
		accountNumber = customerName = streetName = city = state = zip = customerEmail = "";
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public Date getbirthDate() {
		return birthDate;
	}
	public void setbirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}	
}
