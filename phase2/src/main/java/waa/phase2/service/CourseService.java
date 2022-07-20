package waa.phase2.service;

import waa.phase2.dto.CourseDto;

import java.util.List;

public interface CourseService {
    List<CourseDto> findAll();

    void save(CourseDto course);

    void deleteById(int id);

    void update(int id, CourseDto course);
}
