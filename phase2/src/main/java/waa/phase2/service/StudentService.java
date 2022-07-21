package waa.phase2.service;

import waa.phase2.dto.StudentDto;
import waa.phase2.entity.Course;
import waa.phase2.entity.Student;

import java.util.List;

public interface StudentService {
    List<StudentDto> findAll();

    void save(StudentDto student);

    void deleteById(int id);

    void update(int id, StudentDto student);

    List<Course> getCoursesByStudentId(int studentId);

    List<Student> getStudentsByMajor(String major);
}
