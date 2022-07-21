package waa.phase1.service;

import waa.phase1.entity.Course;
import waa.phase1.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    void save(Student student);

    void deleteById(int id);

    void update(int id, Student student);

    List<Course> getCoursesByStudentId(int studentId);

    List<Student> getStudentsByMajor(String major);
}
