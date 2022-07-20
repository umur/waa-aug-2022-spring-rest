package com.miu.lab.service;

import com.miu.lab.dto.CourseDto;


import java.util.List;

public interface ICourseService {
    List<CourseDto> findAll();

    void save(CourseDto courseDto);

    void delete(int courseId);

    CourseDto update(CourseDto courseDto);
}
