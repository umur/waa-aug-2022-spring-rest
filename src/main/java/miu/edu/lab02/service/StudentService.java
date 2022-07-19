package miu.edu.lab02.service;

import miu.edu.lab02.model.Course;
import miu.edu.lab02.model.Student;

import java.util.List;
import java.util.Optional;

interface StudentService {
    List<Student> findAll();

    Student save(Student student);

    Student update(Integer id, Student student);

    Optional<Student> findOne(Integer id);

    void delete(Integer id);

    Student addCourse(Integer studentId, String courseCode);

    Student removeCourse(Integer studentId, String courseCode);

    List<Student> getStudentsByMajor(String major);

    List<Course> getCoursesByStudentId(Integer id);
}
