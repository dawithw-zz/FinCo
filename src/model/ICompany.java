package model;

public interface ICompany extends ICustomer {

	public int employeeCount();
	public void addPerson(IPerson person);
	public int getNoOfEmployees();
	public void setNoOfEmployees(int noOfEmployees);
}
