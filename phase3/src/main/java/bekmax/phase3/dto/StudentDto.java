package bekmax.phase3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    long id;
    String firstName;
    String lastName;
    String email;
    String major;
    Double gpa;
    List<CourseDto> coursesTaken;
}
