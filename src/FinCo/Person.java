package FinCo;

import java.util.Date;

public class Person extends Customer implements IPerson {

	private Date birthDate;

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
}
