package org.example.demo_thymeleaf.service;

import org.example.demo_thymeleaf.entity.Student;
import org.example.demo_thymeleaf.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService{
    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll() ;
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id);
    }

    @Override
    public boolean add(Student student) {

        return studentRepository.add(student);
    }
}
