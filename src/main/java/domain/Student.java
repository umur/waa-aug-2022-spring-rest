package domain;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private double gpa;

    private List<Course> coursesTaken;

    private boolean deleted;

    public void addCourse(Course course){
        this.coursesTaken.add(course);
    }

}
