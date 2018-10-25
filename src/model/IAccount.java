package model;

import java.util.List;

public interface IAccount {

	public void addOwner(ICustomer customer);
	public void notifyCustomer();
	public double getInterest();
	public void setInterest(double interest);
	public void addInterest();
	public void addTransaction(ITransaction transaction);
	public double getBalance();
	public String accountNumber();
	public List<ITransaction> getTransactions();
}
