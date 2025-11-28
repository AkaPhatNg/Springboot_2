package com.example.springboot_2.repository;

import com.example.springboot_2.entity.StudentScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentScoreRepository extends JpaRepository<StudentScore, Integer> {
    // Lấy tất cả điểm của một sinh viên (cho Q3)
    List<StudentScore> findByStudent_StudentId(Integer studentId);
}
