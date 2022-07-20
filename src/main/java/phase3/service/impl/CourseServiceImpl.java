package phase3.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import phase3.dto.CourseDto;
import phase3.repository.CourseRepo;
import phase3.service.CourseService;

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
