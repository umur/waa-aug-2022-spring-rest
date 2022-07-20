package com.miu.demo.Service;
import com.miu.demo.Domain.Course;
import com.miu.demo.Domain.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student findById(Long id);

    Student save(Student student);

    Student update(Student student, Long id);

    void remove(Long id);

    List<Student> getStudentsByMajor(String major);

    List<Course> getCoursesByStudentId(Long studentId);
}