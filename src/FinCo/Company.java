package FinCo;

import java.util.ArrayList;
import java.util.List;

public class Company extends Customer implements ICompany {

	//private int noOfEmployees;
	private List<Person> persons = new ArrayList<>();
	
	public Company(String name, String email, Address address) {
		super(name, email, address);
	}
	
	public int employeeCount() {
		return persons.size();
	}
	
	public void addPerson(Person person) {
		this.persons.add(person);
	}
}
