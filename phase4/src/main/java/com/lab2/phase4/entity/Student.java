package com.lab2.phase4.entity;

import lombok.Data;

import java.util.List;

@Data
public class Student {
    private int id;
    private String firstName, lastName, email, major;
    private List<Course> coursesTaken;
}
