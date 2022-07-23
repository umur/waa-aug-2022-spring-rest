package edu.miu.restphaseIII.dto;

import lombok.Data;

import java.util.List;

@Data
public class StudentDto {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String major;
    private float gpa;
    private List<CourseDto> coursesTaken;

}
