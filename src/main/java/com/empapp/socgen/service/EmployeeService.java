package com.empapp.socgen.service;

import java.util.List;

import com.empapp.socgen.dto.EmployeeDto;

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
	List<EmployeeDto> getEmployees();

	/**
	 * @author sumedh
	 * @param emp
	 * @return
	 */
	EmployeeDto saveEmployee(EmployeeDto emp);

	/**
	 * @author sumedh
	 * @param emp
	 * @return
	 */
	EmployeeDto updateEmployee(EmployeeDto emp);

	/**
	 * @author sumedh
	 * @param id
	 * @return
	 */
	EmployeeDto getEmployeeById(String id);

	/**
	 * @author sumedh
	 * @param id
	 * @return
	 */
	String deleteEmployeeById(String id);

}
