package com.lab2.phase2.service.impl;

import com.lab2.phase2.dto.CourseDto;
import com.lab2.phase2.dto.StudentDto;
import com.lab2.phase2.entity.Course;
import com.lab2.phase2.entity.Student;
import com.lab2.phase2.repository.StudentRepository;
import com.lab2.phase2.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public List<StudentDto> findAll() {
        List<Student> data = studentRepository.findAll();
        return getStudentDtos(data);
    }

    @Override
    public void save(StudentDto student) {
        studentRepository.save(student.toEntity());
    }

    @Override
    public boolean delete(int id) {
        return studentRepository.delete(id);
    }

    @Override
    public StudentDto findById(int id) {
        Student student = studentRepository.findById(id);
        return new StudentDto(student.getId(), student.getFirstName(), student.getLastName(), student.getEmail(), student.getMajor(), student.getCoursesTaken());
    }

    @Override
    public void update(int id, StudentDto student) {
        studentRepository.update(id, student.toEntity());
    }

    @Override
    public List<StudentDto> getStudentsByMajor(String major) {
        List<Student> data = studentRepository.getStudentsByMajor(major);
        return getStudentDtos(data);
    }

    private List<StudentDto> getStudentDtos(List<Student> data) {
        var result = new ArrayList<StudentDto>();
        data.forEach(entity -> {
            var dto = new StudentDto(entity.getId(), entity.getFirstName(), entity.getLastName(), entity.getEmail(), entity.getMajor(), entity.getCoursesTaken());
            result.add(dto);
        });
        return result;
    }

    @Override
    public List<CourseDto> getCoursesByStudentId(int studentId) {
        List<Course> courses = studentRepository.getCoursesByStudentId(studentId);
        var result = new ArrayList<CourseDto>();
        courses.forEach(entity -> {
            var dto = new CourseDto(entity.getId(), entity.getCode(), entity.getName());
            result.add(dto);
        });
        return result;
    }
}
