package org.example.demo_thymeleaf.controller;

import org.example.demo_thymeleaf.entity.Student;
import org.example.demo_thymeleaf.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @ModelAttribute("subjects")
    public List<String> getSubject(){
        return  List.of("JS","Java","PHP", "SQL");
    }
    @Autowired
    private IStudentService studentService;

    @GetMapping(value = "")
    public String showList(Model model){
        List<Student>  studentList = studentService.findAll();
        model.addAttribute("studentList", studentList);
        return "student/list";
    }
    @GetMapping(value = "/add")
    public String showFormAdd(Model model){
        model.addAttribute("student", new Student());
        return "student/add";
    }
    @PostMapping("/add")
    public String save(@ModelAttribute Student student,
                       RedirectAttributes redirectAttributes
                       ){
        studentService.add(student);
        redirectAttributes.addFlashAttribute("mess","add new success");
        return "redirect:/students";

    }
    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam(name = "id") int detailId){
        ModelAndView modelAndView = new ModelAndView("student/detail");
        Student student = studentService.findById(detailId);
        modelAndView.addObject("student",student);
        return modelAndView;
    }

    @GetMapping("/{id}/detail")
    public ModelAndView detail1(@PathVariable(name = "id") int detailId){
        ModelAndView modelAndView = new ModelAndView("student/detail");
        Student student = studentService.findById(detailId);
        modelAndView.addObject("student",student);
        return modelAndView;
    }
}
