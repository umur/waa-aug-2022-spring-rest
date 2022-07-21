package com.waa.lab2.util;

import com.waa.lab2.dto.CourseDTO;
import com.waa.lab2.dto.StudentDTO;
import com.waa.lab2.entity.Course;
import com.waa.lab2.entity.Student;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

public class Mapper {

    private static final ModelMapper modelMapper = new ModelMapper();;

    public static CourseDTO map(Course course){
        return modelMapper.map(course, CourseDTO.class);
    }

    public static Course map(CourseDTO courseDTO){
        return modelMapper.map(courseDTO, Course.class);
    }

    public static List<CourseDTO> mapCourseList(List<Course> courses){
        return courses.stream().map(c -> map(c)).collect(Collectors.toList());
    }

    public static StudentDTO map(Student student){
        return modelMapper.map(student, StudentDTO.class);
    }

    public static Student map(StudentDTO studentDTO){
        return modelMapper.map(studentDTO, Student.class);
    }

    public static List<StudentDTO> mapStudentList(List<Student> students){
        return students.stream().map(i -> map(i)).collect(Collectors.toList());
    }



}
