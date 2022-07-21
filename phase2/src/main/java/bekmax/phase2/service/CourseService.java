package bekmax.phase2.service;

import bekmax.phase2.dto.CourseDto;
import bekmax.phase2.repository.CourseRepository;
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

    public List<CourseDto> fetchAll() {
        return courseRepository.getCourses();
    }

    public CourseDto save(CourseDto courseDto) {
        return courseRepository.save(courseDto);
    }

    public void delete(long id) {
        courseRepository.delete(id);
    }

    public void update(long id, CourseDto courseDto) {
        courseRepository.update(id, courseDto);
    }
}
