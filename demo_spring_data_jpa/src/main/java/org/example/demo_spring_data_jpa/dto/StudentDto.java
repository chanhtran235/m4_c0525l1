package org.example.demo_spring_data_jpa.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.demo_spring_data_jpa.entity.Jame;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class StudentDto {
//    @NotEmpty(message = "Không được để trống")
//    @Pattern(regexp = "^[A-Z][a-z]*(\\s[A-Z][a-z]*)+", message = "Tên không đúng định dạng")
    private String name;
    private Jame jame;
}
