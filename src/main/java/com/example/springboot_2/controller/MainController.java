package com.example.springboot_2.controller;

import com.example.springboot_2.entity.Student;
import com.example.springboot_2.entity.StudentScore;
import com.example.springboot_2.entity.Subject;
import com.example.springboot_2.repository.SubjectRepository;
import com.example.springboot_2.service.StudentScoreService;
import com.example.springboot_2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentScoreService scoreService;

    @Autowired
    private SubjectRepository subjectRepository;

    // --- HIỂN THỊ DỮ LIỆU ---

    @GetMapping("/")
    public String scoreList(Model model) {
        List<StudentScore> scores = scoreService.findAllScores();
        model.addAttribute("scores", scores);
        model.addAttribute("scoreService", scoreService);
        return "score-list";
    }

    @GetMapping("/students")
    public String studentList(Model model) {
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "student-only-list";
    }

    // --- THÊM MỚI SINH VIÊN ---

    @GetMapping("/student/add")
    public String showStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "student-form";
    }

    @PostMapping("/student/save")
    public String saveStudent(@ModelAttribute("student") Student student) {
        // Xử lý cả Thêm mới và Sửa/Cập nhật
        studentService.save(student);
        return "redirect:/students";
    }

    // --- SỬA SINH VIÊN (ENDPOINT MỚI) ---

    /**
     * Hiển thị form để sửa thông tin sinh viên, sử dụng lại student-form.html
     */
    @GetMapping("/student/edit")
    public String showEditForm(@RequestParam("id") Integer studentId, Model model) {
        // 1. Tìm sinh viên hiện tại theo ID (sử dụng phương thức findById mới)
        Student student = studentService.findById(studentId);

        // 2. Đưa đối tượng sinh viên đó vào model
        model.addAttribute("student", student);

        return "student-form"; // Trả về form cũ để hiển thị dữ liệu đã có
    }

    // --- XÓA SINH VIÊN ---

    @GetMapping("/student/delete")
    public String deleteStudent(@RequestParam("id") Integer studentId) {
        studentService.deleteStudent(studentId);
        return "redirect:/students";
    }

    // --- THÊM ĐIỂM ---

    @GetMapping("/score/add")
    public String showScoreForm(Model model) {
        List<Student> students = studentService.findAll();
        List<Subject> subjects = subjectRepository.findAll();

        model.addAttribute("students", students);
        model.addAttribute("subjects", subjects);
        return "score-form";
    }

    @PostMapping("/score/save")
    public String saveScore(
            @RequestParam("studentId") Integer studentId,
            @RequestParam("subjectId") Integer subjectId,
            @RequestParam("score1") BigDecimal score1,
            @RequestParam("score2") BigDecimal score2) {

        scoreService.save(studentId, subjectId, score1, score2);
        return "redirect:/";
    }
}