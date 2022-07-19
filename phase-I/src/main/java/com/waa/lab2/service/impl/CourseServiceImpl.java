package com.waa.lab2.service.impl;

import com.waa.lab2.entity.Course;
import com.waa.lab2.repository.CourseRepo;
import com.waa.lab2.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepo repo;

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
    public void deleteById(long id) {
        repo.deleteById(id);
    }

    @Override
    public Optional<Course> findById(long id) {
        return repo.findById(id);
    }
}
