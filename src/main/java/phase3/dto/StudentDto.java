package phase3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import phase3.entity.Course;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    int id;
    String firstName;
    String lastName;
    String email;
    String major;
    Double gpa;
    List<Course> coursesTaken;
}
