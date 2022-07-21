package com.javokhir.phase1.service.impl;

import com.javokhir.phase1.domain.Course;
import com.javokhir.phase1.repository.CourseRepository;
import com.javokhir.phase1.repository.StudentRepository;
import com.javokhir.phase1.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@AllArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository repository;
    private final StudentRepository studentRepository;

    @Override
    public List<Course> getCourses() {
        return repository.getCourses();
    }

    @Override
    public Course getById(UUID id) {
        return repository.getById(id).orElse(null);
    }

    @Override
    public Course create(Course course) {
        return repository.create(course);
    }

    @Override
    public Course update(Course course) {
        try {
            return repository.update(course);
        }catch (NoSuchElementException exception){
            return null;
        }
    }

    @Override
    public void delete(UUID id) {
        repository.remove(id);
    }

    @Override
    public List<Course> getCoursesByStudentId(UUID id) {
        return studentRepository.findCoursesByStudentId(id);
    }
}
