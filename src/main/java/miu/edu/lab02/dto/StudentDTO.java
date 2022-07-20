package miu.edu.lab02.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Setter
@Getter
public class StudentDTO {
    private Integer id;
    String firstName;
    String lastName;
    String email;
    String major;
    List<CourseDTO> coursesTaken;
    Double gpa;
}
