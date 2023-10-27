package com.oguzdirenc.EmployeeService.controller;

import com.oguzdirenc.EmployeeService.model.Employee;
import com.oguzdirenc.EmployeeService.model.EmployeePage;
import com.oguzdirenc.EmployeeService.model.EmployeeSearchCriteria;
import com.oguzdirenc.EmployeeService.repository.EmployeeRepository;
import com.oguzdirenc.EmployeeService.service.EmployeeService;
import com.oguzdirenc.EmployeeService.spesifications.EmployeeSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeService employeeService, EmployeeRepository employeeRepository) {
        this.employeeService = employeeService;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public ResponseEntity<Page<Employee>> getEmployees(EmployeePage employeePage,
                                                       EmployeeSearchCriteria employeeSearchCriteria) {
        return new ResponseEntity<>(employeeService.getEmployees(employeePage,employeeSearchCriteria),
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.addEmployee(employee),HttpStatus.CREATED);
    }

    @GetMapping("/{firstName}")
    public ResponseEntity<List<Employee>> getEmployeesByFirstName(@PathVariable("firstName") String firstname) {

        Specification<Employee> specification = Specification.where(EmployeeSpecification.hasFirstName(firstname));

        return new ResponseEntity<>(employeeRepository.findAll(specification),
                HttpStatus.OK);
    }
}
