package com.waa.lab2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    Long id;
    String firstName;
    String lastName;
    String email;
    String major;
    Double gpa;
    List<Course> coursesTaken;

    boolean deleted;
}
