package FinCo;

import java.util.ArrayList;

public class Account extends AbstractAccount {
	
	ArrayList<Transaction> transactions = new ArrayList<>();
	long accountNumber;
	double currentBalance;
	
	Account(Customer owner, long accountNumber) {
		addOwner(owner);
		this.accountNumber = accountNumber;
	}
	
	public long accountNumber() {
		return accountNumber;
	}
	
	@Override
	public void addTransaction(Transaction transaction) {
		transactions.add(transaction);
		currentBalance += transaction.amount();
	}

	@Override
	public double getBalance() {
		return currentBalance;
	}

	@Override
	public void addInterest() {
		currentBalance *= interest;
	}

	@Override
	public void notifyCustomer() {
		// TODO Auto-generated method stub
	}

}
