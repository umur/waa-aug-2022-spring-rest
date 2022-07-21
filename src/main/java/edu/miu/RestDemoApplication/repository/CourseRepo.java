package edu.miu.RestDemoApplication.repository;

import edu.miu.RestDemoApplication.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo {
    private static List<Course> courses = new ArrayList<>();

    public CourseRepo() {
        Course c1 = new Course(1, "WAA", "CS545", false);
        Course c2 = new Course(2, "Algorithms", "CS472", false);
        Course c3 = new Course(3, "WAP", "CS470", false);

        courses.addAll(List.of(c1, c2, c3));
    }

    public List<Course> findAll() {
        return courses;
    }

    public Course findByID(long id) {
        return courses.stream()
                .filter(course -> course.getId()==id)
                .findFirst().orElse(null);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }
}
