package miu.edu.demo.service;

import miu.edu.demo.entity.Course;
import miu.edu.demo.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudentsByMajor(String major);

    List<Course> getCoursesByStudentId(int studentId);
}
