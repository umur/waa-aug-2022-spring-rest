package com.lab2.waaaug2022springrest.phase3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private float gpa;
    private List<Course> coursesTaken;
}
