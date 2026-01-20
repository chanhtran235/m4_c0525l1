package org.example.demo_spring_data_jpa.service;

import org.example.demo_spring_data_jpa.entity.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    List<Student> findByName(String name);
    Student findById(int id);
    boolean add(Student student);

}
