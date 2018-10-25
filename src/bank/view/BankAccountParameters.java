package bank.view;

import view.AccountParameters;

public class BankAccountParameters extends AccountParameters{
	private String accountType;
	private String numOfEmployees;
	private String birthdate;

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getNumOfEmployees() {
		return numOfEmployees;
	}

	public void setNumOfEmployees(String numOfEmployees) {
		this.numOfEmployees = numOfEmployees;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	
}
