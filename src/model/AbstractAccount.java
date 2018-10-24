package model;

public abstract class AbstractAccount implements IAccount {
	
	private ICustomer owner;
	protected double interest;
	
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

	
}
