package com.waa.lab2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class Student {
    Long id;
    String firstName;
    String lastName;
    String email;
    String major;
    List<Course> coursesTaken;

    boolean deleted;
}
