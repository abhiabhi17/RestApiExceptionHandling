package com.example.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exceptions.ResourceNotFoundException;
import com.example.model.Employee;
import com.example.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public Employee SaveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return empRepo.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}

	@Override
	public Employee getEmployeById(long empId) throws ResourceNotFoundException {
		Optional<Employee> emp=empRepo.findById(empId);
		if(emp.isPresent())
		{
			return emp.get();
		}
		else
		{
			throw new ResourceNotFoundException("Resource Not Found");
		}
	}

	@Override
	public Employee updateEmploye(Employee emp, long empid) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		
		Employee existingEmployee=empRepo.findById(empid)
				                        .orElseThrow(
				                        		     ()-> new ResourceNotFoundException("Resource not found"));
		existingEmployee.setFirstName(emp.getFirstName());
		existingEmployee.setLastName(emp.getLastName());
		existingEmployee.setLastName(emp.getLastName());
				empRepo.save(existingEmployee);                      		  
		return existingEmployee;
	}

	@Override
	public void deleteEmployee(long empid) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		 empRepo.findById(empid).orElseThrow(()->new ResourceNotFoundException("Resource Not Found"));
		empRepo.deleteById(empid);
	}

}
