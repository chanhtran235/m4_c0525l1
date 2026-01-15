package org.example.demo_thymeleaf.repository;

import org.example.demo_thymeleaf.entity.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    Student findById(int id);
    boolean add(Student student);
}
