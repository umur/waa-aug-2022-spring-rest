package lab2.phase2.service;

import lab2.phase2.domain.Course;
import lab2.phase2.domain.Student;
import lab2.phase2.dto.CourseDTO;

import java.util.List;

public interface ICourseService {
    Boolean create(CourseDTO stu);
    List<CourseDTO> read();
    Boolean update(int id, CourseDTO stu);
    Boolean delete(int id);
}
