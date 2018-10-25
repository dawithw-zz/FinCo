package ccard.controller;

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
	
	public IAccount createGoldAccount(ICustomer owner,  String accountNumber) {
		return new Gold(owner, accountNumber);
	}
	
	public IAccount createSilverAccount(ICustomer owner, String accountNumber) {
		return new Silver(owner, accountNumber);
	}
	
	public IAccount createBronzeAccount(ICustomer owner, String accountNumber) {
		return new Bronze(owner, accountNumber);
	}
}
