package lab2.phase1.service;

import lab2.phase1.domain.Course;
import lab2.phase1.domain.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getStudentsByMajor(String major);
    List<Course> getCoursesByStudentId(int studentId);
}
