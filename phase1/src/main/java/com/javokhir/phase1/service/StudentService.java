package com.javokhir.phase1.service;

import com.javokhir.phase1.domain.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

public interface StudentService {

    List<Student> getStudents();

    Student getById(UUID id);

    Student create(Student student);

    Student update(Student student);

    void delete(UUID id);

    List<Student> getStudentsByMajor(String major);
}
