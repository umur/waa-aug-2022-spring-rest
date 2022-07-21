package com.waa.lab2.service;

import com.waa.lab2.dto.CourseDTO;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<CourseDTO> findAll();
    void save(CourseDTO courseDTO);
    void update(CourseDTO courseDTO);
    void deleteById(Long id);
    Optional<CourseDTO> findById(Long id);

    List<CourseDTO> getByStudentId(Long studentId);
}
