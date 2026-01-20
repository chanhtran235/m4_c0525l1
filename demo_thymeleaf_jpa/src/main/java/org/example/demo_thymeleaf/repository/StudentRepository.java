package org.example.demo_thymeleaf.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.example.demo_thymeleaf.entity.Student;
import org.example.demo_thymeleaf.util.ConnectionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Student> findAll() {
          TypedQuery<Student> typedQuery = entityManager.createQuery("from Student",Student.class);
//        TypedQuery<Student> typedQuery = session.createNativeQuery("select * from student", Student.class);
        return typedQuery.getResultList();
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class,id);
    }

    @Transactional
    @Override
    public boolean add(Student student) {
        try {
            entityManager.persist(student);
            return true;
        }catch (Exception e){
            System.out.println("Thêm mới lỗi");
        }
        return false;
    }

    @Override
    public boolean update(int id, Student student) {
        Student eidtStudent = findById(id);
        if (eidtStudent!=null){
            eidtStudent.setName(student.getName());
            try{
                entityManager.merge(eidtStudent);
                return true;
            }catch (Exception e){
                System.out.println("lỗi update");
            }
        }
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        Student deleteStudent = findById(id);
        if (deleteStudent!=null){
            try{
                entityManager.remove(deleteStudent);
                return true;
            }catch (Exception e){
                System.out.println("lỗi xoá");
            }
        }
        return false;
    }
}
