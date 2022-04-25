package com.learning.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.Month;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private AnushaRepo anushaRepo;
    final Student anusha = new Student(101l, "anusha", "anusha@gmail.com", LocalDate.of(1999, Month.OCTOBER, 10), 21);
    //final Student john = new Student(24, "John", "john@gmail.com", LocalDate.of(1999, Month.OCTOBER, 10), 21);

    public Student getStudents() {

        return anushaRepo.save(anusha);
        //return anushaRepo.findAll();
    }

    public String getHobbies() {
        return "irritating people";
    }

    public Optional<Student> getStudentById(int id) {

        return anushaRepo.findById((long) id);
    }

    public Student addNewStudent(Student student) {
        anushaRepo.save(student);
        return student;
    }


    public void updateStudent(Long id, String name, String email) {
       Student student =anushaRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Student with id:"+id +"doesnot exist") );
        if(name!=null && name.length()>0 && !Objects.equals(student.getName(),name)){
         student.setName(name);
        }
        if(email!=null && email.length()>0 && !Objects.equals(student.getEmail(),email)){
            student.setEmail(email);
        }
    }
}
