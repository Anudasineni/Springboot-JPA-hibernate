package com.collection.mapping.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name = "emptab")
public class Employee {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Integer empId;
    @Column(name = "emp_name")
    private  String empName;
    @ElementCollection
    @CollectionTable(name = "emp_friends",joinColumns = @JoinColumn(name="eid"))
    @OrderColumn(name = "pos")
    @Column(name = "frd_name")
    private List<String> friends;
    @ElementCollection
    @CollectionTable(name = "emp_cards",joinColumns = @JoinColumn(name="eid"))
    @MapKeyColumn(name = "cname")
    @Column (name = "cno")
    private Map<String ,String> cards;
    @ElementCollection
    @CollectionTable(name = "emp_project",joinColumns = @JoinColumn(name="eid"))
    @Column(name = "projName")
    private Set<String> project;

}
