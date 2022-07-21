package waa.phase1.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import waa.phase1.entity.Course;
import waa.phase1.repository.CourseRepo;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepo courseRepo;

    @Override
    public List<Course> findAll() {
        return courseRepo.findAll();
    }

    @Override
    public void save(Course course) {
        courseRepo.save(course);
    }

    @Override
    public void deleteById(int id) {
        courseRepo.deleteById(id);
    }

    @Override
    public void update(int id, Course course) {
        courseRepo.update(id, course);
    }
}
