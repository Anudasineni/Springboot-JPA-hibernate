package com.learning.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnushaRepo extends JpaRepository<Student, Long> {
}
