package phase2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import phase2.dto.CourseDto;
import phase2.entity.Course;
import phase2.repository.CourseRepo;
import phase2.service.CourseService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepo courseRepo;

    public List<CourseDto> findAll() {
        return courseRepo.getCourses();
    }

    public CourseDto save(CourseDto c) {
        return courseRepo.save(c);
    }

    public void delete(int courseId) {
        courseRepo.delete(courseId);
    }

    public void update(int courseId, CourseDto c) {
        courseRepo.update(courseId, c);
    }
}
