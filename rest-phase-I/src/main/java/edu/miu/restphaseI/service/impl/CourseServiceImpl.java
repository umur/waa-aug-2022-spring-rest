package edu.miu.restphaseI.service.impl;

import edu.miu.restphaseI.entity.Course;
import edu.miu.restphaseI.repository.CourseRepo;
import edu.miu.restphaseI.service.CourseService;
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
    public void delete(int id) {
        courseRepo.delete(id);
    }

    @Override
    public Course getById(int id) {
        return courseRepo.getById(id);
    }

    @Override
    public List<Course> getAll() {
        return courseRepo.getAll();
    }
}
