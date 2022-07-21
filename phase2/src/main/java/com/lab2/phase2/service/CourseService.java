package com.lab2.phase2.service;

import com.lab2.phase2.dto.CourseDto;
import com.lab2.phase2.entity.Course;

import java.util.List;

public interface CourseService {
    List<CourseDto> findAll();
    void save(CourseDto course);
    boolean delete(int id);
    CourseDto findById(int id);
    void update(int id,CourseDto course);

}
