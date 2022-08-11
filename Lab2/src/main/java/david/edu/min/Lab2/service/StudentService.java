package david.edu.min.Lab2.service;

import david.edu.min.Lab2.entity.Course;
import david.edu.min.Lab2.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAll();
    void save(Student s);
    void deleteById(int studentId);
    void update(int studentId,Student s);
    Student getById(int studentId);
    List<Student> getStudentsByMajor(String major);
    List<Course> getCoursesByStudentId(int studentId);
}
