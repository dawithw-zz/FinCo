package model;

import java.time.LocalDate;

public class Transaction implements ITransaction {
	private String description;
	private double amount;
	private LocalDate date;
	
	public Transaction(String description, double amount, LocalDate date) {
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
	public LocalDate date() {
		return date;
	}
	
}
