package org.example.demo_springmvc.repository;

import org.example.demo_springmvc.entity.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    Student findById(int id);
    boolean add(Student student);
}
