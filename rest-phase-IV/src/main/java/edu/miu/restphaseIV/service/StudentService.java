package edu.miu.restphaseIV.service;

import edu.miu.restphaseIV.dto.CourseDto;
import edu.miu.restphaseIV.dto.StudentDto;

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
