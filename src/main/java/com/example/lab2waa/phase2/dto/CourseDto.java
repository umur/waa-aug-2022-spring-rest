package com.example.lab2waa.phase2.dto;

import com.example.lab2waa.phase2.Model.Course;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class CourseDto {
    private int id;
    private String name;
    private String code;


    public CourseDto toDto(Course course){
        CourseDto dto = new CourseDto();
        dto.setId(course.getId());
        dto.setName(course.getName());
        dto.setCode(course.getCode());
        return dto;
    }
    public List<CourseDto> toDto(List<Course> courses){
        return courses.stream().map(x->toDto(x)).collect(Collectors.toList());
    }



    public Course dtoToEntity(){
        Course course = new Course();
        course.setId(getId());
        course.setName(getName());
        course.setCode(getCode());
        return course;
    }
    public List<Course> dtoToEntity(List<CourseDto> coursesDto){
        return coursesDto.stream().map(x->dtoToEntity()).collect(Collectors.toList());
    }


}
