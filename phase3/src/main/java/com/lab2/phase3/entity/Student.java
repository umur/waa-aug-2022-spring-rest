package com.lab2.phase3.entity;

import lombok.Data;

import java.util.List;

@Data
public class Student {
    private int id;
    private String firstName, lastName, email, major;
    private List<Course> coursesTaken;
}
