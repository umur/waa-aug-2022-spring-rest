package com.waa.lab2.service.impl;

import com.waa.lab2.entity.Student;
import com.waa.lab2.repository.StudentRepo;
import com.waa.lab2.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepo repo;

    @Override
    public List<Student> findAll() {
        return repo.findAll();
    }

    @Override
    public void save(Student student) {
        repo.save(student);
    }

    @Override
    public void update(Student student) {
        repo.update(student);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Optional<Student> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<Student> getByMajor(String major) {
        return repo.getByMajor(major);
    }
}
