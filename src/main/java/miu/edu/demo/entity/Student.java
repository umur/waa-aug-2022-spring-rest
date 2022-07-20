package miu.edu.demo.entity;

import lombok.Data;

import java.util.List;

@Data
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private List<Course> coursesTaken;
    private String gpa;

    private boolean deleted = false;

}
