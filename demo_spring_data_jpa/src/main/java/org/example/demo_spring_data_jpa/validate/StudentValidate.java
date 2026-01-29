package org.example.demo_spring_data_jpa.validate;

import org.example.demo_spring_data_jpa.dto.StudentDto;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class StudentValidate implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        // kiểm tra validate
        StudentDto studentDto = (StudentDto) target;
        if (studentDto.getName().equals("")){
            errors.rejectValue("name",null,"Không được để trống");
        } else if (!studentDto.getName().matches("^[A-Z][a-z]*(\\s[A-Z][a-z]*)*")) {
            errors.rejectValue("name",null,"Không đúng định dạng");
        }


    }
}
