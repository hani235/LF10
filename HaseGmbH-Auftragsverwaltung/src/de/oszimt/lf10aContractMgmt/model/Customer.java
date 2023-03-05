package de.oszimt.lf10aContractMgmt.model;

import java.time.LocalDate;

public class Customer {
	private int customerID;
	private String firstname;
	private String lastname;
	private String birthday;
	private String email;
	private Address address;
	private static int nextID = 1009900;  // this is only for internal usage. 
	
	public Customer(String firstname, String lastname, String birthday, String email,
			Address address) {
		super();
		this.customerID = generateNewID();
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthday = birthday;
		this.email = email;
		this.address = address;
	}
	
	private int generateNewID() {
		return ++nextID;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", birthday=" + birthday + ", email=" + email + ", address=" + address + "]";
	}

	@Override
	public boolean equals(Object o) {
		if ( o instanceof Customer) {
			Customer tempCustomer = (Customer) o;
			if (this.customerID == tempCustomer.getCustomerID())
				return true;
		}
		return false;
	}

	public void setAllFields(String firstname, String lastname, 
			Address address, String email,  String birthday) {
		this.customerID = generateNewID();
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.email = email;
		this.birthday = birthday;
	}
	
}
