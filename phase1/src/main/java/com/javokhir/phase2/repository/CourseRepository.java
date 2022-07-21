package com.javokhir.phase2.repository;

import com.javokhir.phase1.domain.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CourseRepository {

    private static final List<Course> courses = new ArrayList<>();

    public List<Course> getCourses(){
        return courses;
    }

    public Optional<Course> getById(UUID id){
        return courses.stream().filter(t -> t.getId().equals(id)).findAny();
    }

    public Course create(Course course){
        course.setId(UUID.randomUUID());
        courses.add(course);
        return course;
    }

    public Course update(Course course){
        Course dbCourse = courses.stream().filter(t-> t.getId().equals(course.getId())).findAny().orElseThrow();

        dbCourse.setName(course.getName());
        dbCourse.setCode(course.getCode());

        return dbCourse;
    }

    public void remove(UUID id){
        courses.stream().filter(t -> t.getId().equals(id)).findAny().ifPresent(courses::remove);
    }
}
