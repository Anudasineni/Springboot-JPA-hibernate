package com.anusha.Controller;

import com.anusha.Entity.Student;
import com.anusha.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    // handler method to handle list students and return mode and view
    // Model=>The View would be able to retrieve this object using the key “students”.In the html we can iterate
    //"students".
    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model) {

        // create student object to hold student form data.
        // or to catch object from spring form(using th:object = "${student}")

        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";//this name should be same as html file name.
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable long id, @ModelAttribute("student") Student student) {
        Student existing_student = studentService.getStudentById(id);
        existing_student.setFirstName(student.getFirstName());
        existing_student.setLastName(student.getLastName());
        existing_student.setEmail(student.getEmail());
        studentService.updateStudent(existing_student);
        return "redirect:/students"; //it will redirect to the List of Students page
    }

    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable long id, Model model) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}