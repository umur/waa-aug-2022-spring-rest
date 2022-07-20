package miu.edu.lab2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class StudentDTO {
    private static int idCounter = 1;

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private List<CourseDTO> coursesTaken;
    private double gpa;
}