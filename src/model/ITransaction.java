package model;

import java.util.Date;

public interface ITransaction {
	public String description();
	public double amount();
	public Date date();
}
