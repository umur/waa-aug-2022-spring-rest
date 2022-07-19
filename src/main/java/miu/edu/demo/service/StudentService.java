package miu.edu.demo.service;

import miu.edu.demo.dto.CourseDTO;
import miu.edu.demo.dto.StudentDTO;
import miu.edu.demo.entity.Course;
import miu.edu.demo.entity.Student;

import java.util.List;

public interface StudentService {
    List<StudentDTO> getStudentsByMajor(String major);

    List<CourseDTO> getCoursesByStudentId(int studentId);

    List<StudentDTO> getStudents();

    StudentDTO getStudentById(int id);

    void addStudent(StudentDTO studentDTO);

    void updateStudent(int id, StudentDTO studentDTO);

    StudentDTO addCourseToStudent(int studentId, int courseId);
}
