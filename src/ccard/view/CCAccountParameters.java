package ccard.view;

import java.time.LocalDate;

import view.AccountParameters;

public class CCAccountParameters extends AccountParameters {

	private LocalDate expiryDate;

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	

}
