package com.empapp.socgen.controller;

import java.util.List;

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

	@GetMapping(produces = "application/json")
	public List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}

	@PutMapping(produces = "application/json")
	public Employee saveEmployee(@RequestBody Employee emp) {
		return employeeService.saveEmployee(emp);
	}

	// @PostMapping(path= "/", consumes = "application/json", produces =
	// "application/json")
	// public ResponseEntity<Object> addEmployee(@RequestBody Employee employee)
	// {
	// Integer id = employeeDao.getAllEmployees().getEmployeeList().size() + 1;
	// employee.setId(id);
	//
	// employeeDao.addEmployee(employee);
	//
	// URI location = ServletUriComponentsBuilder.fromCurrentRequest()
	// .path("/{id}")
	// .buildAndExpand(employee.getId())
	// .toUri();
	//
	// return ResponseEntity.created(location).build();
	// }
}
