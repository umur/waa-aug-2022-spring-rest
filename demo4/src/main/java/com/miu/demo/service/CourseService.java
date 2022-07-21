package com.miu.demo.service;

import com.miu.demo.domain.Course;
import com.miu.demo.domain.Student;
import com.miu.demo.dto.CourseDto;

import java.util.List;

public interface CourseService {

    List<CourseDto> findAll();

    CourseDto findById(Long id);

    CourseDto save(CourseDto course);

    CourseDto update(CourseDto course, Long id);

    void remove(Long id);
}