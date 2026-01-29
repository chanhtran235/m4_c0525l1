package org.example.demo_spring_data_jpa.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.example.demo_spring_data_jpa.dto.StudentDto;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    private static int count = 0;

    // ghi số lần truy cập vào trang list
//    @After("execution(* org.example.demo_spring_data_jpa.controller.StudentController.showList(..))")
//    public void countVisitList(){
//        count ++;
//        System.out.println("--------------------");
//        System.out.println(count);
//    }
//    @AfterReturning("execution(* org.example.demo_spring_data_jpa.controller.StudentController.save(..))")
//    public void loggingAddSuccess(JoinPoint joinPoint){
//        Object[] args =joinPoint.getArgs();
//        StudentDto studentDto = (StudentDto) args[0];
//        System.out.println("---------------------------------------------");
//        System.out.println(studentDto.getName());
//        System.out.println("-------Thêm mới thành công-------------");
//    }
//    @AfterThrowing("execution(* org.example.demo_spring_data_jpa.controller.StudentController.save(..))")
//    public void loggingAddException(){
//        System.out.println("-------Thêm mới bi exception -------------");
//    }
    @Around("execution(* org.example.demo_spring_data_jpa.controller.StudentController.save(..))")
    public Object loggingAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("--------Code nv phụ chạy trước sẽ code ở đây");
        Object object = proceedingJoinPoint.proceed();
        System.out.println("--------Code nv phụ chạy sau sẽ code ở đây");
        return object;
    }
}
