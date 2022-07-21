package com.lab2.phase1.service;

import com.lab2.phase1.entity.Course;
import com.lab2.phase1.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    void save(Student student);

    boolean delete(int id);

    Student findById(int id);

    void update(int id,Student student);

    List<Student> getStudentsByMajor(String major);

    List<Course> getCoursesByStudentId(int studentId);
}
