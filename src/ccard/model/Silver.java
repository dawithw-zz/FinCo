package ccard.model;

import java.util.Date;

import model.ICustomer;

public class Silver extends CreditCard {

	public Silver(ICustomer owner, String accountNumber, Date expiryDate) {
		super(owner, accountNumber);
		super.setExpiryDate(expiryDate);
		super.setMonthlyInterest(0.08);
		super.setMinPayment(0.12);
	}

}
