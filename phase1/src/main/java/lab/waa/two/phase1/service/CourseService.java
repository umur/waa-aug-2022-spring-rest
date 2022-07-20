package lab.waa.two.phase1.service;

import lab.waa.two.phase1.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
  void save(Course course);

  void delete(Long id);

  void update(Long id, Course course);

  List<Course> getAll();

  Course getById(Long id);
}
