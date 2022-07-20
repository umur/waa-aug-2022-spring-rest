package waa.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Student {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private List<Course> coursesTaken;
    private Integer Gpa;
}

