package com.hibernate.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id
    private Integer sid;
    private String sname;
    @ManyToMany
    @JoinTable(name = "Stu_Book", joinColumns = @JoinColumn(name = "sidfk"), inverseJoinColumns = @JoinColumn(name = "bidfk"))
    private Set<Book> book;

}
