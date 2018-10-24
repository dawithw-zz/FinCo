package model;

public abstract class AbstractAccount {
	
	private Customer owner;
	protected double interest;
	
	// add observer
	public void addOwner(Customer customer) {
		owner = customer;
	}
	
	// notify observer
	public void notifyCustomer() {
		owner.sendEmail();
	}
	
	public abstract void addTransaction(Transaction transaction);
	public abstract double getBalance();
}
