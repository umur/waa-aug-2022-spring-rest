package edu.miu.restphaseIII.dto;

import edu.miu.restphaseIII.entity.Student;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class StudentDto {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String major;
    private float gpa;
    private List<CourseDto> coursesTaken;

    public Student convertToStudent() {
        var student = new Student();
        student.setId(id);
        student.setFirstname(firstname);
        student.setLastname(lastname);
        student.setEmail(email);
        student.setMajor(major);
        student.setGpa(gpa);
        student.setCoursesTaken(coursesTaken.stream().map(c -> c.converToCourse()).collect(Collectors.toList()));
        return student;
    }
}
