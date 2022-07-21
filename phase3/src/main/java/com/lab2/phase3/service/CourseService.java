package com.lab2.phase3.service;

import com.lab2.phase3.dto.CourseDto;

import java.util.List;

public interface CourseService {
    List<CourseDto> findAll();
    void save(CourseDto course);
    boolean delete(int id);
    CourseDto findById(int id);
    void update(int id,CourseDto course);

}
