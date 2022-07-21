package edu.miu.restphaseIII.entity;

import edu.miu.restphaseIII.dto.CourseDto;
import lombok.Data;

@Data
public class Course {
    private int id;
    private String name;
    private String code;

    private boolean deleted;

    public CourseDto convertToDto() {
        var courseDto = new CourseDto();
        courseDto.setId(id);
        courseDto.setName(name);
        courseDto.setCode(code);
        return courseDto;
    }
}
