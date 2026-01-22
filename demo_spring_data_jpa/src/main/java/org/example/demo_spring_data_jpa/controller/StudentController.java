package org.example.demo_spring_data_jpa.controller;

import org.example.demo_spring_data_jpa.entity.Student;
import org.example.demo_spring_data_jpa.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private IStudentService studentService;

//    @GetMapping(value = "")
//    public String showList(@PageableDefault(size = 2,sort = "name",direction = Sort.Direction.DESC) Pageable pageable,
//                           Model model){
//        Page<Student> studentPage = studentService.findAll(pageable);
//        model.addAttribute("studentPage", studentPage);
//        return "student/list";
//    }
    @GetMapping(value = "")
    public String showList(@RequestParam(name = "page",defaultValue = "0")int page,
                           @RequestParam(name = "searchName",defaultValue = "") String searchName,
                           Model model){
        Sort sort = Sort.by("name").descending().and(Sort.by("jame").descending());
        Pageable pageable = PageRequest.of(page,2,sort);
        Page<Student> studentPage = studentService.findAll(searchName,pageable);
        model.addAttribute("studentPage", studentPage);
        model.addAttribute("searchName", searchName);
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
