package com.example.springboot_2.service;



import com.example.springboot_2.entity.Student;
import com.example.springboot_2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Logic nghiệp vụ Thêm sinh viên (Question 1)
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    // Lấy tất cả sinh viên (Dùng cho form thêm điểm)
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
}
