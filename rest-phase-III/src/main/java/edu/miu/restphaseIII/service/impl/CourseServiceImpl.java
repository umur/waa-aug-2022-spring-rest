package edu.miu.restphaseIII.service.impl;

import edu.miu.restphaseIII.dto.CourseDto;
import edu.miu.restphaseIII.repository.CourseRepo;
import edu.miu.restphaseIII.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;

    @Override
    public void save(CourseDto courseDto) {
        courseRepo.save(courseDto.converToCourse());
    }

    @Override
    public void delete(int id) {
        courseRepo.delete(id);
    }

    @Override
    public CourseDto getById(int id) {
        return courseRepo.getById(id).convertToDto();
    }

    @Override
    public List<CourseDto> getAll() {
        var courses = courseRepo.getAll();
        return courses.stream().map(c -> c.convertToDto()).collect(Collectors.toList());
    }
}
