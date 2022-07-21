package bekmax.phase1.model;

import lombok.Data;

import java.util.List;

@Data
public class Student {
    long id;
    String firstName;
    String lastName;
    String email;
    String major;
    Double gpa;
    List<Course> coursesTaken;
    boolean isDeleted;
}
