package com.miu.lab.service;

import com.miu.lab.dto.CourseDto;
import com.miu.lab.dto.StudentDto;

import java.util.List;

public interface IStudentService {
    List<StudentDto> findAll();

    StudentDto getById(int studentId);
    List<CourseDto> getCoursesByStudentId(int studentId);
    StudentDto getStudentsByMajor(String major);
    void save(StudentDto studentDto);

    void delete(int studentId);

    StudentDto update(StudentDto studentDto);

}
