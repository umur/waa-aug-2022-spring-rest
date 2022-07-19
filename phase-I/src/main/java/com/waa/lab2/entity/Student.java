package com.waa.lab2.entity;

import lombok.Data;

import java.util.List;

@Data
public class Student {
    Long id;
    String firstName;
    String lastName;
    String email;
    String major;
    List<Course> coursesTaken;

    Boolean deleted;
}
