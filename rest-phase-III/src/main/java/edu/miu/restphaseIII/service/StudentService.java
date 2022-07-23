package edu.miu.restphaseIII.service;

import edu.miu.restphaseIII.dto.CourseDto;
import edu.miu.restphaseIII.dto.StudentDto;

import java.util.List;

public interface StudentService {

    void save(StudentDto studentDto);
    void update(StudentDto studentDto);
    void delete(int id);
    StudentDto getById(int id);
    List<StudentDto> getAll();
    List<CourseDto> getCoursesByStudentId(int studentId);
    List<StudentDto> getStudentsByMajor(String major);
}
