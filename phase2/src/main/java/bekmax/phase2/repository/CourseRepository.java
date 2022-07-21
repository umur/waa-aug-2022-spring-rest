package bekmax.phase2.repository;

import bekmax.phase2.dto.CourseDto;
import bekmax.phase2.model.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CourseRepository {
    private static final List<Course> courses = new ArrayList<>();
    private long id = 1;

    public List<CourseDto> getCourses() {
        return courses.stream()
                .filter(c -> !c.isDeleted())
                .map(course -> new CourseDto(course.getId(), course.getName(), course.getCode()))
                .collect(Collectors.toList());
    }

    public CourseDto save(CourseDto courseDto) {
        Course course = new Course(id++, courseDto.getName(), courseDto.getCode(), false);
        courses.add(course);
        courseDto.setId(course.getId());
        return courseDto;
    }

    public void delete(long id) {
        var course = courses.stream()
                .filter(c -> c.getId() == id)
                .findFirst();
        course.ifPresent(c -> c.setDeleted(true));
    }

    public void update(long id, CourseDto newCourseDto) {
        var course = courses.stream()
                .filter(c -> c.getId() == id)
                .findFirst();
        if (course.isPresent()) {
            if (newCourseDto.getName() != null && !newCourseDto.getName().isEmpty()) {
                course.get().setName(newCourseDto.getName());
            }
            if (newCourseDto.getCode() != null && !newCourseDto.getCode().isEmpty()) {
                course.get().setCode(newCourseDto.getCode());
            }
        }
    }
}
