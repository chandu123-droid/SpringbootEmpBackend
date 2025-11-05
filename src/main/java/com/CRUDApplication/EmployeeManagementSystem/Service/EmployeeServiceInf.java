package com.CRUDApplication.EmployeeManagementSystem.Service;

import com.CRUDApplication.EmployeeManagementSystem.Model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeServiceInf {
    List<Employee> getAllEmployees();
    Optional<Employee> getEmployeeById(Long id);
    Employee saveEmployee(Employee employee);
    Employee updateEmployee(Long id, Employee employee);
    void deleteEmployee(Long id);
}
