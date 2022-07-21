package com.waa.lab2.util;

import com.waa.lab2.dto.CourseDTO;
import com.waa.lab2.dto.StudentDTO;
import com.waa.lab2.entity.Course;
import com.waa.lab2.entity.Student;

import java.util.List;
import java.util.stream.Collectors;

public class Mapper {
    public static CourseDTO map(Course course){
        return new CourseDTO(course.getId(), course.getName(), course.getCode());
    }

    public static Course map(CourseDTO courseDTO){
        return new Course(courseDTO.getId(), courseDTO.getName(), courseDTO.getCode(), false);
    }

    public static List<CourseDTO> mapCourseList(List<Course> courses){
        return courses.stream().map(c -> map(c)).collect(Collectors.toList());
    }

    public static List<Course> mapCourseDTOList(List<CourseDTO> courseDTOS){
        return courseDTOS.stream().map(c -> map(c)).collect(Collectors.toList());
    }

    public static StudentDTO map(Student student){
        return new StudentDTO(student.getId(), student.getFirstName(),
                student.getLastName(), student.getEmail(), student.getMajor(),
                student.getGpa(), mapCourseList(student.getCoursesTaken()));
    }

    public static Student map(StudentDTO studentDTO){
        return new Student(studentDTO.getId(), studentDTO.getFirstName(),
                studentDTO.getLastName(), studentDTO.getEmail(),
                studentDTO.getMajor(), studentDTO.getGpa(),
                mapCourseDTOList(studentDTO.getCoursesTaken()), false);
    }

    public static List<StudentDTO> mapStudentList(List<Student> students){
        return students.stream().map(i -> map(i)).collect(Collectors.toList());
    }



}
