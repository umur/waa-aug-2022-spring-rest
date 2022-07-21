package com.lab2.phase3.dto;

import com.lab2.phase3.entity.Course;
import com.lab2.phase3.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private int id;
    private String firstName, lastName, email, major;
    private List<Course> coursesTaken;

    public Student toEntity() {
        Student student = new Student();
        student.setId(this.getId());
        student.setEmail(this.getEmail());
        student.setFirstName(this.getFirstName());
        student.setLastName(this.getLastName());
        student.setMajor(this.getMajor());
        student.setCoursesTaken(this.getCoursesTaken());
        return student;
    }
}
