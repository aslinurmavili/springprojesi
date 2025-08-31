package com.asli.demo.service;
import com.asli.demo.entity.Employee;
import com.asli.demo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        return employeeRepository.findById(id)
                .map(employee -> {
                    employee.setName(updatedEmployee.getName());
                    employee.setDepartment(updatedEmployee.getDepartment());
                    return employeeRepository.save(employee);
                })
                .orElseThrow(() -> new RuntimeException("Employee not found with ID " + id));
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
