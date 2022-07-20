package lab2.phase3.repository;

import lab2.phase3.domain.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepository {
    private List<Course> courses = new ArrayList<>();
    private static int idCounter = 1;

    public Boolean create(Course course) {
        course.setId(idCounter++);
        courses.add(course);
        return true;
    }

    public List<Course> read() {
        return courses;
    }

    public Boolean update(int id, Course course) {
        Optional<Course> data = courses.stream().filter(e -> e.getId() == id).findFirst();
        if (data.isPresent()) {
            courses.set(courses.indexOf(data.get()), course);
            return true;
        }
        return false;
    }

    public Boolean delete(int id) {
        Optional<Course> data = courses.stream().filter(e -> e.getId() == id).findFirst();
        if (data.isPresent()) {
            courses.remove(data.get());
            return true;
        }
        return false;
    }
}
