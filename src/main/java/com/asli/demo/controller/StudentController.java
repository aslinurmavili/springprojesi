package com.asli.demo.controller;

import com.asli.demo.entity.Student;
import com.asli.demo.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Öğrenci ekleme (POST)
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    // Öğrencileri listeleme (GET)
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
}
