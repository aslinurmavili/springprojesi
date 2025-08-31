package com.asli.demo.service;

import com.asli.demo.entity.Book;
import com.asli.demo.entity.Student;
import com.asli.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }


    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }


    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }


    public Student addBookToStudent(Long studentId, Book book) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.addBook(book);
            return studentRepository.save(student);
        } else {
            throw new RuntimeException("Öğrenci bulunamadı, ID: " + studentId);
        }
    }
}
