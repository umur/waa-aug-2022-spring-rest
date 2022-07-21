package com.lab2.phase2.dto;

import com.lab2.phase2.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {
    private int id;
    private String code;
    private String name;

    public Course toEntity() {
        Course course = new Course();
        course.setId(this.getId());
        course.setCode(this.getCode());
        course.setName(this.getName());
        return course;
    }
}
