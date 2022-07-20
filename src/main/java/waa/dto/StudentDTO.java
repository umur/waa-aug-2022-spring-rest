package waa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private List<CourseDTO> coursesTaken;
    private Integer Gpa;
}
