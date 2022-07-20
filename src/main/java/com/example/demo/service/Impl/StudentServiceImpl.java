package com.example.demo.service.Impl;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepo;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;

    @Override
    public List<Student> findAll() {
        return studentRepo.getAll();
    }

    @Override
    public Student findById(int id) {
       return studentRepo.getById(id);
    }

    @Override
    public void deleteStudent(int id) {
        studentRepo.deleteStudent(id);
    }

    @Override
    public void addStudent(Student std) {
        studentRepo.save(std);
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepo.getAll().stream().filter(s->s.getMajor()==major).collect(Collectors.toList());
    }

    @Override
    public List<Course> getCoursesByStudentId(Long studentId) {
        return (List<Course>) studentRepo.getAll().stream().filter(s->s.getId() == studentId).map(s->s.getCoursesTaken());//.collect(Collectors.toList());
    }
}
