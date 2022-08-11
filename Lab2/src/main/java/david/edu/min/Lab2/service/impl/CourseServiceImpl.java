package david.edu.min.Lab2.service.impl;


import david.edu.min.Lab2.entity.Course;
import david.edu.min.Lab2.repository.CourseRepo;
import david.edu.min.Lab2.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;

    @Override
    public List<Course> getAll() {
        var entityList = courseRepo.getAll();
        return entityList;
    }

    @Override
    public void save(Course c) {
        courseRepo.save(c);
    }

    @Override
    public void deleteById(int courseId) {
        courseRepo.deleteById(courseId);
    }

    @Override
    public void update(int courseId, Course c) {
        courseRepo.update(courseId,c);
    }

    @Override
    public Course getById(int courseId) {
        var entity= courseRepo.getById(courseId);
        return entity;
    }
}

