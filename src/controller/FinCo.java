package controller;

public class FinCo {
	
	public void addPersonalAccount(AccountParameters param) {
		CustomerAccountFactory.createPersonalAccount(param);
	}
	
	public void addCompanyAccount(AccountParameters param) {
		CustomerAccountFactory.createCompanyAccount(param);
	}
	
	public void deposit(String customerName, String accountNumber, String deposit) {
		CustomerAccountFactory.deposit(accountNumber, Double.parseDouble(deposit));
	}
	
	public void withdraw(String customerName, String accountNumber, String withdrawal) {
		CustomerAccountFactory.withdraw(accountNumber, Double.parseDouble(withdrawal));
	}
	
}
