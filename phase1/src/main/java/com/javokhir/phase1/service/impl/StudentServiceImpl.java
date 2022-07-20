package com.javokhir.phase1.service.impl;

import com.javokhir.phase1.domain.Student;
import com.javokhir.phase1.repository.StudentRepository;
import com.javokhir.phase1.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    @Override
    public List<Student> getStudents() {
        return repository.getAll();
    }

    @Override
    public Student getById(UUID id) {
        return repository.getById(id).orElse(null);
    }

    @Override
    public Student create(Student student) {
        return repository.create(student);
    }

    @Override
    public Student update(Student student) {
        try {
            return repository.update(student);
        }catch (NoSuchElementException exception){
            return null;
        }
    }

    @Override
    public void delete(UUID id) {
        repository.remove(id);
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return repository.findStudentsByMajor(major);
    }
}
