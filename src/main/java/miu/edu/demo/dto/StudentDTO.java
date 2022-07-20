package miu.edu.demo.dto;

import lombok.Data;
import miu.edu.demo.entity.Course;

import java.util.List;

@Data
public class StudentDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private List<CourseDTO> coursesTaken;
    private String gpa;
}
