package ccard.view;

import java.time.LocalDate;

import view.AccountParameters;

public class CCAccountParameters extends AccountParameters {

	private LocalDate expiryDate;
	private String accountType;

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


}
