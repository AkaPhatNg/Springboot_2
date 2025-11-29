package com.example.springboot_2.service;

import com.example.springboot_2.entity.Student;
import com.example.springboot_2.entity.StudentScore;
import com.example.springboot_2.repository.StudentRepository;
import com.example.springboot_2.repository.StudentScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentScoreRepository studentScoreRepository;

    // Logic nghiệp vụ Thêm mới/Cập nhật (Question 1 & Edit)
    // JPA sẽ tự động cập nhật nếu đối tượng Student đã có ID
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    // Lấy tất cả sinh viên (Dùng cho form thêm điểm và danh sách SV)
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    /**
     * CHỨC NĂNG SỬA: Tìm sinh viên theo ID
     */
    public Student findById(Integer studentId) {
        // findById trả về Optional, nên ta dùng orElse(null) để trả về Student hoặc null
        // Đảm bảo rằng ID tồn tại trước khi trả về
        return studentRepository.findById(studentId).orElse(null);
    }

    /**
     * CHỨC NĂNG XÓA: Xóa sinh viên và tất cả điểm số liên quan
     * @Transactional đảm bảo CSDL nhất quán (hoặc xóa cả hai, hoặc không xóa gì)
     */
    @Transactional
    public void deleteStudent(Integer studentId) {
        // 1. Tìm và xóa tất cả điểm số liên quan đến sinh viên này
        List<StudentScore> scoresToDelete = studentScoreRepository.findByStudent_StudentId(studentId);
        studentScoreRepository.deleteAll(scoresToDelete);

        // 2. Xóa sinh viên
        studentRepository.deleteById(studentId);
    }
}