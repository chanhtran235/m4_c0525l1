package org.example.demo_spring_data_jpa.controller;

import jakarta.validation.Valid;
import org.example.demo_spring_data_jpa.dto.StudentDto;
import org.example.demo_spring_data_jpa.entity.Student;
import org.example.demo_spring_data_jpa.exception.DuplicateAdminException;
import org.example.demo_spring_data_jpa.service.IStudentService;
import org.example.demo_spring_data_jpa.validate.StudentValidate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
//        Sort sort = Sort.by("name").descending().and(Sort.by("jame").descending());
        System.out.println(12/0);
        Pageable pageable = PageRequest.of(page,2);
        Page<Student> studentPage = studentService.findAll(searchName,pageable);
        model.addAttribute("studentPage", studentPage);
        model.addAttribute("searchName", searchName);

        return "student/list";
    }

    @GetMapping(value = "/add")
    public String showFormAdd(Model model){
        model.addAttribute("studentDto", new StudentDto());
        return "student/add";
    }
    @PostMapping("/add")
    public String save(@Valid @ModelAttribute StudentDto studentDto,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes
                       ){

        // code thêm cho kiểu custom validate
         new StudentValidate().validate(studentDto,bindingResult);
        //
        if (bindingResult.hasErrors()){
            return "student/add";
        }
        Student student = new Student();
        BeanUtils.copyProperties(studentDto,student);
            studentService.add(student);
        redirectAttributes.addFlashAttribute("mess","add new success");
        System.out.println("---------------------Nghiệp vụ chính chạy xong-------------------");;
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

    @ExceptionHandler(DuplicateAdminException.class)
    public String handleDuplicateException(){
        return "client";
    }
}
