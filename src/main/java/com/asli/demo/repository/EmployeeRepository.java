package com.asli.demo.repository;

import com.asli.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    List<Employee> findByNameContaining(String name);


    List<Employee> findByDepartment(String department);


    Optional<Employee> findById(Long id);


    List<Employee> findByDepartmentAndNameContaining(String department, String name);


    @Query("SELECT COUNT(e) FROM Employee e WHERE e.department = :department")
    Long countByDepartment(String department);


    @Query(value = "SELECT * FROM employee ORDER BY name ASC", nativeQuery = true)
    List<Employee> findAllOrderByName();


    @Query("SELECT e FROM Employee e WHERE e.salary > :amount")
    List<Employee> findEmployeesWithSalaryGreaterThan(Double amount);


    @Query(value = "SELECT * FROM employee e WHERE e.department = :dept", nativeQuery = true)
    List<Employee> findEmployeesByDepartmentNative(String dept);
}
