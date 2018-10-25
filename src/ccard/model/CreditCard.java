package ccard.model;

import java.time.LocalDate;

import model.Account;
import model.ICustomer;

public abstract class CreditCard extends Account{

	protected LocalDate expiryDate;
	protected Double monthlyInterest;
	protected Double minPayment;
	
	public CreditCard(ICustomer owner, String accountNumber) {
		super(owner, accountNumber);
	}
	
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Double getMonthlyInterest() {
		return monthlyInterest;
	}

	public void setMonthlyInterest(Double monthlyInterest) {
		this.monthlyInterest = monthlyInterest;
	}

	public Double getMinPayment() {
		return minPayment;
	}

	public void setMinPayment(Double minPayment) {
		this.minPayment = minPayment;
	}
	
	public Double getLastMonthBalance(String accountNumber) {
		
		
		return null;
	}
	

}
