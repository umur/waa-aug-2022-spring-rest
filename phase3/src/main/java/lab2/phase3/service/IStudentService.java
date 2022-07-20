package lab2.phase3.service;

import lab2.phase3.domain.Course;
import lab2.phase3.domain.Student;
import lab2.phase3.dto.CourseDTO;
import lab2.phase3.dto.StudentDTO;

import java.util.List;

public interface IStudentService {
    Boolean create(StudentDTO stu);
    List<StudentDTO> read();
    Boolean update(int id, StudentDTO stu);
    Boolean delete(int id);
    List<StudentDTO> getStudentsByMajor(String major);
    List<CourseDTO> getCoursesByStudentId(int studentId);
}
