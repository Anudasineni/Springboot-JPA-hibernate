package com.anusha.Service;

import com.anusha.Entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student saveStudent(Student student);
    Student getStudentById(long id);
    Student updateStudent(Student existing_student);
    void deleteStudent(long id);
}
