package ccard.controller;


import java.time.LocalDate;

import ccard.model.Bronze;
import ccard.model.Gold;
import ccard.model.Silver;
import controller.AccountFactory;
import model.IAccount;
import model.ICustomer;

public class CCardAccountFactory extends AccountFactory {

private static CCardAccountFactory instance = new CCardAccountFactory();
	
	private CCardAccountFactory() {
		
	}
	
	public static CCardAccountFactory getCCardAccountFactory() {
		return instance;
	}
	
	public IAccount createGoldAccount(ICustomer owner,  String accountNumber, LocalDate expiryDate) {
		return new Gold(owner, accountNumber, expiryDate);
	}
	
	public IAccount createSilverAccount(ICustomer owner, String accountNumber, LocalDate expiryDate) {
		return new Silver(owner, accountNumber, expiryDate);
	}
	
	public IAccount createBronzeAccount(ICustomer owner, String accountNumber, LocalDate expiryDate) {
		return new Bronze(owner, accountNumber, expiryDate);
	}
}
