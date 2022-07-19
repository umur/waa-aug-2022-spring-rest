package com.waa.lab2.repository;

import com.waa.lab2.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CourseRepo {
    static List<Course> courses = new ArrayList<>();

    {
        // Init sample data
        courses.add(new Course(1L, "course1", "c1", false));
        courses.add(new Course(2L, "course2", "c2", false));
    }

    public List<Course> findAll() {
        return courses
                .stream()
                .filter(c -> !c.isDeleted())
                .collect(Collectors.toList());
    }

    public void save(Course course) {
        courses.add(course);
    }

    public Optional<Course> findById(Long id) {
        return courses
                .stream()
                .filter(c -> !c.isDeleted())
                .filter(c -> c.getId().equals(id))
                .findAny();
    }

    public void deleteById(Long id) {
        courses
                .stream()
                .filter(c -> c.getId().equals(id))
                .forEach(c -> c.setDeleted(true));
    }

    public void update(Course course) {
        courses
                .stream()
                .filter(c -> !c.isDeleted())
                .filter(c -> c.getId().equals(course.getId()))
                .forEach(c -> {
                    c.setName(course.getName());
                    c.setCode(course.getCode());
                });
    }

    public List<Course> getCoursesByStudentId(Long studentId) {
        return StudentRepo.students
                    .stream()
                    .filter(c -> !c.isDeleted())
                    .filter(c -> c.getId().equals(studentId))
                    .flatMap( c -> c.getCoursesTaken().stream())
                    .collect(Collectors.toList());
    }

}

