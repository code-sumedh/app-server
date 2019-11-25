package com.empapp.socgen.controller;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empapp.socgen.dto.EmployeeDto;
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
	public List<EmployeeDto> getEmployees() {
		return employeeService.getEmployees();
	}

	/**
	 * @author sumedh
	 * @return
	 */
	@PostMapping(path = "", produces = "application/json")
	public EmployeeDto saveEmployee(@RequestBody @Valid EmployeeDto emp) {
		return employeeService.saveEmployee(emp);
	}

	/**
	 * @author sumedh
	 * @return
	 */
	@PatchMapping(path = "", produces = "application/json")
	public EmployeeDto patchEmployeeObject(@RequestBody @Valid EmployeeDto emp) {
		return employeeService.updateEmployee(emp);
	}

	/**
	 * @author sumedh
	 * @return
	 */
	@GetMapping(path = "get-emp/{id}", produces = "application/json")
	public EmployeeDto getEmployeeObject(@PathVariable("id") String id) {
		return employeeService.getEmployeeById(id);
	}
	
	/**
	 * @author sumedh
	 * @return
	 */
	@DeleteMapping(path = "delete-emp/{id}")
	public String deleteEmployeeObject(@PathVariable("id") String id) {
		return employeeService.deleteEmployeeById(id);
	}

}
