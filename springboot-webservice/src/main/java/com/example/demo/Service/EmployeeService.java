package com.example.demo.Service;

import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.model.Employee;
import com.sun.xml.internal.txw2.IllegalSignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    public List<Employee> getEmployeeList(){
        return employeeRepository.findAll();
    }
    public Employee getEmployee(long employeeId) {
        Optional<Employee>employee= employeeRepository.findById(employeeId);
        try {
            if (employee.isPresent()) {
                return employee.get();
            }
        }
        catch (Exception e) {
        }
        return null;
    }
    public Employee updateEmployee(long id,Employee employee){
        Employee existingEmployee=employeeRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("Employee with"+id+"is not there"));
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setAge(employee.getAge());
        return employeeRepository.save(existingEmployee);
        }
    public void delete(long id){
        Employee employee=employeeRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("Given id"+id+"is not there in the database"));
            employeeRepository.deleteById(id);
        }
    }


