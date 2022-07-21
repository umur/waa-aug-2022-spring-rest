package edu.miu.restphaseI.repository;

import edu.miu.restphaseI.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CourseRepo {
    private static List<Course> courses = new ArrayList<>();

    static {
        courses = new ArrayList<>();
        Course course = new Course();
        course.setId(1);
        course.setName("Modern Programming Practices");
        course.setCode("CS401");
        courses.add(course);

        course = new Course();
        course.setId(2);
        course.setName("Web Application Programming");
        course.setCode("CS472");
        courses.add(course);

        course = new Course();
        course.setId(3);
        course.setName("Web Application Architecture");
        course.setCode("CS545");
        courses.add(course);
    }

    public void save(Course course) {
        Boolean notExists = courses.stream().noneMatch(c -> c.getId() == course.getId());
        if(notExists) {
            courses.add(course);
        }
    }

    public void delete(int id) {
        courses.stream().filter(c -> c.getId() == id).forEach(c -> courses.remove(c));
    }

    public Course getById(int id) {
        return courses.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
    }

    public List<Course> getAll() {
        return courses.stream().filter(s -> !s.isDeleted()).collect(Collectors.toList());
    }

}
