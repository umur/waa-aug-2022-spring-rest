package miu.edu.lab2.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private float gpa;
    private List<Course> coursesTaken;
}
