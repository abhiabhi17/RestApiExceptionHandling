package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.exceptions.ResourceNotFoundException;
import com.example.model.Employee;

public interface EmployeeService {
	public Employee SaveEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public Employee getEmployeById(long empId) throws ResourceNotFoundException;
	public Employee updateEmploye(Employee emp,long empid) throws ResourceNotFoundException;
	
	public void deleteEmployee(long empid) throws ResourceNotFoundException;
	

}
