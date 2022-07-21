package com.javokhir.phase3.service.impl;

import com.javokhir.phase1.domain.Course;
import com.javokhir.phase3.dto.CourseDto;
import com.javokhir.phase3.repository.CourseRepository;
import com.javokhir.phase3.repository.StudentRepository;
import com.javokhir.phase3.service.CourseService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository repository;
    private final StudentRepository studentRepository;

    private final ModelMapper mapper = new ModelMapper();

    @Override
    public List<CourseDto> getCourses() {
        return repository.getCourses().stream().map(t -> mapper.map(t, CourseDto.class)).collect(Collectors.toList());
    }

    @Override
    public CourseDto getById(UUID id) {
        return repository.getById(id)
                .map(t -> mapper.map(t, CourseDto.class))
                .orElse(null);
    }

    @Override
    public CourseDto create(CourseDto course) {
        return mapper.map(repository.create(mapper.map(course, Course.class)), CourseDto.class);
    }

    @Override
    public CourseDto update(CourseDto course) {
        try {
            return mapper.map(repository.update(mapper.map(course, Course.class)), CourseDto.class);
        } catch (NoSuchElementException exception){
            return null;
        }
    }

    @Override
    public void delete(UUID id) {
        repository.remove(id);
    }

    @Override
    public List<CourseDto> getCoursesByStudentId(UUID id) {
        return studentRepository.findCoursesByStudentId(id)
                .stream().map(t -> mapper.map(t, CourseDto.class))
                .collect(Collectors.toList());
    }
}
