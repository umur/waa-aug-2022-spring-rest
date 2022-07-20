package miu.edu.demo.service;

import miu.edu.demo.dto.CourseDTO;

import java.util.List;

public interface CourseService {

    List<CourseDTO> findAll();

    CourseDTO findById(int courseId);

    void save(CourseDTO courseDTO);
}
