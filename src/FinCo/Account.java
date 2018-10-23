package FinCo;

import java.util.ArrayList;
import java.util.List;

public class Account extends AbstractAccount {
	
	List<Transaction> transactions = new ArrayList<>();
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

}
