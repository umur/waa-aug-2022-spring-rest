package bekmax.phase1.repository;

import bekmax.phase1.model.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CourseRepository {
    private static final List<Course> courses = new ArrayList<>();
    private long id = 1;

    public List<Course> getCourses() {
        return courses.stream()
                .filter(c -> !c.isDeleted())
                .collect(Collectors.toList());
    }

    public Course save(Course course) {
        course.setId(id++);
        courses.add(course);
        return course;
    }

    public void delete(long id) {
        var course = courses.stream()
                .filter(c -> c.getId() == id)
                .findFirst();
        course.ifPresent(c -> c.setDeleted(true));
    }

    public void update(long id, Course newCourse) {
        var course = courses.stream()
                .filter(c -> c.getId() == id)
                .findFirst();
        if (course.isPresent()) {
            if (newCourse.getName() != null && !newCourse.getName().isEmpty()) {
                course.get().setName(newCourse.getName());
            }
            if (newCourse.getCode() != null && !newCourse.getCode().isEmpty()) {
                course.get().setCode(newCourse.getCode());
            }
        }
    }
}
