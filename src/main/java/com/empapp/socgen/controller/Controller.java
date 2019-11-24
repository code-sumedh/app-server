package com.empapp.socgen.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empapp.socgen.domain.Employee;
import com.empapp.socgen.service.EmployeeService;

/**
 * End-point controller class to do all CRUD for Employee repo using service
 * logic.
 * 
 * @author sumedh
 *
 */
@RestController
@RequestMapping(path = "/employees")
public class Controller {

	@Autowired
	private EmployeeService employeeService;

	/**
	 * @author sumedh
	 * @return
	 */
	@GetMapping(path = "", produces = "application/json")
	public List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}

	/**
	 * @author sumedh
	 * @return
	 */
	@PutMapping(path = "", produces = "application/json")
	public Employee saveEmployee(@RequestBody @Valid Employee emp) {
		return employeeService.saveEmployee(emp);
	}

	/**
	 * @author sumedh
	 * @return
	 */
	@PatchMapping(path = "", produces = "application/json")
	public Employee patchEmployeeObject(@RequestBody @Valid Employee emp) {
		return employeeService.updateEmployee(emp);
	}

}
