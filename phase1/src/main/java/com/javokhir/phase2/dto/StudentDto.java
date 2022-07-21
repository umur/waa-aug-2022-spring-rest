package com.javokhir.phase2.dto;


import com.javokhir.phase1.domain.Student;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@Builder
public class StudentDto {

    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private float gpa;
    private List<CourseDto> coursesTaken;

    public static StudentDto createFromEntity(Student student){
        return StudentDto.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .email(student.getEmail())
                .major(student.getMajor())
                .gpa(student.getGpa())
                .coursesTaken(student.getCoursesTaken().stream()
                        .map(CourseDto::createFromEntity)
                        .collect(Collectors.toList()))
                .build();
    }
}
