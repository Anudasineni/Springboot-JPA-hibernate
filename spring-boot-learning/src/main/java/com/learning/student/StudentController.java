package com.learning.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class StudentController {
    private final StudentService studentService; //=new StudentService

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public Student getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/hobbies")
    public String getHobbies() {
        return studentService.getHobbies();
    }

    @GetMapping("/student/{id}")
    public Optional<Student> getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);

    }
    @PostMapping("/student")
    public void addNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
     }
    @PutMapping("/updateStudent")
    public void updateStudent(@PathVariable Long id, @RequestParam(required = false) String name,@RequestParam(required = false) String email){
studentService.updateStudent(id,name,email);
    }
}


