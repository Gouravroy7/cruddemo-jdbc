package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	//expose "/employees" and return list of ALL employees
	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}
	
	// return employee detail of a an employee with given id
	@GetMapping("/employees/{id}") 
	public Employee findById(@PathVariable("id") int theId)
	{
		Employee e = employeeService.findById(theId);
		
		if(e==null)
			throw new NullPointerException("No Employee Found");
		
		return e;
	}
	
	// add a new employee to the database
	@PostMapping("/addemployee")
	public Employee addEmployee(@RequestParam(name="fname") String fname,@RequestParam(name="lname") String lname,@RequestParam(name="email") String email) {
		
		
		 Employee employee = new Employee(fname,lname,email);
		
		
		return employeeService.addEmployee(employee);
		
	}
	
	// update details of an employee with given id
	@PutMapping("/updateemployee/{id}")
	public String updateEmployee(@PathVariable("id") int theId , @RequestParam("email") String email)
	{
		
		return employeeService.updateEmployee(theId, email);
	}
	
	// delete an employee with given id
	@DeleteMapping("/deleteemployee/{id}")
	public String deleteEmployee(@PathVariable("id") int theId)
	{
		
		return employeeService.deleteEmployee(theId);
	}

}
