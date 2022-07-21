package com.waa.lab2.service.impl;

import com.waa.lab2.dto.StudentDTO;
import com.waa.lab2.repository.StudentRepo;
import com.waa.lab2.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.waa.lab2.util.Mapper.map;
import static com.waa.lab2.util.Mapper.mapStudentList;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepo repo;

    @Override
    public List<StudentDTO> findAll() {
        return mapStudentList(repo.findAll());
    }
    @Override
    public void save(StudentDTO studentDTO) {
        repo.save(map(studentDTO));
    }

    @Override
    public void update(StudentDTO studentDTO) {
        repo.update(map(studentDTO));
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Optional<StudentDTO> findById(Long id) {
        return repo.findById(id).map(i -> map(i));
    }

    @Override
    public List<StudentDTO> getByMajor(String major) {
        return mapStudentList(repo.getByMajor(major));
    }
}
