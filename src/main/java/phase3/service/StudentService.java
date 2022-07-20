package phase3.service;

import phase3.dto.CourseDto;
import phase3.dto.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> findAll();
    StudentDto save(StudentDto s);
    void delete(int studentId);
    void update(int studentId, StudentDto s);
    List<StudentDto> getByMajor(String major);
    List<CourseDto> getCoursesByStudentId(int studentId);
}
