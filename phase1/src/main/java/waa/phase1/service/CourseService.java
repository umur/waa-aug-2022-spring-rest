package waa.phase1.service;

import waa.phase1.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> findAll();

    void save(Course course);

    void deleteById(int id);

    void update(int id, Course course);
}
