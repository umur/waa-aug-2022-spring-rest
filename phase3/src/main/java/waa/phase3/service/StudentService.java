package waa.phase3.service;

import waa.phase3.dto.CourseDto;
import waa.phase3.dto.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> findAll();

    void save(StudentDto student);

    void deleteById(int id);

    StudentDto findById(int id);

    void update(int id, StudentDto student);

    List<CourseDto> getCoursesByStudentId(int studentId);

    List<StudentDto> getStudentsByMajor(String major);
}
