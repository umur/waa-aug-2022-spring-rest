package com.lab2.phase3.repository;

import com.lab2.phase3.entity.Course;
import com.lab2.phase3.exception.CourseNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {
    private static List<Course> courses = new ArrayList<>();
    private static int id = 1;

    private static int getId() {
        return id;
    }

    private static void setId(int id) {
        CourseRepository.id = id;
    }


    public List<Course> findAll() {
        return courses;
    }

    public void save(Course course) {
        course.setId(id);
        this.setId(id + 1);
        courses.add(course);
    }

    public boolean delete(int id) {
        return courses.removeIf(course -> course.getId() == id);
    }

    public Course findById(int id) {
        Course course = courses.stream().filter(c -> c.getId() == id).findAny().orElse(null);
        if(course==null){
            throw new CourseNotFoundException();
        }
        return course;
    }

    public void update(int id, Course course) {
        Course courseAsked = courses.stream().filter(c -> c.getId() == id).findAny().orElse(null);
        if (courseAsked == null) {
            throw new CourseNotFoundException();
        }
        course.setId(id);
        courses.set(courses.indexOf(courseAsked), course);

    }

}
