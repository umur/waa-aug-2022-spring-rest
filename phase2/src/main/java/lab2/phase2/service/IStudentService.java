package lab2.phase2.service;

import lab2.phase2.domain.Course;
import lab2.phase2.domain.Student;
import lab2.phase2.dto.CourseDTO;
import lab2.phase2.dto.StudentDTO;

import java.util.List;

public interface IStudentService {
    Boolean create(StudentDTO stu);
    List<StudentDTO> read();
    Boolean update(int id, StudentDTO stu);
    Boolean delete(int id);
    List<StudentDTO> getStudentsByMajor(String major);
    List<CourseDTO> getCoursesByStudentId(int studentId);
}
