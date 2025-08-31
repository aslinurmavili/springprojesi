package com.asli.demo.repository;

import com.asli.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {


    List<Book> findByStudentId(Long studentId);


    List<Book> findByTitleContaining(String title);


    List<Book> findByAuthorContaining(String author);
}
