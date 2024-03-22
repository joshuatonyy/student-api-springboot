package com.joshuatony.studentrepo;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.Nullable;

import jakarta.annotation.Generated;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Document
public class Student {
    @Id
    private String id;  
    @NotEmpty(message = "Name is mandatory")
    private String name;
    @Indexed(unique = true)
    @NotEmpty(message = "Email is mandatory")
    private String email;
    private Gender gender;
    private Address address;
    @NotNull(message = "Grade Year is mandatory")
    @Min(value = 1)
    @Max(value = 3)
    private Integer gradeYear;
    @Min(value = 0)
    @Max(value = 100)
    private Double averageGrade;
    private LocalDateTime createdAt;

    public Student(String name, String email, Gender gender, Address address, Integer gradeYear, Double averageGrade,
            LocalDateTime createdAt) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.gradeYear = gradeYear;
        this.averageGrade = averageGrade;
        this.createdAt = createdAt;
    }
}
