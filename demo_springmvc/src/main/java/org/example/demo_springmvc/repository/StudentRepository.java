package org.example.demo_springmvc.repository;

import org.example.demo_springmvc.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository{
    private static List<Student> studentList = new ArrayList<>();
    static {
        studentList.add(new Student(1,"chánh",true,List.of("JS","Java","PHP"),"C05"));
        studentList.add(new Student(2,"chánh2",true,List.of("JS","PHP"),"C05"));
    }
    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public Student findById(int id) {
        for (int i = 0; i <studentList.size() ; i++) {
            if (studentList.get(i).getId()==id){
                return studentList.get(i);
            }
        }
        return null;
    }

    @Override
    public boolean add(Student student) {
        studentList.add(student);
        return true;
    }
}
