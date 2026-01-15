package org.example.demo_thymeleaf.service;

import org.example.demo_thymeleaf.entity.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    Student findById(int id);
    boolean add(Student student);

}
