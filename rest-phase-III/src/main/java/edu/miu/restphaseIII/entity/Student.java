package edu.miu.restphaseIII.entity;

import edu.miu.restphaseIII.dto.StudentDto;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class Student {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String major;
    private float gpa;
    private List<Course> coursesTaken;

    private boolean deleted;

    public StudentDto convertToDto() {
        var studentDto = new StudentDto();
        studentDto.setId(id);
        studentDto.setFirstname(firstname);
        studentDto.setLastname(lastname);
        studentDto.setEmail(email);
        studentDto.setMajor(major);
        studentDto.setGpa(gpa);
        studentDto.setCoursesTaken(coursesTaken.stream().map(c -> c.convertToDto()).collect(Collectors.toList()));
        return studentDto;
    }
}
