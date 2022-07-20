package miu.edu.lab2.dto;

import lombok.Data;
import miu.edu.lab2.entity.Course;
import miu.edu.lab2.entity.Student;

import java.util.ArrayList;
import java.util.List;

@Data
public class StudentDTO {
    private static int idCounter = 1;

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private List<CourseDTO> coursesTaken;
    private double gpa;


    public Student toStudent() {
        List<Course> courseList = new ArrayList<>();
        for(CourseDTO courseDTO: coursesTaken) {
            Course newCourse = new Course(courseDTO.getId(), courseDTO.getName(), courseDTO.getCode());
            courseList.add(newCourse);
        }

        if(id == 0)
            id = idCounter++;

        return new Student(id, firstName, lastName, email, major, courseList, gpa);
    }
}