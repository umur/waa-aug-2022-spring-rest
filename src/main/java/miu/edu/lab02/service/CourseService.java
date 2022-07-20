package miu.edu.lab02.service;

import miu.edu.lab02.dto.CourseDTO;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<CourseDTO> findAll();

    CourseDTO save(CourseDTO course);

    CourseDTO update(Integer id, CourseDTO course);

    Optional<CourseDTO> findOne(Integer id);

    void delete(Integer id);
}
