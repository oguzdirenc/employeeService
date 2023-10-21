package com.oguzdirenc.EmployeeService.repository;

import com.oguzdirenc.EmployeeService.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long> {
}
