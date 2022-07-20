package lab2.phase1.service;

import lab2.phase1.domain.Course;
import lab2.phase1.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService implements ICourseService {
    private final CourseRepository repo;

    @Autowired
    public CourseService(CourseRepository repo) {
        this.repo = repo;
    }

    @Override
    public Boolean create(Course course) {
        return repo.create(course);
    }

    @Override
    public List<Course> read() {
        return repo.read();
    }

    @Override
    public Boolean update(int id, Course course) {
        return repo.update(id, course);
    }

    @Override
    public Boolean delete(int id) {
        return repo.delete(id);
    }
}
