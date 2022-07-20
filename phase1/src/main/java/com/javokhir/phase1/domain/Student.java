package com.javokhir.phase1.domain;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class Student {

    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private float gpa;
    private List<Course> coursesTaken;


}
