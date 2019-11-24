package com.empapp.socgen.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import com.empapp.socgen.domain.Employee;
import com.empapp.socgen.dto.EmployeeDto;
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

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private EmpRepo empRepo;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.empapp.service.EmployeeService#getEmployees()
	 */
	@Override
	public List<EmployeeDto> getEmployees() {
		try {
			// Repository call to find all Employees

			return empRepo.findAll().stream().map(emp -> convertToDto(emp)).collect(Collectors.toList());
		} catch (Exception e) {
			throw new EmpException("Error while fetching Employees data");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.empapp.socgen.service.EmployeeService#saveEmployee(com.empapp.socgen.
	 * domain.Employee)
	 */
	@Override
	public EmployeeDto saveEmployee(EmployeeDto emp) {
		try {
			// New employee object is storing by repository
			return convertToDto(empRepo.save(convertToDomain(emp)));
		} catch (Exception e) {
			e.printStackTrace();
			throw new EmpException("Error while saving Employee data");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.empapp.socgen.service.EmployeeService#updateEmployee(com.empapp.
	 * socgen.domain.Employee)
	 */
	@Override
	public EmployeeDto updateEmployee(@Valid EmployeeDto emp) {
		try {
			return convertToDto(empRepo.save(convertToDomain(emp)));
		} catch (OptimisticLockingFailureException e) {
			throw e;
		} catch (Exception e) {
			throw new EmpException("Error while updating Employee data");
		}
	}

	private EmployeeDto convertToDto(Employee emp) {
		return modelMapper.map(emp, EmployeeDto.class);
	}

	private Employee convertToDomain(EmployeeDto emp) {
		return modelMapper.map(emp, Employee.class);
	}

}
