package com.asli.demo.controller;

import com.asli.demo.entity.Employee;
import com.asli.demo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // --- CRUD Endpoints ---
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }


    @GetMapping("/salary-greater-than/{amount}")
    public List<Employee> getEmployeesWithSalaryGreaterThan(@PathVariable Double amount) {
        return employeeService.findEmployeesWithSalaryGreaterThan(amount);
    }


    @GetMapping("/department-native/{dept}")
    public List<Employee> getEmployeesByDepartmentNative(@PathVariable String dept) {
        return employeeService.findEmployeesByDepartmentNative(dept);
    }
}
