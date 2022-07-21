package com.lab2.phase3.service.impl;

import com.lab2.phase3.dto.CourseDto;
import com.lab2.phase3.dto.StudentDto;
import com.lab2.phase3.entity.Course;
import com.lab2.phase3.entity.Student;
import com.lab2.phase3.repository.StudentRepository;
import com.lab2.phase3.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDto> findAll() {
        List<Student> data = studentRepository.findAll();
        return getStudentDtos(data);
    }

    @Override
    public void save(StudentDto student) {
        studentRepository.save(modelMapper.map(student, Student.class));
    }

    @Override
    public boolean delete(int id) {
        return studentRepository.delete(id);
    }

    @Override
    public StudentDto findById(int id) {
        Student student = studentRepository.findById(id);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public void update(int id, StudentDto student) {
        studentRepository.update(id, modelMapper.map(student, Student.class));
    }

    @Override
    public List<StudentDto> getStudentsByMajor(String major) {
        List<Student> data = studentRepository.getStudentsByMajor(major);
        return getStudentDtos(data);
    }

    private List<StudentDto> getStudentDtos(List<Student> data) {
        var result = new ArrayList<StudentDto>();
        data.forEach(entity -> {
            var dto = modelMapper.map(entity, StudentDto.class);
            result.add(dto);
        });
        return result;
    }

    @Override
    public List<CourseDto> getCoursesByStudentId(int studentId) {
        List<Course> courses = studentRepository.getCoursesByStudentId(studentId);
        var result = new ArrayList<CourseDto>();
        courses.forEach(entity -> {
            var dto = modelMapper.map(entity, CourseDto.class);
            result.add(dto);
        });
        return result;
    }
}
