package phase1.service;

import phase1.entity.Course;
import phase1.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    Student save(Student s);
    void delete(int studentId);
    void update(int studentId, Student c);
    List<Student> getByMajor(String major);
    List<Course> getCoursesByStudentId(int studentId);
}
