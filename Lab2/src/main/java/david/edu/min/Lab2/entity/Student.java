package david.edu.min.Lab2.entity;

import lombok.Data;

import java.util.List;

@Data
public class Student {
    private int    id;
    private String    firstName;
    private String    lastName;
    private String    email;
    private String    major;
    private float    gpa;
    private List<Course> coursesTaken;
}
