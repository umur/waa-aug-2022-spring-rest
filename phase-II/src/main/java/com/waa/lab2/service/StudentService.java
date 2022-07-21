package com.waa.lab2.service;

import com.waa.lab2.dto.StudentDTO;
import com.waa.lab2.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<StudentDTO> findAll();
    void save(StudentDTO studentDTO);
    void update(StudentDTO studentDTO);
    void deleteById(Long id);
    Optional<StudentDTO> findById(Long id);

    List<StudentDTO> getByMajor(String major);
}
