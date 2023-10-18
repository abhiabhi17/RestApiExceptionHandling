package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exceptions.ResourceNotFoundException;
import com.example.model.Employee;
import com.example.service.EmployeeServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins="*")
public class EmployeeController {
	//Autwired
	@Autowired
	private EmployeeServiceImpl empService;

	@ApiOperation(value = " Ths is used for inserting passengers details")
	@PostMapping("save")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp)
	{
		return new ResponseEntity<Employee>(empService.SaveEmployee(emp),HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("getAll")
	public List<Employee> getEmployees()
	{
		return empService.getAllEmployees();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeById(@PathVariable("id") long empId) throws ResourceNotFoundException
	{
		String msg=null;
             int length=msg.length();
     
		return new ResponseEntity<Employee>(empService.getEmployeById(empId),HttpStatus.OK);
		
	}
	
	@PutMapping("{id}")
	@CrossOrigin(origins="*")
	public ResponseEntity<Employee> updateEmploye(@PathVariable("id") long empId,@RequestBody Employee emp) throws Exception
	{
		return new ResponseEntity<Employee>(empService.updateEmploye(emp, empId),HttpStatus.OK);
	}

	@DeleteMapping("delete/{id}")
	@CrossOrigin(origins="*.*")
	public ResponseEntity<String> deleteEmploye(@PathVariable("id") long empId) throws ResourceNotFoundException
	{
		empService.deleteEmployee(empId);
		return new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);
	}
}
