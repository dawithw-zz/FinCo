package controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Account;
import model.Customer;
import model.Transaction;

public class FinCo {
	
	Map<Customer, List<Account>> accounts = new HashMap<>();
	AccountFactory personalFactory = new PersonalAccountFactory();
	AccountFactory companyFactory = new CompanyAccountFactory();
	
	public void addPersonalAccount(AccountProperties param) {
		Customer customer = personalFactory
									.createCustomer(
											param.getClientName(), 
											param.getClientEmail(), 
											param.getStreetName(),
											param.getCity(), 
											param.getState(), 
											param.getZip());
		
		Account account = personalFactory.createAccount(customer, Long.parseLong(param.getAccountNumber()));
		List<Account> customerAccounts = accounts.get(customer);
		
		// no customer with given properties exist
		if (customerAccounts == null) {
			customerAccounts = new ArrayList<>();
			customerAccounts.add(account);
			accounts.put(customer, customerAccounts);
		}
		else {
			customerAccounts.add(account);
		}
		
	}
	
	public void addCompanyAccount(AccountProperties param) {
		
	}
	
	public void addInterest() {
		for(Customer c : accounts.keySet()) {
			accounts.get(c).stream().forEach(account -> account.addInterest());
		}
	}
	
	public void deposit(String customerName, String accountNumber, String deposit) {
		Transaction transaction = new Transaction("Deposit", Double.parseDouble(deposit), Date.valueOf(LocalDate.now()));
		getAccount(customerName, accountNumber).addTransaction(transaction);
	}
	
	public void withdraw(String customerName, String accountNumber, String withdrawal) {
		Transaction transaction = new Transaction("Withdrawal", -(Double.parseDouble(withdrawal)), Date.valueOf(LocalDate.now()));
		getAccount(customerName, accountNumber).addTransaction(transaction);
	}
	
	private Account getAccount(String customerName, String accountNumber) {
		Customer customer = accounts.keySet().stream()
				.filter(c -> c.getName().equals(customerName))
				.findFirst().get();
		
		return accounts.get(customer).stream()
			.filter(account -> account.accountNumber() == Long.parseLong(accountNumber))
			.findFirst().get();
	}
	
}
