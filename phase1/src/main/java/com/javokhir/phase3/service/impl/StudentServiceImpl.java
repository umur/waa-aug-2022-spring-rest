package com.javokhir.phase3.service.impl;

import com.javokhir.phase1.domain.Student;
import com.javokhir.phase3.dto.StudentDto;
import com.javokhir.phase3.repository.StudentRepository;
import com.javokhir.phase3.service.StudentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    private final ModelMapper mapper = new ModelMapper();

    @Override
    public List<StudentDto> getStudents() {
        return repository.getAll()
                .stream()
                .map(t -> mapper.map(t, StudentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto getById(UUID id) {
        return repository.getById(id)
                .map(t -> mapper.map(t, StudentDto.class))
                .orElse(null);
    }

    @Override
    public StudentDto create(StudentDto student) {
        return mapper.map(repository.create(mapper.map(student, Student.class)), StudentDto.class);
    }

    @Override
    public StudentDto update(StudentDto student) {
        try {
            return mapper.map(repository.update(mapper.map(student, Student.class)), StudentDto.class);
        }catch (NoSuchElementException exception){
            return null;
        }
    }

    @Override
    public void delete(UUID id) {
        repository.remove(id);
    }

    @Override
    public List<StudentDto> getStudentsByMajor(String major) {
        return repository.findStudentsByMajor(major)
                .stream().map(t -> mapper.map(t, StudentDto.class))
                .collect(Collectors.toList());
    }
}
