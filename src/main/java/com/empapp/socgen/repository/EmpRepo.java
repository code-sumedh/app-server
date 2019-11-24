package com.empapp.socgen.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.empapp.socgen.domain.Employee;

/**
 * Employee Repository
 * @since 23 Nov 2019
 * @author sumedh
 *
 */
@Repository
public interface EmpRepo extends MongoRepository<Employee, String> {

}
