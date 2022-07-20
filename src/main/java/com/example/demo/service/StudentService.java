package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;

import java.util.List;

public interface StudentService {
    public List<Student> findAll();
    public Student findById(int id);
    public void deleteStudent(int id);
    public void addStudent(Student std);
    public List<Student> getStudentsByMajor(String major);
    public List<Course> getCoursesByStudentId(Long studentId);
}
