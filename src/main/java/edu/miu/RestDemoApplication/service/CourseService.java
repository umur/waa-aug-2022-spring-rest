package edu.miu.RestDemoApplication.service;

import edu.miu.RestDemoApplication.dto.CourseDTO;

import java.util.List;

public interface CourseService {
    List<CourseDTO> findAll();
    CourseDTO findByID(long id);
    void addCourse(CourseDTO courseDTO);
}
