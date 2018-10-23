package model;

import java.time.LocalDate;

public class Transaction implements ITransaction {
	private String description;
	private double amount;
	private LocalDate date;
	
	Transaction(String description, double amount, LocalDate date) {
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
	
	public LocalDate date() {
		return date;
	}
	
}
