package com.oguzdirenc.EmployeeService.spesifications;

import com.oguzdirenc.EmployeeService.model.Employee;
import com.oguzdirenc.EmployeeService.model.Employee_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class EmployeeSpecification {

    public static Specification<Employee> hasFirstName(String firstName){
        return (((root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get(Employee_.FIRST_NAME), firstName);
        } ));
    }

    public static Specification<Employee> containsLastName(String lastName){
        return (((root, query, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get(Employee_.LAST_NAME),"%" + lastName + "%");
        } ));
    }

}
