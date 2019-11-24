package com.empapp.socgen.service;

import java.util.List;

import javax.validation.Valid;

import com.empapp.socgen.domain.Employee;

/**
 * The EmployeeService exposes all abstract methods which are related to
 * Employee service.
 * 
 * @author Sumedh
 * @since 23 Nov 2019
 */
public interface EmployeeService {

	/**
	 * @author sumedh
	 * @return employees
	 */
	List<Employee> getEmployees();

	/**
	 * @author sumedh
	 * @param emp
	 * @return
	 */
	Employee saveEmployee(Employee emp);

	/**
	 * @author sumedh
	 * @param emp
	 * @return
	 */
	Employee updateEmployee(@Valid Employee emp);

}
