package org.example.demo_spring_data_jpa.service;

import org.example.demo_spring_data_jpa.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    Page<Student> findAll(String searchName,Pageable pageable);
    List<Student> findByName(String name);
    Student findById(int id);
    boolean add(Student student);

}
