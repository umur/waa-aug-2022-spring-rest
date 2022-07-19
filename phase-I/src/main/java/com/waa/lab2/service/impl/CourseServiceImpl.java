package com.waa.lab2.service.impl;

import com.waa.lab2.entity.Course;
import com.waa.lab2.repository.CourseRepo;
import com.waa.lab2.repository.StudentRepo;
import com.waa.lab2.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepo repo;
    private final StudentRepo studentRepo;

    @Override
    public List<Course> findAll() {
        return repo.findAll();
    }

    @Override
    public void save(Course course) {
        repo.save(course);
    }

    @Override
    public void update(Course course) {
        repo.update(course);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Optional<Course> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<Course> getByStudentId(Long studentId) {
        return repo.getCoursesByStudentId(studentId);
    }
}
