package org.example.demo_springmvc.controller;

import org.example.demo_springmvc.entity.Student;
import org.example.demo_springmvc.service.IStudentService;
import org.example.demo_springmvc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private IStudentService studentService;

//    public StudentController(IStudentService studentService) {
//        this.studentService = studentService;
//    }

    @GetMapping("/students")
    public String showList(Model model){
        List<Student>  studentList = studentService.findAll();
        model.addAttribute("studentList", studentList);
        return "student/list";
    }
}
