package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDAO employeeDAO;

	@Override
	public List<Employee> findAll() {
		
		return  employeeDAO.findAll();
	}

	@Override
	public Employee findById(int theId) {
		
		Employee employee = employeeDAO.findById(theId);
		
		if(employee==null)
		return null;
		
		return employee;
	}

	@Override
	public Employee addEmployee(Employee theemployee) {
		
		Employee employee = employeeDAO.addEmployee(theemployee);
		
		return employee;
	}

	@Override
	public String updateEmployee(int theId, String email) {
		
		return employeeDAO.updateEmployee(theId , email);
		
	}

	@Override
	public String deleteEmployee(int theId) {
		
		return employeeDAO.deleteEmployee(theId);
	}
	
	

}
