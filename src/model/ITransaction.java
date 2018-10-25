package model;

import java.time.LocalDate;

public interface ITransaction {
	public String description();
	public double amount();
	public LocalDate date();
}
