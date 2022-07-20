package phase1.entity;

import lombok.Data;

import java.util.List;

@Data
public class Student {
    int id;
    String firstName;
    String lastName;
    String email;
    String major;
    Double gpa;
    List<Course> coursesTaken;

    private boolean deleted;
}
