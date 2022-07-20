package com.miu.lab.dto;

import com.miu.lab.entity.Course;
import lombok.Data;

import java.util.List;

@Data
public class StudentDto {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String major;
    private double gpa;
    private List<Course> coursesTaken;
}
