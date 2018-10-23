package model;

import java.util.Date;

public class Person extends Customer implements IPerson {

	private Date birthDate;

	public Person(String name, String email, Address address) {
		super(name, email, address);
		//this.birthDate = birthDate;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
}
