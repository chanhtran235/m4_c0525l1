package org.example.demo_spring_data_jpa.rest_controller;


import org.example.demo_spring_data_jpa.dto.StudentDto;
import org.example.demo_spring_data_jpa.entity.Student;
import org.example.demo_spring_data_jpa.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/students")
public class RestStudentController {
    @Autowired
    private IStudentService studentService;

    @GetMapping("")
    public ResponseEntity<List<Student>> getAll() {
        List<Student> studentList = studentService.findAll();
        if (studentList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> detail(@PathVariable(name = "id") int id) {
        Student student = studentService.findById(id);
        if (student == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Student> save(@RequestBody Student student) {
        studentService.add(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> edit(@PathVariable(name = "id") int id) {
        Student student = studentService.findById(id);
        if (student == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // khg tìm thấy
        }
        // tìm thấy thì gọi server để xoá và trả về 204
        studentService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Student> edit(@PathVariable(name = "id") int id,
                                        @RequestBody Student student) {

        Student student1 = studentService.findById(id);
        if (student1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 khg tìm thấy
        }
        studentService.update(student); //
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); //204
    }


}
