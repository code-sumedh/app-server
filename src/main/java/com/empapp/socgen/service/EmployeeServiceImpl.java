package com.empapp.socgen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empapp.socgen.domain.Employee;
import com.empapp.socgen.exception.EmpException;
import com.empapp.socgen.repository.EmpRepo;

/**
 * The EmployeeService implementation class which is enabled with concrete
 * methods to satisfy the {@code EmployeeService} interface contract.
 * 
 * @author Sumedh
 * @since 23 Nov 2019
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	EmployeeServiceImpl() {
		System.out.println("Hey I am in EmployeeServiceImpl, I am a constructor");
	}

	@Autowired
	private EmpRepo empRepo;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.empapp.service.EmployeeService#getEmployees()
	 */
	@Override
	public List<Employee> getEmployees() {
		try {
			System.out.println("empRepo.findAll() sizeis : " + empRepo.findAll().size());
			return empRepo.findAll();
		} catch (Exception e) {
			throw new EmpException("Error while fetching Employees data");
		}
	}

	@Override
	public Employee saveEmployee(Employee emp) {
		try {
			System.out.println("In save impl " + emp);
			return empRepo.save(emp);
		} catch (Exception e) {
			e.printStackTrace();
			throw new EmpException("Error while saving Employee data");
		}
	}

}
