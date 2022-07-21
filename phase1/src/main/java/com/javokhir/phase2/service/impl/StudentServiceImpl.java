package com.javokhir.phase2.service.impl;

import com.javokhir.phase1.domain.Course;
import com.javokhir.phase1.domain.Student;
import com.javokhir.phase2.dto.StudentDto;
import com.javokhir.phase2.repository.StudentRepository;
import com.javokhir.phase2.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    @Override
    public List<StudentDto> getStudents() {
        return repository.getAll()
                .stream()
                .map(StudentDto::createFromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto getById(UUID id) {
        return repository.getById(id)
                .map(StudentDto::createFromEntity)
                .orElse(null);
    }

    @Override
    public StudentDto create(StudentDto student) {
        return StudentDto.createFromEntity(repository.create(Student.builder()
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .email(student.getEmail())
                .major(student.getMajor())
                .gpa(student.getGpa())
                .coursesTaken(student.getCoursesTaken().stream().map(t -> Course.builder()
                        .id(t.getId())
                        .name(t.getName())
                        .code(t.getCode())
                        .build())
                        .collect(Collectors.toList()))
                .build()));
    }

    @Override
    public StudentDto update(StudentDto student) {
        try {
            return StudentDto.createFromEntity(repository.update(Student.builder()
                    .id(student.getId())
                    .firstName(student.getFirstName())
                    .lastName(student.getLastName())
                    .email(student.getEmail())
                    .major(student.getMajor())
                    .gpa(student.getGpa())
                    .coursesTaken(student.getCoursesTaken().stream().map(t -> Course.builder()
                                    .id(t.getId())
                                    .name(t.getName())
                                    .code(t.getCode())
                                    .build())
                            .collect(Collectors.toList()))
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
    public List<StudentDto> getStudentsByMajor(String major) {
        return repository.findStudentsByMajor(major)
                .stream().map(StudentDto::createFromEntity)
                .collect(Collectors.toList());
    }
}
