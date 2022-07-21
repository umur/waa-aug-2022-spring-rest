package studentcourseapplication.domain;

import lombok.Data;

import java.util.List;
@Data
public class Student {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private float gpa;
    private List<Course> courseList;

    public Student(Long id, String firstName, String lastName, String email, String major, float gpa, List<Course> courseList) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.major = major;
        this.gpa = gpa;
        this.courseList = courseList;
    }
}
