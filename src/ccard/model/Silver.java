package ccard.model;
 
import java.time.LocalDate;

import model.ICustomer;

public class Silver extends CreditCard {

	public Silver(ICustomer owner, String accountNumber, LocalDate expiryDate) {
		super(owner, accountNumber);
		super.setExpiryDate(expiryDate);
		super.setMonthlyInterest(0.08);
		super.setMinPayment(0.12);
	}

}
