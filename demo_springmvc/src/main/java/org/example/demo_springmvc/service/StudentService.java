package org.example.demo_springmvc.service;

import org.example.demo_springmvc.entity.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements IStudentService{
    private static List<Student> studentList = new ArrayList<>();
    static {
        studentList.add(new Student(1,"chánh"));
        studentList.add(new Student(2,"hải"));
    }
    @Override
    public List<Student> findAll() {
        return studentList;
    }
}
