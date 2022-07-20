package lab2.phase2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class StudentDTO {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String major;
    private List<CourseDTO> coursesTaken;
    private float gpa;
}
