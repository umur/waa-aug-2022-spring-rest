package phase2.service;

import phase2.dto.CourseDto;
import phase2.entity.Course;

import java.util.List;

public interface CourseService {
    List<CourseDto> findAll();
    CourseDto save(CourseDto c);
    void delete(int courseId);
    void update(int courseId, CourseDto c);
}
