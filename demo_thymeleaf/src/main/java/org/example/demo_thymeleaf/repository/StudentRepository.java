package org.example.demo_thymeleaf.repository;

import jakarta.persistence.TypedQuery;
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
    private static List<Student> studentList = new ArrayList<>();
    static {
        studentList.add(new Student(1,"chánh"));
        studentList.add(new Student(2,"chánh2"));
    }
    @Override
    public List<Student> findAll() {
        Session session = ConnectionUtil.sessionFactory.openSession();
        TypedQuery<Student> typedQuery = session.createQuery("from Student", Student.class);
//        TypedQuery<Student> typedQuery = session.createNativeQuery("select * from student", Student.class);
        return typedQuery.getResultList();
    }

    @Override
    public Student findById(int id) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        return session.find(Student.class,id);
    }

    @Override
    public boolean add(Student student) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        try {
            session.save(student);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
        }
        return false;
    }
}
