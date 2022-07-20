package lab2.phase3.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String major;
    private List<Course> coursesTaken;
    private float gpa;
}
