package service;

import domain.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    List<Course> findAll();

    void create(Course course);

    void delete(int id);

    void update(Course course, int id);
}
