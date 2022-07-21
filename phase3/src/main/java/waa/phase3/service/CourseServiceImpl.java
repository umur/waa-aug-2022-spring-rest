package waa.phase3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import waa.phase3.dto.CourseDto;
import waa.phase3.entity.Course;
import waa.phase3.repository.CourseRepo;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepo courseRepo;

    @Override
    public List<CourseDto> findAll() {
        var courses = courseRepo.findAll();
        var result = new ArrayList<CourseDto>();
        courses.forEach(course -> {
            result.add(new CourseDto(course.getId(), course.getName(), course.getCode()));
        });
        return result;
    }

    @Override
    public void save(CourseDto course) {
        courseRepo.save(new Course(course.getId(), course.getName(), course.getCode(), false));
    }

    @Override
    public void deleteById(int id) {
        courseRepo.deleteById(id);
    }

    @Override
    public void update(int id, CourseDto course) {
        courseRepo.update(id, new Course(course.getId(), course.getName(), course.getCode(), false));
    }

    @Override
    public CourseDto findById(int id) {
        var course = courseRepo.findById(id);
        return new CourseDto(course.getId(), course.getName(), course.getCode());
    }
}
