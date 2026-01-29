package org.example.demo_spring_data_jpa.service;

import org.example.demo_spring_data_jpa.entity.Student;
import org.example.demo_spring_data_jpa.exception.DuplicateAdminException;
import org.example.demo_spring_data_jpa.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService{
    @Autowired
    private IStudentRepository studentRepository;
    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll() ;
    }

    @Override
    public Page<Student> findAll(String searchName,Pageable pageable) {
        return studentRepository.findByNameContaining(searchName,pageable);
    }

    @Override
    public List<Student> findByName(String name) {
        return studentRepository.timKiemTheoTen("%"+name+"%");
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public boolean add(Student student) throws DuplicateAdminException {
        if (student.getName().equals("Admin")){
            throw new DuplicateAdminException("Trùng tên với tên Admin");
        }
        try{
            studentRepository.save(student);
            return true;
        }catch (Exception e){
            System.out.println(" lỗi thêm mới");
        }
        return false;
    }
}
