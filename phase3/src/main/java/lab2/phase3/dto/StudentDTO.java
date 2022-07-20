package lab2.phase3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String major;
    private List<CourseDTO> coursesTaken;
    private float gpa;
}
