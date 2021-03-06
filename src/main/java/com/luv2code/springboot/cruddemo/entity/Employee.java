package com.luv2code.springboot.cruddemo.entity;



public class Employee {

	//define fields 
	
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	// define constructors
	public Employee() {
		
	}

	public Employee(String firstName, String lastName, String email) {
		//super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	

	
	// define getters and setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	//define tostring method
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
	
	
}
