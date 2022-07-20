package phase1.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import phase1.entity.Course;
import phase1.repository.CourseRepo;
import phase1.service.CourseService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepo courseRepo;

    public List<Course> findAll() {
        return courseRepo.getCourses();
    }

    public Course save(Course c) {
        return courseRepo.save(c);
    }

    public void delete(int courseId) {
        courseRepo.delete(courseId);
    }

    public void update(int courseId, Course c) {
        courseRepo.update(courseId, c);
    }
}
