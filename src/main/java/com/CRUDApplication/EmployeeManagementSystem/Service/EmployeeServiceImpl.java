package com.CRUDApplication.EmployeeManagementSystem.Service;

import com.CRUDApplication.EmployeeManagementSystem.Model.Employee;
import com.CRUDApplication.EmployeeManagementSystem.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeServiceInf {

    private final EmployeeRepository repository;

    // constructor injection (preferred)
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        // You can add validations here (e.g., unique email checks)
        return repository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        return repository.findById(id).map(existing -> {
            existing.setEmailid(employee.getEmailid());
            existing.setFirstname(employee.getFirstname());
            existing.setLastname(employee.getLastname());
            return repository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));
    }

    @Override
    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}
