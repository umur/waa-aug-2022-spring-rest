package bekmax.phase3.repository;

import bekmax.phase3.dto.CourseDto;
import bekmax.phase3.model.Course;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CourseRepository {
    private static final List<Course> courses = new ArrayList<>();
    private long id = 1;
    private final ModelMapper modelMapper;

    public List<CourseDto> getCourses() {
        return courses.stream()
                .filter(course -> !course.isDeleted())
                .map(course -> modelMapper.map(course, CourseDto.class))
                .collect(Collectors.toList());
    }

    public CourseDto save(CourseDto cd) {
        Course course = modelMapper.map(cd, Course.class);
        course.setId(id++);
        cd.setId(course.getId());
        courses.add(course);
        return cd;
    }

    public void delete(long id) {
        var course = courses.stream()
                .filter(s -> s.getId() == id)
                .findFirst();
        course.ifPresent(c -> c.setDeleted(true));
    }

    public void update(long id, CourseDto cd) {
        var course = courses.stream()
                .filter(c -> c.getId() == id)
                .findFirst();
        if (course.isPresent()) {
            if (cd.getName() != null && !cd.getName().isEmpty()) {
                course.get().setName(cd.getName());
            }
            if (cd.getCode() != null && !cd.getCode().isEmpty()) {
                course.get().setCode(cd.getCode());
            }
        }
    }
}
