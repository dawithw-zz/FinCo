package controller;

public class UserInput {
	private String accountNumber;
	private String clientName;
	private String streetName;
	private String city;
	private String state;
	private String zip;
	private String accountType;
	private String amountDeposit;
	private String clientEmail;
	
	public UserInput() {
		accountNumber = clientName = streetName = city = state = zip = accountType = amountDeposit = "";
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
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
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAmountDeposit() {
		return amountDeposit;
	}
	public void setAmountDeposit(String amountDeposit) {
		this.amountDeposit = amountDeposit;
	}

	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}	
}
