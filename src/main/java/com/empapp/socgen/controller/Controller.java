package com.empapp.socgen.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empapp.socgen.domain.Employee;
import com.empapp.socgen.service.EmployeeService;

@RestController
@RequestMapping(path = "/employees")
public class Controller {

	public Controller() {
		System.out.println("Hey");
	}

	@Autowired
	private EmployeeService employeeService;

	@GetMapping(path="", produces = "application/json")
	public List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}

	@PutMapping(path="", produces = "application/json")
	public Employee saveEmployee(@RequestBody @Valid Employee emp) {
		return employeeService.saveEmployee(emp);
	}

}
