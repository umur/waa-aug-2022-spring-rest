package bekmax.phase1.service;

import bekmax.phase1.model.Course;
import bekmax.phase1.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> fetchAll() {
        return courseRepository.getCourses();
    }

    public Course save(Course course) {
        return courseRepository.save(course);
    }

    public void delete(long id) {
        courseRepository.delete(id);
    }

    public void update(long id, Course course) {
        courseRepository.update(id, course);
    }
}
