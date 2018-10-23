package FinCo;

public abstract class AbstractAccount {
	
	private Customer owner;
	protected double interest;
	
	public void addOwner(Customer customer) {
		owner = customer;
	}
	
	public abstract void addTransaction(Transaction transaction);
	public abstract double getBalance();
	public abstract void addInterest();
	public abstract void notifyCustomer();
}
