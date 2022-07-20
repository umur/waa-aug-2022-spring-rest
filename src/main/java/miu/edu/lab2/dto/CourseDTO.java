package miu.edu.lab2.dto;

import lombok.Data;
import miu.edu.lab2.entity.Course;

@Data
public class CourseDTO {
    int id;
    String name;
    String code;

    CourseDTO toCourseDto(Course course) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(course.getId());
        courseDTO.setName(course.getName());
        courseDTO.setCode(course.getCode());

        return courseDTO;
    }

    Course toCourse() {
        return new Course(this.id, this.name, this.code);
    }
}
