package waa.service;

import waa.domain.Course;
import waa.domain.Student;

import java.util.List;


public interface StudentService {
    Student createStudent(Student student);
    List<Student> findAllStudents();
    Student findStudentById(Integer studentId);
    List<Student> findStudentByMajor(String major);
    Student updateStudent(Student student) throws Exception;
    Student removeStudentById(Integer studnetId) throws Exception;
    List<Course> findCoursesByStudentId(Integer studnetId);
}
