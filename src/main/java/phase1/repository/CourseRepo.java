package phase1.repository;

import org.springframework.stereotype.Repository;
import phase1.entity.Course;

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

    public void delete(int courseId) {
        var foundCourse = courses.stream().filter(s -> s.getId() == courseId).findFirst();
        foundCourse.ifPresent(course -> course.setDeleted(true));
    }

    public void update(int courseId, Course c) {
        var foundCourse = courses.stream().filter(s -> s.getId() == courseId).findFirst();
        if (foundCourse.isPresent()) {
            if (c.getName() != null && !c.getName().isEmpty()) {
                foundCourse.get().setName(c.getName());
            }
            if (c.getCode() != null && !c.getCode().isEmpty()) {
                foundCourse.get().setCode(c.getCode());
            }
        }
    }
}
