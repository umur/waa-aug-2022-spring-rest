package waa.service;


import org.springframework.stereotype.Service;
import waa.dto.CourseDTO;
import waa.dto.StudentDTO;

import java.util.List;

@Service
public interface StudentService {
    StudentDTO createStudent(StudentDTO studentDTO);
    List<StudentDTO> findAllStudents();
    StudentDTO findStudentById(Integer studentId);
    List<StudentDTO> findStudentByMajor(String major);
    StudentDTO updateStudent(StudentDTO student) throws Exception;
    StudentDTO removeStudentById(Integer studentId) throws Exception;
    List<CourseDTO> findCoursesByStudentId(Integer studentId);
}
