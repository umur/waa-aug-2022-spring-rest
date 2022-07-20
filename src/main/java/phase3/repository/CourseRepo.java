package phase3.repository;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;
import phase3.dto.CourseDto;
import phase3.entity.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CourseRepo {
    private static final List<Course> courses = new ArrayList<>();
    private int idCounter = 1;
    private final ModelMapper modelMapper;

    public List<CourseDto> getCourses() {
        return courses
                .stream()
                .filter(c -> !c.isDeleted())
                .map(c -> modelMapper.map(c, CourseDto.class))
                .collect(Collectors.toList());
    }

    public CourseDto save(CourseDto cd) {
        Course c = modelMapper.map(cd, Course.class);
        c.setId(idCounter);
        cd.setId(idCounter);
        idCounter++;
        courses.add(c);
        return cd;
    }

    public void delete(int courseId) {
        var foundCourse = courses.stream().filter(s -> s.getId() == courseId).findFirst();
        foundCourse.ifPresent(course -> course.setDeleted(true));
    }

    public void update(int courseId, CourseDto c) {
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
