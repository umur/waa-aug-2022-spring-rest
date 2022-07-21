package com.waa.lab2.service.impl;

import com.waa.lab2.dto.CourseDTO;
import com.waa.lab2.repository.CourseRepo;
import com.waa.lab2.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.waa.lab2.util.Mapper.*;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepo repo;

    @Override
    public List<CourseDTO> findAll() {
        return mapCourseList(repo.findAll());
    }

    @Override
    public void save(CourseDTO courseDTO) {
        repo.save(map(courseDTO));
    }

    @Override
    public void update(CourseDTO courseDTO) {
        repo.update(map(courseDTO));
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Optional<CourseDTO> findById(Long id) {
        return repo.findById(id).map(c -> map(c));
    }

    @Override
    public List<CourseDTO> getByStudentId(Long studentId) {
        return mapCourseList(repo.getCoursesByStudentId(studentId));
    }
}
