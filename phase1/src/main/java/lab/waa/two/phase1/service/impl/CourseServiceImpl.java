package lab.waa.two.phase1.service.impl;

import lab.waa.two.phase1.entity.Course;
import lab.waa.two.phase1.repository.CourseRepo;
import lab.waa.two.phase1.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
  private final CourseRepo courseRepo;

  @Override
  public void save(Course course) {
    courseRepo.save(course);
  }

  @Override
  public void delete(Long id) {
    courseRepo.delete(id);
  }

  @Override
  public void update(Long id, Course course) {
    courseRepo.update(id, course);
  }

  @Override
  public List<Course> getAll() {
    return courseRepo.getAll();
  }

  @Override
  public Course getById(Long id) {
    return null;
  }
}
