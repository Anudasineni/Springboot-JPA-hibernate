package com.example.demo.Controller;

import com.example.demo.Service.EmployeeService;
import com.example.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/employee")
    public List<Employee> getAllEmployees() {
        return employeeService.getEmployeeList();
    }

    @GetMapping("/employee/{employeeid}")
    public Employee getEmployeeById(@PathVariable long employeeid) {
        return employeeService.getEmployee(employeeid);
    }

    @PutMapping("/employe/{employeeid}")
    public Employee updateEmployee(@PathVariable long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/employee/{id}")
    public String delete(@PathVariable long id) {
        employeeService.delete(id);
        return "deleted successfully";
    }
}
