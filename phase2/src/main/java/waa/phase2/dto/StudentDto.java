package waa.phase2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import waa.phase2.entity.Course;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private float gpa;
    private List<Course> coursesTaken;
}
