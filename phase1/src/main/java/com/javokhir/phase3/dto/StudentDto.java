package com.javokhir.phase3.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private float gpa;
    private List<CourseDto> coursesTaken;

}
