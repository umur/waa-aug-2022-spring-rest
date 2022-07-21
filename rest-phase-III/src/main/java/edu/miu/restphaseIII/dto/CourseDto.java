package edu.miu.restphaseIII.dto;

import edu.miu.restphaseIII.entity.Course;
import lombok.Data;

@Data
public class CourseDto {
    private int id;
    private String name;
    private String code;

    public Course converToCourse() {
        var course = new Course();
        course.setId(id);
        course.setName(name);
        course.setCode(code);
        return course;
    }
}
