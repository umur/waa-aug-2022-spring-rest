package phase1.service;

import phase1.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> findAll();
    Course save(Course c);
    void delete(int courseId);
    void update(int courseId, Course c);
}
