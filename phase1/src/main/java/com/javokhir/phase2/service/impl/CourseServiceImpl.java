package com.javokhir.phase2.service.impl;

import com.javokhir.phase1.domain.Course;
import com.javokhir.phase2.dto.CourseDto;
import com.javokhir.phase2.repository.CourseRepository;
import com.javokhir.phase2.repository.StudentRepository;
import com.javokhir.phase2.service.CourseService;
import lombok.AllArgsConstructor;
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

    @Override
    public List<CourseDto> getCourses() {
        return repository.getCourses().stream().map(CourseDto::createFromEntity).collect(Collectors.toList());
    }

    @Override
    public CourseDto getById(UUID id) {
        return repository.getById(id)
                .map(CourseDto::createFromEntity)
                .orElse(null);
    }

    @Override
    public CourseDto create(CourseDto course) {
        return CourseDto.createFromEntity(repository.create(Course.builder()
                .name(course.getName())
                .code(course.getCode())
                .build()));
    }

    @Override
    public CourseDto update(CourseDto course) {
        try {
            return CourseDto.createFromEntity(repository.update(Course.builder()
                    .id(course.getId())
                    .name(course.getName())
                    .code(course.getCode())
                    .build()));
        }catch (NoSuchElementException exception){
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
                .stream().map(CourseDto::createFromEntity)
                .collect(Collectors.toList());
    }
}
