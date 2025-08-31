package com.asli.demo.service;

import com.asli.demo.entity.Book;
import com.asli.demo.entity.Student;
import com.asli.demo.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Öğrenci bulunamadı, ID: " + studentId));
        student.addBook(book);
        return studentRepository.save(student);
    }

    public List<Book> getBooksOfStudent(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Öğrenci bulunamadı, ID: " + studentId));
        return student.getBooks();
    }


    public Page<Student> getStudentsPage(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }
}
