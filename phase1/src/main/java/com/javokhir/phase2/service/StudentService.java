package com.javokhir.phase2.service;


import com.javokhir.phase2.dto.StudentDto;

import java.util.List;
import java.util.UUID;

public interface StudentService {

    List<StudentDto> getStudents();

    StudentDto getById(UUID id);

    StudentDto create(StudentDto student);

    StudentDto update(StudentDto student);

    void delete(UUID id);

    List<StudentDto> getStudentsByMajor(String major);
}
