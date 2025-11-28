package com.example.springboot_2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "subject_t") // Ánh xạ với create table subject_t
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private Integer subjectId; // subject_id int auto_increment primary key

    @Column(name = "subject_code", nullable = false, length = 20)
    private String subjectCode; // subject_code varchar(20) not null

    @Column(name = "subject_name", nullable = false, length = 100)
    private String subjectName; // subject_name varchar(100) not null

    @Column(name = "credit", nullable = false)
    private Integer credit; // credit int not null

    // Constructors
    public Subject() {
    }

    // Getters and Setters
    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }
}