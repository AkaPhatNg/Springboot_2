package com.example.springboot_2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student_t") // Ánh xạ với create table student_t
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer studentId; // student_id int auto_increment primary key

    @Column(name = "student_code", nullable = false, length = 20)
    private String studentCode; // student_code varchar(20) not null

    @Column(name = "full_name", nullable = false, length = 100)
    private String fullName; // full_name varchar(100) not null

    @Column(name = "address", length = 255)
    private String address; // address varchar(255)

    // Constructors
    public Student() {
    }

    // Getters and Setters
    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}