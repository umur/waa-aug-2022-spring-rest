package waa.phase2.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import waa.phase2.dto.CourseDto;
import waa.phase2.entity.Course;
import waa.phase2.repository.CourseRepo;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepo courseRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<CourseDto> findAll() {
        var courses = courseRepo.findAll();
        var result = new ArrayList<CourseDto>();
        courses.forEach(course -> {
            result.add(modelMapper.map(course, CourseDto.class));
        });
        return result;
    }

    @Override
    public void save(CourseDto course) {
        courseRepo.save(modelMapper.map(course, Course.class));
    }

    @Override
    public void deleteById(int id) {
        courseRepo.deleteById(id);
    }

    @Override
    public void update(int id, CourseDto course) {
        courseRepo.update(id, modelMapper.map(course, Course.class));
    }
}
