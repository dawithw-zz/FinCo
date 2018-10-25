package ccard.model;

import java.util.Date;

import model.ICustomer;

public class Gold extends CreditCard {

	public Gold(ICustomer owner, String accountNumber, Date expiryDate) {
		super(owner, accountNumber);
		super.setExpiryDate(expiryDate);
		super.setMonthlyInterest(0.06);
		super.setMinPayment(0.1);
	}


}
