package com.collection.mapping;

import com.collection.mapping.entity.Employee;
import com.collection.mapping.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class SpringbootCollectionMappingApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootCollectionMappingApplication.class, args);

    }

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {
        List<String> friends = Arrays.asList("carl", "marks");
        Map<String, String> cards = new HashMap<>();
        cards.put("adhar", "287391413");
        cards.put("pan", "erspd7827q");
        Set<String> project = new HashSet<>();
        project.add("p1");
        project.add("p2");

        Employee employee = new Employee(101, "john", friends, cards, project);
        employeeRepository.save(employee);
    }
}
