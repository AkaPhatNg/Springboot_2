package com.example.springboot_2.entity;

import jakarta.persistence.*;
import java.math.BigDecimal; // Dùng BigDecimal cho score1, score2 để chính xác hơn

@Entity
@Table(name = "student_score_t") // Ánh xạ với create table student_score_t
public class StudentScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_score_id")
    private Integer studentScoreId; // student_score_id int auto_increment primary key

    @Column(name = "score1", precision = 5, scale = 2)
    private BigDecimal score1; // score1 decimal(5,2)

    @Column(name = "score2", precision = 5, scale = 2)
    private BigDecimal score2; // score2 decimal(5,2)

    // Mối quan hệ với Student
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id") // student_id int (FK)
    private Student student;

    // Mối quan hệ với Subject
    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id") // subject_id int (FK)
    private Subject subject;

    // Constructors
    public StudentScore() {
    }

    // Getters and Setters
    public Integer getStudentScoreId() {
        return studentScoreId;
    }

    public void setStudentScoreId(Integer studentScoreId) {
        this.studentScoreId = studentScoreId;
    }

    public BigDecimal getScore1() {
        return score1;
    }

    public void setScore1(BigDecimal score1) {
        this.score1 = score1;
    }

    public BigDecimal getScore2() {
        return score2;
    }

    public void setScore2(BigDecimal score2) {
        this.score2 = score2;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}