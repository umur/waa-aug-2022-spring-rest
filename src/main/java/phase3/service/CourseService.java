package phase3.service;

import phase3.dto.CourseDto;

import java.util.List;

public interface CourseService {
    List<CourseDto> findAll();
    CourseDto save(CourseDto c);
    void delete(int courseId);
    void update(int courseId, CourseDto c);
}
