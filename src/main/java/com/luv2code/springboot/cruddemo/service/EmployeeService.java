package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();

	public Employee findById(int theId);

	public Employee addEmployee(Employee employee);

	public String updateEmployee(int theId, String email);

	public String deleteEmployee(int theId);
	
}
