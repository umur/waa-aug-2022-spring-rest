package waa.phase3.service;

import waa.phase3.dto.CourseDto;
import waa.phase3.entity.Student;

import java.util.List;

public interface CourseService {
    List<CourseDto> findAll();

    void save(CourseDto course);

    void deleteById(int id);

    void update(int id, CourseDto course);

    CourseDto findById(int id);
}
