package com.asli.demo.controller;

import com.asli.demo.entity.Student;
import com.asli.demo.service.StudentService;
import org.springframework.web.bind.annotation.*;
import com.asli.demo.entity.Book;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }


    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }


    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }


    @PostMapping("/{studentId}/books")
    public Student addBookToStudent(@PathVariable Long studentId, @RequestBody Book book) {
        return studentService.addBookToStudent(studentId, book);
    }
}
