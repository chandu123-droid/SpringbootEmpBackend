package com.CRUDApplication.EmployeeManagementSystem.Controller;

import com.CRUDApplication.EmployeeManagementSystem.Model.Employee;
import com.CRUDApplication.EmployeeManagementSystem.Service.EmployeeServiceInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
<<<<<<< HEAD
@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "https://springbootempfrontend.onrender.com")
=======

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = {"http://localhost:5173","http://localhost:3000","https://springbootempfrontend.onrender.com"}) 
>>>>>>> 53ffa97 (updated)
public class EmployeeController {

    private final EmployeeServiceInf service;

    @Autowired
    public EmployeeController(EmployeeServiceInf service) {
        this.service = service;
    }

    // RESTful endpoints
    @GetMapping
    public List<Employee> getAll() {
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) {
        return service.getEmployeeById(id).orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));
    }

    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        return service.saveEmployee(employee);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee employee) {
        return service.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteEmployee(id);
        return "Employee deleted successfully!";
    }

    // Legacy compatibility endpoints (if your frontend expects these exact paths)
    @GetMapping("/showAllEmpdata")
    public List<Employee> showAllEmpdata() {
        return getAll();
    }

    @GetMapping("/showEmpdataByid/{id}")
    public Employee showEmpdataById(@PathVariable Long id) {
        return getById(id);
    }

    @PostMapping("/insertEmpdata")
    public Employee insertEmpdata(@RequestBody Employee employee) {
        return create(employee);
    }

    @PutMapping("/updateEmpdataById/{id}")
    public Employee updateEmpdataById(@PathVariable Long id, @RequestBody Employee employee) {
        return update(id, employee);
    }

    @DeleteMapping("/deleteEmpByid/{id}")
    public String deleteEmpByid(@PathVariable Long id) {
        return delete(id);
    }
}
