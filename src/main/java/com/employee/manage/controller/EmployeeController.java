package com.employee.manage.controller;

import com.employee.manage.exception.ResourceNotFoundException;
import com.employee.manage.model.Employee;
import com.employee.manage.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok().body(employeeService.findAllEmployees());
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") final Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok().body(employeeService.findEmployeeById(id));
    }

    @PostMapping("/employees")
    public void createEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable("id") final Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok().body(employeeService.updateEmployee(employee, id));
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable("id") final Long id) throws ResourceNotFoundException {
        employeeService.removeEmployee(id);
    }
}