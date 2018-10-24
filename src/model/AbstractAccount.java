package model;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractAccount implements IAccount {
	
	private ICustomer owner;
	protected double interest;
	protected List<ITransaction> transactions = new ArrayList<>();
	protected String accountNumber;
	protected double currentBalance;
	
	// add observer
	@Override
	public void addOwner(ICustomer customer) {
		owner = customer;
	}
	
	// notify observer
	@Override
	public void notifyCustomer() {
		owner.sendEmail();
	}
	
	@Override
	public double getInterest() {
		return interest;
	}

	@Override
	public void setInterest(double interest) {
		this.interest = interest;
	}
	
	@Override
	public String accountNumber() {
		return accountNumber;
	}
	
	@Override
	public void addTransaction(ITransaction transaction) {
		transactions.add(transaction);
		currentBalance += transaction.amount();
	}

	@Override
	public double getBalance() {
		return currentBalance;
	}

	@Override
	public String toString() {
		return "Account = accountNumber: " + accountNumber + ", currentBalance: " + currentBalance;
	}

	@Override
	public void addInterest() {
	 this.currentBalance += this.currentBalance * this.getInterest();
		
	}

	
}
