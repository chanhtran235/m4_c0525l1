package org.example.demo_thymeleaf.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
//@Table(name = "sinh_vien")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// id tự tăng
    private int id;
//    @Column(name = "ten", columnDefinition = "TEXT")
    private String name;

    public Student() {
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
