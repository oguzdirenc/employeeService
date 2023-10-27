package com.oguzdirenc.EmployeeService.repository;

import com.oguzdirenc.EmployeeService.model.Employee;
import com.oguzdirenc.EmployeeService.spesifications.EmployeeSpecification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long>, JpaSpecificationExecutor<Employee> {
}
