package com.javokhir.phase2.dto;

import com.javokhir.phase1.domain.Course;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class CourseDto {

    private UUID id;
    private String name;
    private String code;

    public static CourseDto createFromEntity(Course course){
        return CourseDto.builder()
                .id(course.getId())
                .name(course.getName())
                .code(course.getCode())
                .build();
    }
}
