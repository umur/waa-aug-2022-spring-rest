package com.miu.lab.service.impl;

import com.miu.lab.dto.CourseDto;
import com.miu.lab.dto.StudentDto;
import com.miu.lab.entity.Student;
import com.miu.lab.repository.CourseRepo;
import com.miu.lab.repository.StudentRepo;
import com.miu.lab.service.IStudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService implements IStudentService {
    @Autowired
    ModelMapper mapper;
    @Autowired
    StudentRepo studentRepo;
    @Autowired
    CourseRepo courseRepo;


    @Override
    public List<StudentDto> findAll() {
        return studentRepo.findAll()
                .stream()
                .map(s -> mapper.map(s, StudentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto getById(int studentId) {
        return mapper.map(studentRepo.getById(studentId), StudentDto.class);
    }

    @Override
    public List<CourseDto> getCoursesByStudentId(int studentId) {
        Student student= studentRepo.getById(studentId);
        if(student==null)return null;

        return student.getCoursesTaken().stream().map(c -> mapper.map(c,CourseDto.class)).collect(Collectors.toList());
    }

    @Override
    public StudentDto getStudentsByMajor(String major) {
        Student st=studentRepo.getStudentsByMajor(major);
        if(st==null)return null;
        return  mapper.map(st, StudentDto.class);
    }

    @Override
    public void save(StudentDto studentDto) {
        studentRepo.save(mapper.map(studentDto, Student.class));
    }

    @Override
    public void delete(int studentId) {
        studentRepo.delete(studentId);
    }

    @Override
    public StudentDto update(StudentDto studentDto) {
        return mapper.map(studentRepo.update(mapper.map(studentDto, Student.class)), StudentDto.class);
    }
}
