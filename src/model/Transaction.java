package model;

import java.util.Date;;

public class Transaction implements ITransaction {
	private String description;
	private double amount;
	private Date date;
	
	public Transaction(String description, double amount, Date date) {
		this.description = description;
		this.amount = amount;
		this.date = date;
	}
	
	@Override
	public String description() {
		return description;
	}
	
	@Override
	public double amount() {
		return amount;
	}
	
	@Override
	public Date date() {
		return date;
	}
	
}
