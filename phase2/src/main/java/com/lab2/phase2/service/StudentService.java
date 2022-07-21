package com.lab2.phase2.service;

import com.lab2.phase2.dto.CourseDto;
import com.lab2.phase2.dto.StudentDto;
import com.lab2.phase2.entity.Course;
import com.lab2.phase2.entity.Student;

import java.util.List;

public interface StudentService {
    List<StudentDto> findAll();

    void save(StudentDto student);

    boolean delete(int id);

    StudentDto findById(int id);

    void update(int id,StudentDto student);

    List<StudentDto> getStudentsByMajor(String major);

    List<CourseDto> getCoursesByStudentId(int studentId);
}
