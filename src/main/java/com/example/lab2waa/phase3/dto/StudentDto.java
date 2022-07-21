package com.example.lab2waa.phase3.dto;


import com.example.lab2waa.phase3.Model.Course;
import com.example.lab2waa.phase3.Model.Student;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class StudentDto {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private List<Course> coursesTaken;
    private double gpa;


//    public StudentDto toDto(Student student){
//        StudentDto dto = new StudentDto();
//        dto.setId(student.getId());
//        dto.setFirstName(student.getFirstName());
//        dto.setLastName(student.getLastName());
//        dto.setEmail(student.getEmail());
//        dto.setMajor(student.getMajor());
//        dto.setCoursesTaken(student.getCoursesTaken());
//        dto.setGpa(student.getGpa());
//        return dto;
//    }
//    public List<StudentDto> toDto(List<Student> students){
//        return students.stream().map(x->toDto(x)).collect(Collectors.toList());
//    }
//
//
//    public Student dtoToEntity(){
//        Student student = new Student();
//        student.setId(getId());
//        student.setFirstName(getFirstName());
//        student.setLastName(getLastName());
//        student.setEmail(getEmail());
//        student.setMajor(getMajor());
//        student.setCoursesTaken(getCoursesTaken());
//        student.setGpa(getGpa());
//        return student;
//    }
//    public List<Student> dtoToEntity(List<StudentDto> studentsDto){
//        return studentsDto.stream().map(x->dtoToEntity()).collect(Collectors.toList());
//    }
}
