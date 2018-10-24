package model;

import java.util.ArrayList;
import java.util.List;

public class Account extends AbstractAccount {
	
	List<ITransaction> transactions = new ArrayList<>();
	String accountNumber;
	double currentBalance;
	
	public Account(ICustomer owner, String accountNumber) {
		addOwner(owner);
		this.accountNumber = accountNumber;
		super.interest = 0.01;
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
