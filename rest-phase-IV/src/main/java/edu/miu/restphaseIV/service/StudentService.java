package edu.miu.restphaseIV.service;

import edu.miu.restphaseIV.dto.CourseDto;
import edu.miu.restphaseIV.dto.StudentDto;

import java.util.List;

public interface StudentService {

    StudentDto save(StudentDto studentDto);
    void update(StudentDto studentDto);
    StudentDto delete(int id);
    StudentDto getById(int id);
    List<StudentDto> getAll();
    List<CourseDto> getCoursesByStudentId(int studentId);
    List<CourseDto> addCourseToStudent(int id, int courseId);
    List<CourseDto> deleteCourseFromStudent(int id, int courseId);
    List<StudentDto> getStudentsByMajor(String major);


}
