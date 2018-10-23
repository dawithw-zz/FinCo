package FinCo;

import java.util.Date;

public class Transaction implements ITransaction {
	private String description;
	private double amount;
	private Date date;
	
	Transaction(String description, double amount, Date date) {
		this.description = description;
		this.amount = amount;
		this.date = date;
	}
	
	public String description() {
		return description;
	}
	
	public double amount() {
		return amount;
	}
	
	public Date date() {
		return date;
	}
	
}
