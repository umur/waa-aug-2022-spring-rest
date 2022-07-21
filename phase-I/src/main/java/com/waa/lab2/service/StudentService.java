package com.waa.lab2.service;

import com.waa.lab2.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> findAll();
    void save(Student student);
    void update(Student student);
    void deleteById(Long id);
    Optional<Student> findById(Long id);

    List<Student> getByMajor(String major);
}
