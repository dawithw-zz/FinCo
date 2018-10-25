package ccard.model;


import java.util.Date;

import model.ICustomer;

public class Bronze extends CreditCard {

	public Bronze(ICustomer owner, String accountNumber, Date expiryDate) {
		super(owner, accountNumber);
		super.setExpiryDate(expiryDate);
		super.setMonthlyInterest(0.1);
		super.setMinPayment(0.14);

	}

}
