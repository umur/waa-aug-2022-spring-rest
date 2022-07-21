package edu.miu.restphaseIV.entity;

import lombok.Data;

import java.util.List;

@Data
public class Student {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String major;
    private float gpa;
    private List<Course> coursesTaken;

    private boolean deleted;

}
