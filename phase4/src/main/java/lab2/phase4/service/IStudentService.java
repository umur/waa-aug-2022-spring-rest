package lab2.phase4.service;

import lab2.phase4.domain.Course;
import lab2.phase4.domain.Student;
import lab2.phase4.dto.CourseDTO;
import lab2.phase4.dto.StudentDTO;

import java.util.List;

public interface IStudentService {
    Boolean create(StudentDTO stu);
    List<StudentDTO> read();
    Boolean update(int id, StudentDTO stu);
    Boolean delete(int id);
    List<StudentDTO> getStudentsByMajor(String major);
    List<CourseDTO> getCoursesByStudentId(int studentId);
}
