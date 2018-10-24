package model;

import java.util.ArrayList;
import java.util.List;

public class Company extends Customer implements ICompany {

	private int noOfEmployees;
	private List<IPerson> persons = new ArrayList<>();
	
	public Company(String name, String email, Address address) {
		super(name, email, address);
	}
	
	@Override
	public int employeeCount() {
		return persons.size();
	}
	
	@Override
	public void addPerson(IPerson person) {
		this.persons.add(person);
	}
	
	@Override
	public int getNoOfEmployees() {
		return noOfEmployees;
	}

	@Override
	public void setNoOfEmployees(int noOfEmployees) {
		this.noOfEmployees = noOfEmployees;
	}

}
