package com.asli.demo;

import com.asli.demo.entity.Book;
import com.asli.demo.entity.Student;
import com.asli.demo.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringProjesiOlusturmaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringProjesiOlusturmaApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(StudentRepository studentRepository) {
		return args -> {

			Student student = new Student();
			student.setName("Ahmet Yılmaz");


			Book book1 = new Book();
			book1.setTitle("Java Temelleri");
			book1.setAuthor("Mehmet Demir");
			book1.setStudent(student);

			Book book2 = new Book();
			book2.setTitle("Spring Boot Rehberi");
			book2.setAuthor("Ayşe Kaya");
			book2.setStudent(student);

			student.getBooks().add(book1);
			student.getBooks().add(book2);


			studentRepository.save(student);

			System.out.println("Öğrenci ve kitaplar kaydedildi!");


			studentRepository.delete(student);
			System.out.println("Öğrenci silindi, ilişkili kitaplar da silindi!");
		};
	}
}
