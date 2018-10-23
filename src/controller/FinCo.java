package controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Account;
import model.Customer;
import model.Transaction;

public class FinCo {
	Map<Customer, List<Account>> accounts = new HashMap<>();
	
	public void addPersonalAccount(AccountProperties param) {
		
	}
	
	public void addCompanyAccount(AccountProperties param) {
		
	}
	
	public void addInterest() {
		for(Customer c : accounts.keySet()) {
			accounts.get(c).stream().forEach(account -> account.addInterest());
		}
	}
	
	public void deposit(String customerName, String accountNumber, String deposit) {
		Customer customer = accounts.keySet().stream()
				.filter(c -> c.getName().equals(customerName))
				.findFirst().get();
		
		accounts.get(customer).stream()
			.filter(account -> account.accountNumber() == Long.parseLong(accountNumber))
			.findFirst().get()
			.addTransaction(new Transaction("Deposit", Double.parseDouble(deposit), Date.valueOf(LocalDate.now())));
	}
	
	public void withdraw(String customerName, String accountNumber, String withdrawal) {
		
	}
	
	
}
