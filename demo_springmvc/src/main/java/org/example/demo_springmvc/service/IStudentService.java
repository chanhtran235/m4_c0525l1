package org.example.demo_springmvc.service;

import org.example.demo_springmvc.entity.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
}
