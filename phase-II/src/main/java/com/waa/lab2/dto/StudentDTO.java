package com.waa.lab2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class StudentDTO {
    Long id;
    String firstName;
    String lastName;
    String email;
    String major;
    Double gpa;
    List<CourseDTO> coursesTaken;
}
