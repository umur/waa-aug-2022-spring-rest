package david.edu.min.Lab2.service;

import david.edu.min.Lab2.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAll();
    void save(Course c);
    void deleteById(int courseId);
    void update(int courseId,Course c);
    Course getById(int courseId);
}
