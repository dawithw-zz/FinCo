package model;

public abstract class AbstractAccount {
	
	private Customer owner;
	protected double interest = 0.01;
	
	// add observer
	public void addOwner(Customer customer) {
		owner = customer;
	}
	
	// notify observer
	public void notifyCustomer() {
		owner.sendEmail();
	}
	
	
	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public abstract void addInterest();
	public abstract void addTransaction(Transaction transaction);
	public abstract double getBalance();
}
