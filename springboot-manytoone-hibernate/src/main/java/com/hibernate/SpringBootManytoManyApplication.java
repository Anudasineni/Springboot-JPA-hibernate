package com.hibernate;

import com.hibernate.entity.Book;
import com.hibernate.entity.Student;
import com.hibernate.repository.BookRepository;
import com.hibernate.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SpringBootManytoManyApplication implements CommandLineRunner {
    public static void main(String[] args) {

        SpringApplication.run(SpringBootManytoManyApplication.class, args);
    }

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        Book book1 = new Book(50, "atomic habits");
        Book book2 = new Book( 60,"panchatantra");
        Book book3 = new Book(70, "amara chitra kathalu");
        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);

        Set<Book> b1 = new HashSet<>();
        b1.add(book1);
        b1.add(book2);
        b1.add(book3);
        Student student1 = new Student(1, "john",b1);
        Student student2 = new Student(2, "carl",b1);
        Student student3= new Student(3, "marl",b1);

        //student1.getBook().add(book3);
        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);
    }
}
