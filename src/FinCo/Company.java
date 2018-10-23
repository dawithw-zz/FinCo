package FinCo;

import java.util.List;

public class Company extends Customer implements ICompany {

	//private int noOfEmployees;
	private List<Person> persons;
	
	public int employeeCount() {
		return persons.size();
	}
	
	public void addPerson(Person person) {
		this.persons.add(person);
	}
}
