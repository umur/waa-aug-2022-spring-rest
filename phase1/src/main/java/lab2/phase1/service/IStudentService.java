package lab2.phase1.service;

import lab2.phase1.domain.Course;
import lab2.phase1.domain.Student;

import java.util.List;

public interface IStudentService {
    Boolean create(Student stu);
    List<Student> read();
    Boolean update(int id, Student stu);
    Boolean delete(int id);
    List<Student> getStudentsByMajor(String major);
    List<Course> getCoursesByStudentId(int studentId);
}
