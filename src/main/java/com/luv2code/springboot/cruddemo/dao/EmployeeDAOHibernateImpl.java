package com.luv2code.springboot.cruddemo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
	
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Employee> findAll() {
		
		String sql = "SELECT * FROM employee";
		List<Employee> employees = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Employee.class));	
		
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		
		String sql = "select * from Employee where id=?";
		
		Employee employee = jdbcTemplate.queryForObject(sql, new Object[]{theId},
        new RowMapper<Employee>() {
            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            	Employee emp = new Employee();
            	emp.setId(theId);
            	emp.setFirstName(rs.getString("first_name"));
            	emp.setLastName(rs.getString("last_name"));
            	emp.setEmail(rs.getString("email"));
                return emp;
            }
        });
		
		//System.out.println(employee);
		if(employee==null)
			return null;
		
		return employee;
	}

	@Override
	public Employee addEmployee(Employee theemployee) {
		
		int employee = jdbcTemplate.update("insert into employee values (?,?, ?,?)", 
				theemployee.getId(),theemployee.getFirstName(),theemployee.getLastName(),theemployee.getEmail());
		
		return theemployee;
		
	}

	@Override
	public String updateEmployee(int theId , String email) {
		
		int upd = jdbcTemplate.update("update employee set email=? where id=?",email,theId);
		
		return "Employee updated with id "+theId;
		
	}

	@Override
	public String deleteEmployee(int theId) {
		
		int del = jdbcTemplate.update("delete from employee where id=?",theId);
		return "Employee deleted with id "+theId;
		
	}

}
