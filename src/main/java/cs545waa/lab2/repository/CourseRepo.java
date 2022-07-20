package cs545waa.lab2.repository;

import cs545waa.lab2.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CourseRepo {
    private static final List<Course> courses = new ArrayList<>();
    private int idCounter = 1;

    public List<Course> getCourses() {
        return courses
                .stream()
                .filter(c -> !c.isDeleted())
                .collect(Collectors.toList());
    }

    public Course save(Course c) {
        c.setId(idCounter);
        idCounter++;
        courses.add(c);
        return c;
    }
}
