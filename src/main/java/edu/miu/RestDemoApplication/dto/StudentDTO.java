package edu.miu.RestDemoApplication.dto;

import edu.miu.RestDemoApplication.entity.Course;
import edu.miu.RestDemoApplication.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private List<Course> coursesTaken;
    private double gpa;

    public static StudentDTO getDTO(Student student) {
        return new StudentDTO(student.getId(), student.getFirstName(),
                student.getLastName(), student.getEmail(),
                student.getMajor(), student.getCoursesTaken(),
                student.getGpa());
    }

    public static Student getStudent(StudentDTO studentDTO) {
        return new Student(studentDTO.getId(), studentDTO.getFirstName(), studentDTO.getLastName(),
                studentDTO.getEmail(), studentDTO.getMajor(),
                studentDTO.getCoursesTaken(), studentDTO.getGpa(), false);
    }
}
