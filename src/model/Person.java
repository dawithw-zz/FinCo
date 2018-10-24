package model;

import java.util.Date;

public class Person extends Customer implements IPerson {

	private Date birthDate;

	public Person(String name, Date birthDate, String email, Address address) {
		super(name, email, address);
		this.birthDate = birthDate;
	}
	
	@Override
	public Date getBirthDate() {
		return birthDate;
	}

	@Override
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
}
