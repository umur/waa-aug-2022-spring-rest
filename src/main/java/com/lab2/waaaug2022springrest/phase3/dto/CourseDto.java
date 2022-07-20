package com.lab2.waaaug2022springrest.phase3.dto;

import com.lab2.waaaug2022springrest.phase3.entity.Course;
import lombok.Data;

@Data
public class CourseDto {
    private int id;
    private String name;
    private String code;


    public CourseDto toDto(Course course){
        CourseDto dto = new CourseDto();
        dto.setId(course.getId());
        dto.setCode(course.getCode());
        dto.setName(course.getName());
        return dto;
    }

    public Course toEntity(){
        Course course = new Course();
        course.setId(getId());
        course.setName(getName());
        course.setCode(getCode());
        return course;
    }
}
