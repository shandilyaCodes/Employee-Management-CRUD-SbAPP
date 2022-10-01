package com.employee.manage.service;

import com.employee.manage.exception.ResourceNotFoundException;
import com.employee.manage.model.Employee;
import com.employee.manage.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Get All Employees
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    // Find an Employee by ID
    public Employee findEmployeeById(final Long id) throws ResourceNotFoundException {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with ID not present"));
    }

    // Save a Employee
    public void saveEmployee(final Employee employee) {
        Employee save = employeeRepository.save(employee);
    }

    // Update Employee Details
    public Employee updateEmployee(final Employee employeeUpdate, final Long id) throws ResourceNotFoundException {
        Employee employeePrev = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with ID not present"));
        employeePrev.setEmailId(employeeUpdate.getEmailId());
        return employeeRepository.save(employeePrev);
    }

    // Delete Employee details
    public void removeEmployee(final Long id) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with ID not present"));
        employeeRepository.delete(employee);
    }
}