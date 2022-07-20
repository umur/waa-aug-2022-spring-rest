package com.miu.demo.service;



import com.miu.demo.dto.CourseDto;
import com.miu.demo.dto.StudentDto;
import com.miu.demo.dto.StudentV2Dto;

import java.util.List;

public interface StudentService {

    List<StudentDto> findAll();

    StudentDto findById(Long id);

    StudentDto save(StudentDto student);

    StudentDto update(StudentDto student, Long id);

    void remove(Long id);

    List<StudentV2Dto> getStudentsByMajor(String major);

    List<CourseDto> getCoursesByStudentId(Long studentId);
}