package edu.miu.RestDemoApplication.service;

import edu.miu.RestDemoApplication.dto.CourseDTO;
import edu.miu.RestDemoApplication.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    List<StudentDTO> findAll();
    StudentDTO findByID(long id);
    StudentDTO addStudent(StudentDTO studentDTO);
    StudentDTO updateStudent(StudentDTO studentDTO);
    List<StudentDTO> getStudentsByMajor(String major);
    List<CourseDTO> getCoursesByStudentID(long id);
    void removeStudentByID(long id);
}
