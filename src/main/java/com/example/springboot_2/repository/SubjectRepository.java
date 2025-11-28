package com.example.springboot_2.repository;


import com.example.springboot_2.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    // Custom query methods here if needed
}
