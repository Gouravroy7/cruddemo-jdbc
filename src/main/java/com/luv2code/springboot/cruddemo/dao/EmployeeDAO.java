package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> findAll() ;

	public Employee findById(int theId);

	public Employee addEmployee(Employee theemployee);

	public String updateEmployee(int theId, String email);

	public String deleteEmployee(int theId);

}
